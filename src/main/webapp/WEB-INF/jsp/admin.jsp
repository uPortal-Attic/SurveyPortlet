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
<!-- uportal-use-angular -->
<%@ page contentType="text/html" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>

<portlet:defineObjects/>

<c:set var="nc"><portlet:namespace/></c:set>
<c:set var="lc" value="${fn:toLowerCase(nc)}" />
<c:set var="n" value="${fn:replace(lc, '_', '')}"/>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/survey.css" type="text/css" charset="utf-8">

<div id="${n}-survey-portlet" ng-cloak class="surveys" ng-controller="SurveyCtrl">
    <section
        class="survey"
        ng-repeat="survey in surveys"
        ng-init="current = {q:0}; survey.editable = true">
        <header>
            <span class="title">{{survey.title}}:</span>
            <span class="description">{{survey.description}}</span>
            <a class="btn btn-md btn-warning" ng-click="edit = !edit">Edit Survey <span class="glyphicon glyphicon-pencil"></span></a>
            <a class="btn btn-md btn-success" ng-click="toggle(survey)">Show Survey <span class="glyphicon glyphicon-chevron-right"></span></a>
        </header>

        <modal class="survey-modal modal-content clearfix" shown="survey.shown">
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
                    <survey-question def="(survey.surveyQuestions | orderBy:'sequence')[current.q]" survey="surveyData"></survey-question>
                </div>
                <div class="modal-footer">
                    <a class="btn btn-primary btn-lg" ng-click="save(survey, surveyData)")>Save</a>
                    <a class="btn btn-warning btn-lg" ng-click="toggle(survey)">Cancel</a>
                </div>
            </div>
        </modal>

        <!-- Edit Mode -->
        <div class="edit-mode" ng-show="edit">
            <div class="col-sm-12">
            </div>
            <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label" for="title-{{$index}}">Title</label>
                <div class="col-sm-10">
                    <input
                    class="form-control"
                    required
                    ng-model="survey.title"
                    type="text"
                    id="title-{{$index}}"
                    placeholder="Title">
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label" for="title-{{$index}}">Desription</label>
                <div class="col-sm-10">
                    <input
                    class="form-control"
                    required
                    ng-model="survey.description"
                    type="text"
                    id="description-{{$index}}"
                    placeholder="Title">
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label" for="title-{{$index}}">Unique Name</label>
                <div class="col-sm-10">
                    <input
                    class="form-control"
                    required
                    ng-model="survey.canonicalName"
                    type="text"
                    id="description-{{$index}}"
                    placeholder="Title">
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
                        class="clearfix answer"
                        ng-drag="uni/question/{{::q.question.id}}"
                        allow-drop="uni/question/{{::q.question.id}}"
                        ng-drop="swapSeq(a, $from.a)";
                        ng-repeat="a in q.question.questionAnswers | orderBy:'sequence'">
                        <!-- Only can swap answers within question -->
                        <h3 class="col-sm-12"> Answer {{$index+1}} -- {{a.answer.text}}</h3>

                        <div class="form-group form-group-sm">
                          <label class="col-sm-2 control-label" for="canonicalName-{{$index}}">Canonical Name</label>
                          <input class="form-control" ng-model="a.canonicalName" id="canonicalName-{{$index}}">
                        </div>
                        
                        <div class="form-group form-group-sm" ng-repeat="(k, v) in a.answer">
                            <label class="col-sm-2 control-label" for="{{k}}">{{k}}</label>
                            <div class="col-sm-10 col-lg-4">
                                <input class="form-control" ng-model="a.answer[k]" type="text" id="{{k}}" placeholder="{{k}}">
                            </div>
                        </div>

                        <div class="form-group form-group-sm">
                          <label class="col-sm-2 control-label" for="value-{{$index}}">Value</label>
                          <input class="form-control" ng-model="a.value" id="value-{{$index}}">
                        </div>
                    </div>
                    <a ng-click="addA(q.question)" class="btn btn-sm btn-success">Add Answer</a>
                </div>
            </div>
            <div class="col-sm-12">
                <a ng-click="save(survey)" class="pull-right btn btn-success btn-lg">
                    Save Survey
                    <span class="glyphicon glyphicon-save"></span>
                </a>

                <a ng-click="addQ(survey)" class="btn btn-success btn-lg">
                    Add Question
                </a>
            </div>
        </div>
    </section>
    <a ng-click="surveys.push({status: 'UNPUBLISHED', canonicalName: ''})" class="btn btn-success btn-md">Add Survey</a>
</div>

<script id="survey-portlet-script" src="${pageContext.request.contextPath}/js/app.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    window.up.startSurveyPortlet(window, up._, {
        n: '${n}'
    });
</script>
