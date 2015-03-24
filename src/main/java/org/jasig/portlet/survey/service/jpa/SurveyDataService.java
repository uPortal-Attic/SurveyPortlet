package org.jasig.portlet.survey.service.jpa;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.jasig.portlet.survey.SurveyState;
import org.jasig.portlet.survey.mvc.service.ISurveyDataService;
import org.jasig.portlet.survey.service.dto.AnswerDTO;
import org.jasig.portlet.survey.service.dto.QuestionAnswerDTO;
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
    
    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public SurveyDTO getSurvey( long id) {
        JpaSurvey survey = surveyDao.getSurvey( id);
        if( survey == null) {
            return null;
        }
        
        return surveyMapper.toSurvey( survey);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
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
        // remove questions/answers if they are present
        // only create the survey
        JpaSurvey jpaSurvey = surveyMapper.toJpaSurvey( survey);
        jpaSurvey = surveyDao.createSurvey( jpaSurvey);
        return surveyMapper.toSurvey( jpaSurvey);
    }

    @Transactional
    @Override
    public QuestionDTO createQuestion(QuestionDTO question) {
        JpaQuestion jpaQuestion = surveyMapper.toJpaQuestion( question);
        jpaQuestion = surveyDao.createQuestion( jpaQuestion);
        
        QuestionDTO newQuestion = surveyMapper.toQuestion( jpaQuestion);
        
        return newQuestion;
    }

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
    
    private List<QuestionAnswerDTO> createQuestionAnswer(JpaQuestion question, List<QuestionAnswerDTO> qaList) {
        List<JpaQuestionAnswer> newJpaQaList = new ArrayList<>();
        
        for( QuestionAnswerDTO qaDTO: qaList) {
            AnswerDTO answer = qaDTO.getAnswer();
            JpaAnswer jpaAnswer = createAnswer( answer);
            
            // now can build the qa object with both ids
            JpaQuestionAnswer jpaQa = surveyDao.createQuestionAnswer( question, jpaAnswer, qaDTO.getSequence());
            newJpaQaList.add( jpaQa);
        }
        
        List<QuestionAnswerDTO> newQaList = surveyMapper.toQuestionAnswerList( newJpaQaList);
        
        return newQaList;
    }
    
    private JpaAnswer createAnswer(AnswerDTO answer) {
        JpaAnswer jpaAnswer = surveyMapper.toJpaAnswer( answer);
        jpaAnswer = surveyDao.createAnswer( jpaAnswer);
        
        return jpaAnswer;
    }
    
    @Override
    public AnswerDTO createAnswerForQuestion(Long questionId, AnswerDTO answer) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public SurveyDTO addQuestionToSurvey(Long surveyId, Long questionId) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Transactional
    @Override
    public QuestionDTO updateQuestion(QuestionDTO question) {
        JpaQuestion existingQuestion = surveyDao.getQuestion( question.getId());
        if( existingQuestion.getStatus() == SurveyState.PUBLISHED) {
            log.info( "Cannot update question in PUBLISHED state");
            return null;
        }
        
        JpaQuestion jpaQuestion = surveyMapper.toJpaQuestion( question);
        surveyDao.updateQuestion( jpaQuestion);
        
        return surveyMapper.toQuestion( jpaQuestion);
    }

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

}
