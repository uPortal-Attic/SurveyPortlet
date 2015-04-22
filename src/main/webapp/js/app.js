window.up = window.up || {};

window.up.startSurveyPortlet = function(window, _, params) {
    'use strict';
    
    var surveyName = params.surveyName || '';
    var n = params.n;

    var MODULE_NAME = n + '-survey-portlet';
    var PROFILE_ROOT = 'https://portal-mock-api-dev.herokuapp.com/api/';
    var USER = 'admin';

    if (!window.angular) {
        var ANGULAR_SCRIPT_ID = 'angular-uportal-script';

        var scr = document.getElementById(ANGULAR_SCRIPT_ID);

        if (!scr) {
            scr = document.createElement('script');
            scr.id =  ANGULAR_SCRIPT_ID;
            scr.type =  'text/javascript';
            scr.async =  true;
            scr.charset =  'utf-8';
            scr.src =  'https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular.js';

            document.body.appendChild(scr);
        }

        scr.addEventListener('load', bootstrap);
    } else {
        register(window.up.ngApp);
    }

    function bootstrap() {
        var app = angular.module(MODULE_NAME, []);
        register(app);
        angular.bootstrap(document.getElementById(n + '-survey-portlet'), [MODULE_NAME]);
    }

    function register(app) {
        app
        /**
         * @ngdoc function
         * @name ngPortalApp.controller:SurveyCtrl
         * @description
         * # SurveyCtrl
         * Controller of the ngPortalApp
         */
        .controller('SurveyCtrl', function ($scope, $http, $filter) {

            $http.get('/survey-portlet/v1/surveys/' + (surveyName ? 'surveyByName/' + surveyName : ''))
            .success(function(surveys) {
                $scope.surveys = _.isArray(surveys) ? surveys : [surveys];
            });

            $scope.toggle = function(o) {
                o = o || {};
                o.shown = !o.shown;
            };

            $http.get(PROFILE_ROOT + 'surveyAnswers', {
                params: {
                    user: USER,
                }
            }).success(function(d) {
                if (d && d.length && d[0].answers && d[0].answers.length) {
                    _.each(d[0].answers, function(ans) {
                        $scope.surveyData[ans.question] = ans.answer;
                    });
                    $scope.surveyData.id = d[0].id;
                }
            });

            $scope.saveAnswers = function(answers) {
                var method = answers.id ? 'PUT' : 'POST';
                var url = PROFILE_ROOT + 'surveyAnswers' + (answers.id ? '/' + answers.id : '');

                delete answers.id;
                delete answers.user;

                var data = {
                    answers: _.map(answers, function(a, q) {
                        return {question: q, answer: a};
                    }),
                    user: USER
                };

                $http({
                    method: method,
                    url: url,
                    data: data
                }).success(function(savedAnswers) {
                    answers.id = savedAnswers.id;
                });

            };

            $scope.save = function(survey) {
                var method = survey.id ? 'PUT' : 'POST';
                var base = '/survey-portlet/v1/surveys/';
                var url = survey.id ? base + survey.id : base ;

                $http({
                    method: method,
                    url: url,
                    data: survey,
                });

                survey = angular.copy(survey);

                _.each(survey.surveyQuestions, function(q, i) {
                    q = survey.surveyQuestions[i] = q.question;

                    // _.each(q.questionAnswers, function(a, j) {
                    //   q.questionAnswers[j] = a.answer;
                    // });

                    $http({
                        method: 'PUT',
                        url: base + 'questions/' + q.id,
                        data: q
                    });
                });

            };

            $scope.surveyData = {};
        })
        .directive('surveyQuestion', function () {
            /**
             * @ngdoc directive
             * @name ngPortalApp.directive#SurveyQuestion
             * @description A directive to display a survey question.
             * @restrict E
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
        })
        .directive('ngDrag', function (DragData) {
            return {
                restrict: 'A',
                link: function postLink(scope, element, iAttrs) {
                    element.attr('draggable', 'true');

                    element.on('dragstart', function(e) {
                        e.stopPropagation();
                        e.originalEvent.dataTransfer.setData('ngdrag/type', iAttrs.ngDrag || 'ngdrag/id');
                        e.originalEvent.dataTransfer.setData(iAttrs.ngDrag || 'ngdrag/id', scope.$id);
                        DragData.add(scope);
                    });
                }
            };
        })
        .directive('ngDrop', function(DragData) {

            /**
             * @ngdoc directive
             * @name uni.directive:ngDrop
             * @param ngDrop The expression to evaluate upon drop. If dropped element came from ngDrag, the ngDrag $scope is
             * available as $from.
             * @description Allows an expression to be evaluated upon drop. Event available as $event.
             * @restrict A
             */
            return {
                restrict: 'A',
                link: function postLink($scope, element, iAttrs) {

                    element.on('dragover', function(e) { e.preventDefault(); });

                    element.on('dragenter', function(e) {
                        e.preventDefault();
                        e.stopPropagation();
                        var type = e.originalEvent.dataTransfer.getData('ngdrag/type');
                        if(type === iAttrs.allowDrop) {
                            event.dataTransfer.dropEffect = 'move';
                        } else {
                            event.dataTransfer.dropEffect = 'none';
                        }
                    });

                    element.on('drop', function(e) {
                        e.preventDefault();

                        var id = e.originalEvent.dataTransfer.getData(iAttrs.allowDrop || 'ngdrag/id');
                        if(!id) { return; }
                        var from = DragData.get(id);

                        $scope.$apply(function() {
                            $scope.$eval(iAttrs.ngDrop, {
                                $from: from,
                                $event: e
                            });
                        });
                    });
                }
            };
        })
        .service('DragData', function () {
            /**
             * @ngdoc service
             * @name uni.service:DragData
             * @description
             * # dragger service in the sabApp.  */
            var index = {};

            this.add = function(scope) {
                if(scope.$id) {
                    index[scope.$id] = scope;
                }
            };

            this.get = function(id) {
                if(index[id]) {
                    return index[id];
                }
            };
        })
        .directive('modal', function ($document) {
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

                            if(modalHider) {
                                modalHider.remove();
                            }
                        }
                    });
                }
            };
        });
    }
};
