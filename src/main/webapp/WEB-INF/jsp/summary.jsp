<%--

    Licensed to Apereo under one or more contributor license
    agreements. See the NOTICE file distributed with this work
    for additional information regarding copyright ownership.
    Apereo licenses this file to you under the Apache License,
    Version 2.0 (the "License"); you may not use this file
    except in compliance with the License.  You may obtain a
    copy of the License at the following location:

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
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

<div id="${n}-survey-summary-portlet" ng-cloak class="summary" ng-controller="summaryController">
    <header>
        <h3 class="title">{{survey.title}}</h3>
        <p class="description">{{survey.description}}</p>
        <p class="responseCount">Total Responses = {{summary.responseCount}}</p>
    </header>
    <section class="question" ng-repeat="questionData in survey.surveyQuestions">
        <table>
            <thead><tr><th colspan="2">{{questionData.question.text}}</th></tr></thead>
            <tbody>
                <tr ng-repeat="answerData in questionData.question.questionAnswers">
                    <td>{{summary.answerCounts[questionData.question.text][answerData.answer.text] || 0}}</td>
                    <td>{{answerData.answer.text}}</td>
                </tr>
            </tbody>
        </table>
    </section>
</div>

<script id="survey-portlet-script" src="${pageContext.request.contextPath}/js/summary.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    window.up.startSurveySummaryApp(window, {
        n: '${n}',
        surveyName: "${portletPreferencesValues['surveyName'][0]}"
    });
</script>
