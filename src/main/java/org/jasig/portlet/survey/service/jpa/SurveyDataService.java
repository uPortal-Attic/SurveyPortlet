package org.jasig.portlet.survey.service.jpa;

import com.google.common.collect.Lists;
import java.util.List;
import org.jasig.portlet.survey.SurveyState;
import org.jasig.portlet.survey.mvc.service.ISurveyDataService;
import org.jasig.portlet.survey.service.dto.AnswerDTO;
import org.jasig.portlet.survey.service.dto.QuestionDTO;
import org.jasig.portlet.survey.service.dto.SurveyDTO;
import org.jasig.portlet.survey.service.dto.SurveyQuestionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SurveyDataService implements ISurveyDataService {
    private final Logger log = LoggerFactory.getLogger( getClass());
    
    @Autowired
    private IJpaSurveyDao surveyDao;
    
    @Autowired
    private ISurveyMapper surveyMapper;
    
    /**
     * Search for {@link JpaSurvey} specified by id.
     * @param id
     * @return 
     */
    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public SurveyDTO getSurvey( long id) {
        JpaSurvey survey = surveyDao.getSurvey( id);
        if( survey == null) {
            return null;
        }
        
        return surveyMapper.toSurvey( survey);
    }

    /**
     * Return all surveys
     * @return 
     */
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<SurveyDTO> getAllSurveys() {
        List<JpaSurvey> surveyList = surveyDao.getAllSurveys();
        if( surveyList == null) {
            return null;
        }
        
        return surveyMapper.toSurveyList( surveyList);
    }

    /**
     * Create a {@link JpaSurvey} from the data in survey
     * @param survey
     * @return 
     */
    @Override
    public SurveyDTO createSurvey(SurveyDTO survey) {
        // remove questions/answers if they are present
        // only create the survey
        JpaSurvey jpaSurvey = surveyMapper.toJpaSurvey( survey);
        jpaSurvey = surveyDao.createSurvey( jpaSurvey);
        return surveyMapper.toSurvey( jpaSurvey);
    }

    /**
     * Create a {@link JpaQuestion} from the data in question
     * @param question
     * @return 
     */
    @Transactional
    @Override
    public QuestionDTO createQuestion(QuestionDTO question) {
        JpaQuestion jpaQuestion = surveyMapper.toJpaQuestion( question);
        jpaQuestion = surveyDao.createQuestion( jpaQuestion);
        
        QuestionDTO newQuestion = surveyMapper.toQuestion( jpaQuestion);
        
        return newQuestion;
    }

    /**
     * Create a {@link JpaQuestion} from the data in question
     * and associate it to the survey specified by id
     * @param surveyId
     * @param question
     * @return 
     */
    @Transactional
    @Override
    public QuestionDTO createQuestionForSurvey(Long surveyId, QuestionDTO question) {
        JpaQuestion jpaQuestion = surveyMapper.toJpaQuestion( question);
        jpaQuestion = surveyDao.createQuestion( jpaQuestion);    
    
        if( jpaQuestion != null) {
            // attach it to the survey
            JpaSurvey survey = surveyDao.getSurvey( surveyId);
            surveyDao.attachQuestionToSurvey(survey, jpaQuestion);
        }
        
        return surveyMapper.toQuestion( jpaQuestion);
    }
    
    /**
     * 
     * @param questionId
     * @param answer
     * @return 
     */
    @Transactional
    @Override
    public AnswerDTO createAnswerForQuestion(Long questionId, AnswerDTO answer) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    /**
     * 
     * @param surveyId
     * @param questionId
     * @return 
     */
    @Transactional
    @Override
    public SurveyDTO addQuestionToSurvey(Long surveyId, Long questionId) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    /**
     * Update question details including embedded answer data
     * @param question
     * @return {@link QuestionDTO} or null on error
     */
    @Transactional
    @Override
    public QuestionDTO updateQuestion(QuestionDTO question) {
        JpaQuestion existingQuestion = surveyDao.getQuestion( question.getId());
        if( existingQuestion.getStatus() == SurveyState.PUBLISHED) {
            log.info( "Cannot update question in PUBLISHED state");
            return null;
        }
        
        JpaQuestion jpaQuestion = surveyMapper.toJpaQuestion( question);
        jpaQuestion = surveyDao.updateQuestion( jpaQuestion);
        
        return surveyMapper.toQuestion( jpaQuestion);
    }

    /**
     * Search for survey questions for the specified survey.
     * Return only the question data.
     * @param surveyId
     * @return 
     */
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<SurveyQuestionDTO> getSurveyQuestions(Long surveyId) {
        JpaSurvey survey = surveyDao.getSurvey( surveyId);
        if( survey == null) {
            return null;
        }
        
        SurveyDTO surveyDTO = surveyMapper.toSurvey( survey); 
        
        return Lists.newArrayList( surveyDTO.getSurveyQuestions());
    }

    /**
     * 
     * @param survey
     * @return 
     */
    @Override
    public SurveyDTO updateSurvey(SurveyDTO survey) {
        JpaSurvey existingSurvey = surveyDao.getSurvey( survey.getId());
        if( existingSurvey == null || existingSurvey.getStatus() == SurveyState.PUBLISHED) {
            log.warn( "Cannot update survey");
            return null;
        }
        
        // remove question/answer elements
        survey.setSurveyQuestions( null);
        
        JpaSurvey jpaSurvey = surveyMapper.toJpaSurvey( survey);
        jpaSurvey = surveyDao.updateSurvey( jpaSurvey);
        
        return surveyMapper.toSurvey(jpaSurvey);
    }

}
