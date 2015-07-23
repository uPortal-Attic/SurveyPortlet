// Create uPortal namespace "up" if it doesn't exist
window.up = window.up || {};

/*
 * Start Survey Summary AngularJS app.
 *
 * Capture parameters, load angularJS if it is not loaded and bootstrap the app.
 * NOTE!! -- Cannot use ngApp since we are in a portal. App must be started with angular.boostrap().
 */
window.up.startSurveyApp = function(window, _, params) {
    'use strict';

    if (!window.angular) {
        // Angular not defined, look for <script>
        var ANGULAR_SCRIPT_ID = 'angular-uportal-script';
        var scr = document.getElementById(ANGULAR_SCRIPT_ID);
        if (!scr) {
            // Load angular.js via <script>
            scr = document.createElement('script');
            scr.id =  ANGULAR_SCRIPT_ID;
            scr.type =  'text/javascript';
            scr.async =  true;
            scr.charset =  'utf-8';
            scr.src =  'https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular.js';
            document.body.appendChild(scr);
        }
        // Call boostrap() on script load
        scr.addEventListener('load', bootstrap);
    } else {
        bootstrap();
    }

    /*
     * Set up Survey Summary AngularJS app.
     *
     * Create app, register components and kick off app tied to portlet div.
     */
    function bootstrap() {
        var MODULE_NAME = params.n + '-survey-portlet';
        var app = angular.module(MODULE_NAME, []);
        app.value("surveyName", params.surveyName);
        app.value("user", params.user);
        register(app);
        angular.bootstrap(document.getElementById(params.n + '-survey-portlet'), [MODULE_NAME]);
    }

    /*
     * Register components in Survey Summary AngularJS app.
     *
     * Add directives, controllers and services to app.
     */
    function register(app) {

        app.controller('surveyController', function($scope, surveyName, user, surveyApiService) {

            $scope.surveyData = {};

            // Load survey and user answers
            surveyApiService.getSurveyByName(surveyName).success(function(response) {
                console.log(response);
                $scope.survey = response;
                if ($scope.survey.id) {
                    surveyApiService.getUserAnswers(user, $scope.survey.id).success(function(response) {
                        console.log(response);
                        $scope.answers = response;
                        for (var j = 0; j < response.answers.length; j++) {
                            $scope.surveyData[response.answers[j].question] = response.answers[j].answer;
                        }
                        $scope.surveyData.id = response.id;
                    });
                }
            });

            // Display or hide parameter (i.e. dialog)
            $scope.toggle = function(o) {
                o = o || {};
                o.shown = !o.shown;
            };

            // callback to save user answers
            $scope.saveAnswers = function(answers, survey) {
                console.log(answers);

                var data = {
                    id: answers.id,
                    user: user,
                    survey: survey.id,
                    answers: _.chain(answers)
                                .omit('id')
                                .pairs()
                                .map(function(e) {
                                    return {question: Number(e[0]), answer: e[1]};
                                })
                                .value()
                };
                surveyApiService.saveUserAnswers(data).success(function(response) {
                    answers.id = response.id;
                });
            }

        });

        app.factory('surveyApiService', function($http) {
            var surveyApi = {};

            surveyApi.getSurveyByName = function(surveyName) {
                return $http({
                    method: 'GET',
                    url: '/survey-portlet/v1/surveys/surveyByName/' + surveyName
                });
            }

            surveyApi.getUserAnswers = function(user, surveyId) {
                return $http({
                    method: 'GET',
                    url: '/survey-portlet/v1/surveys/surveyAnswers',
                    params: {user: user, survey: surveyId}
                });
            }

            surveyApi.saveUserAnswers = function(data) {
                var verb = 'POST';
                var url = '/survey-portlet/v1/surveys/surveyAnswers';
                if (data.id) {
                    verb = 'PUT';
                    url += '/' + data.id;
                }
                console.log(data);
                return $http({
                    method: verb,
                    url: url,
                    data: data
                });
            }

            return surveyApi;
        });

        app.directive('modal', ["$document", function ($document) {
            return {
                template: '<ng-transclude></ng-transclude>',
                transclude: true,
                restrict: 'E',
                scope: {
                    shown: '=',
                    modalHide: '&?',
                    modalShow: '&?'
                },
                link: function postLink($scope, iEle) {
                    iEle.addClass('hidden');
                    var modalHider = angular.element('<div class="modal-hider"></div>');
                    var hasBeenShown;
                    $scope.$watch('shown', function(shown) {
                        if(shown) {
                            hasBeenShown = true;
                            iEle.removeClass('hidden');
                            modalHider.on('click', function() {
                                //Apparently $scope.$apply can't wrap the function passed to on()
                                $scope.$apply(function() {
                                    $scope.shown = !$scope.shown;
                                });
                            });
                            angular.element(document.body).append(modalHider);
                            if($scope.modalShow) {
                                $scope.modalShow();
                            }
                        } else {
                            iEle.addClass('hidden');
                            if(hasBeenShown && $scope.modalHide) {
                                $scope.modalHide();
                            }
                            modalHider.off('click');
                            if(modalHider) {
                                modalHider.remove();
                            }
                        }
                    });
                }
            };
        }]);

        app.directive('surveyQuestion', function () {
            /*
             * 'def' is the current SurveyQuestion
             * 'survey' is $scope.surveyData
             */
            return {
                template: '<section class="question">' +
                    '<label class="text">{{def.question.text}}</label>' +
                    '<div class="answer" ng-repeat="ans in def.question.questionAnswers | orderBy:\'sequence\'">' +
                    '<label title="{{ans.answer.altText}}" aria-label="{{ans.answer.altText}}" >' +
                    '<img ng-if="ans.answer.imgUrl" ng-src="{{ans.answer.imgUrl}}" height="25px" width="25px"></img>' +
                    '<input ng-if="def.numAllowedAnswers === 1" type="radio" ng-model="survey[def.question.id]" ng-value="ans.answer.id" />' +
                    '<input ng-if="def.numAllowedAnswers > 1" type="checkbox" ng-model="survey[def.question.id][ans.answer.id]"/>' +
                    '{{ans.answer.text}}' +
                    '</label>' +
                    '<span class="glyphicon glyphicon-info-sign" ng-if="ans.answer.helpText" title="{{ans.answer.helpText}}"></span>' +
                    '</div>' +
                    '</section>',
                restrict: 'E',
                scope: {
                    def: '=',
                    survey: '=',
                },
                link: function postLink($scope, iEle, iAttrs) {
                }
            };
        });
    }  // register()
};  // window.up.startSurveySummaryApp()
