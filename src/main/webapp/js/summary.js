// Create uPortal namespace "up" if it doesn't exist
window.up = window.up || {};

/*
 * Start Survey Summary AngularJS app.
 *
 * Capture parameters, load angularJS if it is not loaded and bootstrap the app.
 * NOTE!! -- Cannot use ngApp since we are in a portal. App must be started with angular.boostrap().
 */
window.up.startSurveySummaryApp = function(window, params) {
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
        console.log(window.up.ngApp);
        register(window.up.ngApp);
        // TODO: Should register() be replaced with boostrap() ?
    }

    /*
     * Set up Survey Summary AngularJS app.
     *
     * Create app, register components and kick off app tied to portlet div.
     */
    function bootstrap() {
        var MODULE_NAME = params.n + '-survey-summary';
        var app = angular.module(MODULE_NAME, []);
        app.value("surveyName", params.surveyName);
        register(app);
        angular.bootstrap(document.getElementById(params.n + '-survey-summary-portlet'), [MODULE_NAME]);
    }

    /*
     * Register components in Survey Summary AngularJS app.
     *
     * Add directives, controllers and services to app.
     */
    function register(app) {

        app.controller('summaryController', function($scope, surveyName, surveyApiService) {
            $scope.survey = {
                    title: "Test Title",
                    description: "Test Description"
            };
            $scope.summary = {
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

            surveyApiService.getSurveyByName(surveyName).success(function(response) {
                console.log(response);
                $scope.survey = response;
                if ($scope.survey.id) {
                    surveyApiService.getSummary($scope.survey.id).success(function(response) {
                        console.log(response);
                        $scope.summary = response;
                    });
                }
            });
        });  // summaryController

        app.factory('surveyApiService', function($http) {
            var surveyApi = {};

            surveyApi.getSurveyByName = function(surveyName) {
                return $http({
                    method: 'GET',
                    url: '/survey-portlet/v1/surveys/surveyByName/' + surveyName
                });
            }

            surveyApi.getSummary = function(surveyId) {
                return $http({
                    method: 'GET',
                    url: '/survey-portlet/v1/surveys/' + surveyId + "/summary"
                });
            }

            return surveyApi;
        });  // surveyApiService

    }  // register()
};  // window.up.startSurveySummaryApp()
