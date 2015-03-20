
package org.jasig.portlet.survey.service.jpa;

import java.util.List;
import org.jasig.portlet.survey.mvc.service.ISurveyDataService;
import org.jasig.portlet.survey.service.dto.AnswerDTO;
import org.jasig.portlet.survey.service.dto.QuestionDTO;
import org.jasig.portlet.survey.service.dto.SurveyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SurveyDataService implements ISurveyDataService {
    
    @Autowired
    private IJpaSurveyDao surveyDao;
    
    @Autowired
    private ISurveyMapper surveyMapper;
    
    @Override
    @Transactional(readOnly = true)
    public SurveyDTO getSurvey( long id) {
        JpaSurvey survey = surveyDao.getSurvey( id);
        if( survey == null) {
            return null;
        }
        
        return surveyMapper.toSurvey( survey);
    }

    @Override
    public List<SurveyDTO> getAllSurveys() {
        List<JpaSurvey> surveyList = surveyDao.getAllSurveys();
        if( surveyList == null) {
            return null;
        }
        
        return surveyMapper.toSurveyList( surveyList);
    }

    @Override
    public SurveyDTO createSurvey(SurveyDTO survey) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public QuestionDTO createQuestion(QuestionDTO question) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public AnswerDTO createAnswerForQuestion(Long questionId, AnswerDTO answer) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public SurveyDTO addQuestionToSurvey(Long surveyId, Long questionId) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
