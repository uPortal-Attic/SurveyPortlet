package org.jasig.portlet.survey.service.jpa;

import java.util.List;
import java.util.Set;
import org.apache.commons.collections.IteratorUtils;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class JpaSurveyDao implements IJpaSurveyDao {

    @Autowired
    private JpaSurveyRepository surveyRepository;
    
    @Autowired
    private JpaQuestionRepository questionRepository;
    
    @Autowired
    private JpaQuestionAnswerRepository qaRepository;
    
    @Autowired
    private JpaAnswerRepository answerRepository;
    
    @Autowired
    private JpaSurveyQuestionRepository surveyQuestionRepository;
    
    /**
     * Search for a JpaSurvey based on the specified id.
     * 
     * @param id
     * @return 
     */
    @Override
    public JpaSurvey getSurvey(Long id) {
        Validate.isTrue( id > 0, "Invalid survey id: " + id);
        JpaSurvey survey = surveyRepository.findOne( id);
        return survey;
    }

    /**
     * 
     * @return All surveys
     */
    @Override
    public List<JpaSurvey> getAllSurveys() {
        Iterable surveyIter = surveyRepository.findAll();
        List<JpaSurvey> surveyList = IteratorUtils.toList( surveyIter.iterator());
        return surveyList;
    }

    /**
     * 
     * @param survey
     * @return 
     */
    @Override
    public JpaSurvey createSurvey(JpaSurvey survey) {
        JpaSurvey s = surveyRepository.save( survey);
        
        List<JpaSurveyQuestion> sqList = survey.getJpaSurveyQuestions();
        if( sqList != null && !sqList.isEmpty()) {
            for( JpaSurveyQuestion sq: sqList) {
                sq.getId().setJpaSurvey(s);

                JpaQuestion q = sq.getId().getJpaQuestion();

                q = createQuestion( q);
                sq.getId().setJpaQuestion( q);

                surveyQuestionRepository.save( sq);
            }
        }
        return s;
    }

    @Override
    public JpaSurveyQuestion attachQuestionToSurvey( JpaSurvey survey, JpaQuestion question) {
        JpaSurveyQuestion sq = new JpaSurveyQuestion();
        JpaSurveyQuestionPK pk = new JpaSurveyQuestionPK( question, survey);
        sq.setId( pk);
        
        sq = surveyQuestionRepository.save(sq);
        return sq;
    }
    
    /**
     * 
     * @param question
     * @return 
     */
    @Override
    public JpaQuestion createQuestion(JpaQuestion question) {
        JpaQuestion q = questionRepository.save( question);
        Set<JpaQuestionAnswer> qaList = q.getJpaQuestionAnswers();
        
        if( qaList != null && !qaList.isEmpty()) {
            for( JpaQuestionAnswer qa: qaList) {
                JpaAnswer ans = qa.getId().getJpaAnswer();
                ans = createAnswer( ans);
                
                qa.getId().setJpaAnswer( ans);
                qa.getId().setJpaQuestion( q);

                qaRepository.save( qa);
            }
        }
        return q;
    }

    @Override
    public JpaQuestionAnswer createQuestionAnswer(JpaQuestion question, JpaAnswer answer, Integer sequence) {
        JpaQuestionAnswer newQa = new JpaQuestionAnswer();
        newQa.getId().setJpaAnswer( answer);
        newQa.getId().setJpaQuestion( question);
        newQa = qaRepository.save( newQa);
        return newQa;
    }

    @Override
    public JpaAnswer createAnswer(JpaAnswer answer) {
        JpaAnswer newAnswer = answerRepository.save( answer);
        return newAnswer;
    }

    @Override
    public JpaQuestion updateQuestion(JpaQuestion question) {
        JpaQuestion updatedQuestion = questionRepository.save( question);
        return updatedQuestion;
    }

    @Override
    public JpaQuestion getQuestion(Long id) {
        JpaQuestion question = questionRepository.findOne( id);
        return question;
    }
    
}
