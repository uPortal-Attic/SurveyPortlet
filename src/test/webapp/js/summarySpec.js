/*
 * Licensed to Apereo under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Apereo licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
'use strict';

window.up.startSurveySummaryApp(window, {n: 'test', surveyName: 'surTest'});

describe('SurveySummaryApp', function() {

    var $rootScope, $scope, $controller, surveyTest, summaryTest;

    // retrieve the module created above test
    beforeEach(module('test-survey-summary'));

    // set local vars to controller and scopes
    beforeEach(inject(function(_$rootScope_, _$controller_, $httpBackend) {
        $rootScope = _$rootScope_;
        $scope = $rootScope.$new();
        $controller = _$controller_;

        // test data
        surveyTest = {
                title: "Test Title",
                id: 8,
                description: "Test Description"
        };
        summaryTest = {
                "responseCount": 1,
                "answerCounts": {
                        "Please indicate the type of childcare needed to attend college":
                                {"Onsite/Child Development Center":1},
                        "Please indicate the number of hours you are currently employed":
                                {"1-10 hours":1},
                        "Indicate the types of courses you desire to take":
                                {"Face-to-face courses":1,
                                 "Hybrid (both online and face-to-face courses)":1,
                                 "Online (including telecourse)":1}}};


        // controller gets a survey and answers
        $httpBackend.expect('GET', '/survey-portlet/v1/surveys/surveyByName/surTest')
            .respond(200, JSON.stringify(surveyTest));
        $httpBackend.expect('GET', '/survey-portlet/v1/surveys/8/summary')
            .respond(200, JSON.stringify(summaryTest));

        // create controller
        $controller('summaryController', {'$rootScope': $rootScope, '$scope': $scope});
        $httpBackend.flush();
    }));

    it('survey name should be provided', inject(function(surveyName) {
        expect(surveyName).toEqual('surTest');
    }));

    it('survey should be attached to scope', function() {
        expect($scope.survey).toEqual(surveyTest);
    });

    it('should get a survey', inject(function(surveyApiService, $httpBackend) {
        $httpBackend.expect('GET', '/survey-portlet/v1/surveys/surveyByName/sTest')
            .respond(200, '{"success": "true","id": 123 }');

        surveyApiService.getSurveyByName('sTest')
            .success(function(response) {
                expect(response.id).toEqual(123);
                expect(response.success).toBeTruthy();
        });

        $httpBackend.flush();
    }));
})