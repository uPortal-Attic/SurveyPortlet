//window.up.startSurveySummaryApp(window, {n: 'test', surveyName: 'surTest'});
angular.module('test-survey-summary', [])
    .value('surveyName', 'surTest');

describe('SurveySummaryApp', function() {

    beforeEach(module('test-survey-summary'));

/*
    it('survey name should be provided', inject(function(surveyName) {
        expect(surveyName).toEqual('surTest');
    }));

    var summaryController;

    beforeEach(inject(function(_summaryController_) {
        summaryController = _summaryController_;
    }));*/

})