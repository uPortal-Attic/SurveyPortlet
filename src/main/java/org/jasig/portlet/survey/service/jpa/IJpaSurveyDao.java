
package org.jasig.portlet.survey.service.jpa;

import java.util.List;


interface IJpaSurveyDao {

    public JpaSurvey getSurvey(Long id);
    public List<JpaSurvey> getAllSurveys();
    
    public JpaSurvey createSurvey(JpaSurvey survey);
    public JpaSurvey updateSurvey(JpaSurvey survey);
    
    public JpaQuestion createQuestion(JpaQuestion question);
    public JpaQuestionAnswer createQuestionAnswer(JpaQuestion question, JpaAnswer answer, Integer sequence);
    public JpaAnswer createAnswer(JpaAnswer answer);
    
    public JpaQuestion getQuestion( Long id);
    public JpaQuestion updateQuestion(JpaQuestion question);
    public JpaSurveyQuestion attachQuestionToSurvey( JpaSurvey survey, JpaQuestion question);
}
