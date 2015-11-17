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

window.up.startSurveyApp(window, _, {n: 'test', surveyName: 'surTest'});

describe('SurveyApp', function() {

    var $rootScope, $scope, $controller, surveyTest, surveyAnswers;

    // retrieve the module created above test
    beforeEach(module('test-survey-portlet'));

    // set local vars to controller and scopes
    beforeEach(inject(function(_$rootScope_, _$controller_, $httpBackend) {
        $rootScope = _$rootScope_;
        $scope = $rootScope.$new();
        $controller = _$controller_;

        // test data
        surveyTest = {
                "title": "Test Title",
                "id": 8,
                "description": "Test Description",
                "altText": null,
                "canonicalName": "surTest",
                "definitionText": null,
                "helpText": null,
                "lastUpdateDate": 1436282602016,
                "lastUpdateUser": "admin",
                "status": "PUBLISHED",
                "surveyQuestions": [
                    {
                        "numAllowedAnswers": 1,
                        "question":
                            {
                                "altText": "I volunteer",
                                "canonicalName": "volunteer",
                                "helpText": null,
                                "id": 18,
                                "questionAnswers": [
                                    {
                                        "answer":
                                            {
                                                "altText": "Rarely",
                                                "helpText": null,
                                                "id": 302,
                                                "imgHeight": null,
                                                "imgUrl": null,
                                                "imgWidth": null,
                                                "text": "Rarely"
                                            },
                                        "canonicalName": "volunteerRarely",
                                        "logic": null,
                                        "sequence": 2,
                                        "value": null
                                    },
                                    {
                                        "answer":
                                            {
                                                "altText": "Sometimes",
                                                "helpText": null,
                                                "id": 303,
                                                "imgHeight": null,
                                                "imgUrl": null,
                                                "imgWidth": null,
                                                "text": "Sometimes"
                                            },
                                        "canonicalName": "volunteerSometimes",
                                        "logic": null,
                                        "sequence": 3,
                                        "value": null
                                    },
                                    {
                                        "answer":
                                            {
                                                "altText": "Usually",
                                                "helpText": null,
                                                "id": 304,
                                                "imgHeight": null,
                                                "imgUrl": null,
                                                "imgWidth": null,
                                                "text": "Usually"
                                            },
                                        "canonicalName": "volunteerUsually",
                                        "logic": null,
                                        "sequence": 4,
                                        "value": null
                                    },
                                    {
                                        "answer":
                                            {
                                                "altText": "Never",
                                                "helpText": null,
                                                "id": 301,
                                                "imgHeight": null,
                                                "imgUrl": null,
                                                "imgWidth": null,
                                                "text": "Never"
                                            },
                                        "canonicalName": "volunteerNever",
                                        "logic": null,
                                        "sequence": 1,
                                        "value": null
                                    }],
                                "status": "PUBLISHED",
                                "text": "I volunteer my time to help others"
                            },
                        "sequence": 1
                    }],
                "text": null,
                "textKey": "test text"
        };
        surveyAnswers = {
                "id": 223,
                "survey": 8,
                "user": "student",
                "answers": [
                        {"question": 18, "answer": 303}
                ]
        };

        // controller gets a survey and answers
        $httpBackend.expect('GET', '/survey-portlet/v1/surveys/surveyByName/surTest')
            .respond(200, JSON.stringify(surveyTest));
        $httpBackend.expect('GET', '/survey-portlet/v1/surveys/surveyAnswers?survey=8')
            .respond(200, JSON.stringify(surveyAnswers));

        // create controller
        $controller('surveyController', {'$rootScope': $rootScope, '$scope': $scope});
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