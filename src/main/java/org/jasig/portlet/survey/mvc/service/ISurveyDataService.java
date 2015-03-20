
package org.jasig.portlet.survey.mvc.service;

import java.util.List;
import org.jasig.portlet.survey.service.dto.AnswerDTO;
import org.jasig.portlet.survey.service.dto.QuestionDTO;
import org.jasig.portlet.survey.service.dto.SurveyDTO;

public interface ISurveyDataService {
    public SurveyDTO getSurvey( long id);
    public List<SurveyDTO> getAllSurveys();
    
    public SurveyDTO createSurvey( SurveyDTO survey);
    public QuestionDTO createQuestion( QuestionDTO question);
    public AnswerDTO createAnswerForQuestion( Long questionId, AnswerDTO answer);
    
    public SurveyDTO addQuestionToSurvey( Long surveyId, Long questionId);
}
