<%--

    Licensed to Jasig under one or more contributor license
    agreements. See the NOTICE file distributed with this work
    for additional information regarding copyright ownership.
    Jasig licenses this file to you under the Apache License,
    Version 2.0 (the "License"); you may not use this file
    except in compliance with the License. You may obtain a
    copy of the License at:

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on
    an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied. See the License for the
    specific language governing permissions and limitations
    under the License.

--%>
<%@ page contentType="text/html" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>

<portlet:defineObjects/>

<c:set var="nc"><portlet:namespace/></c:set>
<c:set var="lc" value="${fn:toLowerCase(nc)}" />
<c:set var="n" value="${fn:replace(lc, '_', '')}"/>

<div id="${n}-survey-portlet" ng-cloak class="surveys" ng-controller="SurveyCtrl">
    <section
        class="survey"
        ng-repeat="survey in surveys"
        ng-show="survey.surveyQuestions.length"
        ng-init="current = {q:0}; survey.editable = true">
        <header>
            <span class="title">{{survey.title}}:</span>
            <span class="description">{{survey.description}}</span>
            <a class="btn btn-md btn-warning" ng-click="edit = !edit">Edit Survey <span class="glyphicon glyphicon-pencil"></span></a>
            <a class="btn btn-md btn-success" ng-click="toggle(survey)">Show Survey <span class="glyphicon glyphicon-chevron-right"></span></a>
        </header>

        <${n}-modal class="survey-modal modal-content clearfix" shown="survey.shown">
        <header class="modal-header">
            <span class="title">{{survey.title}}:</span>
            <span class="description">{{survey.description}}</span>
        </header>
        <div class="modal-body">
            <div class="question">
                <div class="clearfix survey-nav">
                    Question {{current.q+1}} of {{survey.surveyQuestions.length}}
                    <div class="pull-right">
                        <a class="btn btn-success btn-lg" ng-disabled="current.q < 1" ng-click="current.q = current.q-1">
                            Prev
                            <span class="glyphicon glyphicon-chevron-left"></span>
                        </a>
                        <a
                            class="btn btn-success btn-lg"
                            ng-disabled="current.q >= survey.surveyQuestions.length-1"
                            ng-click="current.q = current.q+1">
                            Next <span class="glyphicon glyphicon-chevron-right"></span>
                        </a>
                    </div>
                </div>
                <${n}-survey-question def="(survey.surveyQuestions | orderBy:'sequence')[current.q]" survey="surveyData"></${n}-survey-question>
            </div>
            <div class="modal-footer">
                <a class="btn btn-primary btn-lg" ng-click="save(survey, surveyData)")>Save</a>
                <a class="btn btn-warning btn-lg" ng-click="toggle(survey)">Cancel</a>
            </div>
        </div>
        </${n}-modal>

        <!-- Edit Mode -->
        <div class="edit-mode" ng-show="edit">
            <div class="col-sm-12">
                <a ng-click="save(survey)" class="col-sm-2 btn btn-success btn-lg">Save <span class="glyphicon glyphicon-save"></span></a>
            </div>
            <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label" for="title-{{$index}}">Title</label>
                <div class="col-sm-10">
                    <input class="form-control" ng-model="survey.title" type="text" id="title-{{$index}}" placeholder="Title">
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label" for="title-{{$index}}">Desription</label>
                <div class="col-sm-10">
                    <input class="form-control" ng-model="survey.description" type="text" id="description-{{$index}}" placeholder="Title">
                </div>
            </div>

            <!-- Only can swap questions within survey -->
            <div
                class="col-sm-12 question"
                ng-drag="uni/survey/{{::survey.id}}"
                allow-drop="uni/survey/{{::survey.id}}"
                ng-drop="swapSeq(q, $from.q)"
                ng-repeat="q in survey.surveyQuestions | orderBy:'sequence'">

                <h2 ng-click="collapsed = !collapsed" class="col-sm-12">
                    Question {{$index+1}} -- {{q.question.canonicalName}}
                    <span class="glyphicon glyphicon-chevron-down collapser" ng-class="{'flipped': collapsed}"></span>
                </h2>
                <div class="content clearfix" ng-show="!collapsed">

                    <div class="clearfix">
                        <div class="form-group form-group-sm">
                            <label class="col-sm-2 control-label" for="allowed-answers">Allowed Answers</label>
                            <div class="col-sm-10 col-lg-4">
                                <input class="form-control" ng-model="q.numAllowedAnswers" type="number" id="allowed-answers" placeholder="Small input">
                            </div>
                        </div>
                        <div class="form-group form-group-sm" ng-repeat="(k, v) in q.question" ng-show="k != 'questionAnswers'">
                            <label class="col-sm-2 control-label" for="{{k}}">{{k}}</label>
                            <div class="col-sm-10 col-lg-4">
                                <input class="form-control" type="text" ng-model="q.question[k]" id="{{k}}" placeholder="{{k}}">
                            </div>
                        </div>
                    </div>

                    <div
                        class="answer"
                        ng-drag="uni/question/{{::q.question.id}}"
                        allow-drop="uni/question/{{::q.question.id}}"
                        ng-drop="swapSeq(a, $from.a)";
                        ng-repeat="a in q.question.questionAnswers | orderBy:'sequence'">
                        <!-- Only can swap answers within question -->
                        <h3 class="col-sm-12"> Answer {{$index+1}} -- {{a.answer.text}}</h3>
                        <div class="form-group form-group-sm" ng-repeat="(k, v) in a.answer">
                            <label class="col-sm-2 control-label" for="{{k}}">{{k}}</label>
                            <div class="col-sm-10 col-lg-4">
                                <input class="form-control" ng-model="a.answer[k]" type="text" id="{{k}}" placeholder="{{k}}">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>

<script type="text/javascript" charset="utf-8">
    (function(window, _) {
        var MODULE_NAME = '${n}-survey-portlet';
        var PROFILE_ROOT = 'https://portal-mock-api-dev.herokuapp.com/api/';
        var USER = 'admin';

        if (!window.angular) {
            var ANGULAR_SCRIPT_ID = 'angular-uportal-script';

            var scr = document.getElementById(ANGULAR_SCRIPT_ID);

            if (!scr) {
                scr = document.createElement('script');
                scr.type = 'text/javascript';
                scr.id = ANGULAR_SCRIPT_ID;
                scr.async = true;
                scr.charset = 'utf-8';
                scr.src = 'https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular.js';
                document.body.appendChild(scr);
            }

            scr.addEventListener('load', bootstrap);
        } else {
            register(window.up.ngApp);
        }

        function bootstrap() {
            var app = angular.module(MODULE_NAME, []);
            register(app);
            angular.bootstrap(document.getElementById('${n}-survey-portlet'), [MODULE_NAME]);
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

                $http.get('/survey-portlet/v1/surveys/')
                .success(function(surveys) {
                    $scope.surveys = surveys;
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
                    if (d.length > 0) {
                        $scope.surveyData = d[0];
                    }
                });

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
            .directive('${n}SurveyQuestion', function () {
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
            .directive('${n}Modal', function ($document) {
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
    })(window, up._)
</script>
