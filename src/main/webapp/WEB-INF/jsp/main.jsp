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

<script id="${n}-script" src="${pageContext.request.contextPath}/js/admin.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    document.getElementById("${n}-script").on('load', function() {
        window.up.startSurveyPortlet(window, Underscore, '${n}');
    });
</script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/survey.css" type="text/css" charset="utf-8">

<div id="${n}-survey-portlet" ng-cloak class="surveys" ng-controller="SurveyCtrl">
    <section
        class="survey"
        ng-show="survey.surveyQuestions.length"
        ng-init="current = {q:0}; survey.editable = true">
        <header>
            <span class="title">{{survey.title}}:</span>
            <span class="description">{{survey.description}}</span>
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
                <a class="btn btn-primary btn-lg" ng-click="save(surveyData)")>Save</a>
                <a class="btn btn-warning btn-lg" ng-click="toggle(survey)">Cancel</a>
            </div>
        </div>
        </${n}-modal>
    </section>
</div>
