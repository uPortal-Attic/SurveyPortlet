/**
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.portlet.survey.service.jpa;

import java.util.List;

import org.apache.commons.lang.Validate;
import org.jasig.portlet.survey.IVariantStrategy;
import org.jasig.portlet.survey.PublishedState;
import org.jasig.portlet.survey.mvc.service.ISurveyDataService;
import org.jasig.portlet.survey.service.dto.AnswerDTO;
import org.jasig.portlet.survey.service.dto.QuestionDTO;
import org.jasig.portlet.survey.service.dto.SurveyDTO;
import org.jasig.portlet.survey.service.dto.SurveyQuestionDTO;
import org.jasig.portlet.survey.service.dto.ITextGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

/**
 * Service class for CRUD operations and moving to and from the business object models and the JPA impl for a survey.
 * @since 1.0
 */
@Service
public class JpaSurveyDataService implements ISurveyDataService {
    public static final String TABLENAME_PREFIX = "SURVEY_";

    @Autowired
    private IJpaSurveyDao jpaSurveyDao;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ISurveyMapper surveyMapper;

    @Autowired
    private IVariantStrategy variantStrategy;
    
    /**
     * 
     * @param surveyId
     * @param questionId
     * @param surveyQuestion
     * @return
     */
    @Transactional
    @Override
    public boolean addQuestionToSurvey(Long surveyId, Long questionId, SurveyQuestionDTO surveyQuestion) {
        Validate.isTrue( surveyId != null && questionId != null, "Survey and question cannot be null");
        JpaSurveyQuestion sq = new JpaSurveyQuestion();
        sq.setNumAllowedAnswers( surveyQuestion.getNumAllowedAnswers());
        sq.setSequence( surveyQuestion.getSequence());
        
        JpaSurveyQuestion newSurveyQuestion = jpaSurveyDao.attachQuestionToSurvey(surveyId, questionId, sq);
        return newSurveyQuestion != null;
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
     * Create a {@link JpaQuestion} from the data in question
     * 
     * @param question
     * @return
     */
    @Transactional
    @Override
    public QuestionDTO createQuestion(QuestionDTO question) {
        JpaQuestion jpaQuestion = surveyMapper.toJpaQuestion(question);
        jpaQuestion = jpaSurveyDao.createQuestion(jpaQuestion);

        QuestionDTO newQuestion = surveyMapper.toQuestion(jpaQuestion);

        return newQuestion;
    }

    /**
     * Create a {@link JpaSurvey} from the data in survey
     * 
     * @param survey
     * @return
     */
    @Transactional
    @Override
    public SurveyDTO createSurvey(SurveyDTO survey) {
        // remove questions/answers if they are present - only create the survey
        JpaSurvey jpaSurvey = surveyMapper.toJpaSurvey(survey);
        jpaSurvey = jpaSurveyDao.createSurvey(jpaSurvey);
        return surveyMapper.toSurvey(jpaSurvey);
    }

    /**
     * Return all surveys
     * 
     * @return
     */
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<SurveyDTO> getAllSurveys() {
        List<JpaSurvey> surveyList = jpaSurveyDao.getAllSurveys();
        if (surveyList == null) {
            return null;
        }
        List<SurveyDTO> results = surveyMapper.toSurveyList(surveyList);
        for (SurveyDTO surveyDTO : results) {
            surveyDTO.retrieveText(this);
        }
        return results;
    }

    /**
     * Search for {@link JpaSurvey} specified by id.
     * 
     * @param id
     * @return
     */
    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public SurveyDTO getSurvey(long id) {
        JpaSurvey jpaSurvey = jpaSurveyDao.getSurvey(id);
        if (jpaSurvey == null) {
            return null;
        }
        SurveyDTO result = surveyMapper.toSurvey(jpaSurvey);
        result.retrieveText(this);
        return result;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public SurveyDTO getSurveyByName(String surveyName) {
        JpaSurvey jpaSurvey = jpaSurveyDao.getSurveyByCanonicalName(surveyName);
        if (jpaSurvey == null) {
            return null;
        }
        SurveyDTO result = surveyMapper.toSurvey(jpaSurvey);
        result.retrieveText(this);
        return result;
    }

    /**
     * Search for survey questions for the specified survey.
     * Return only the question data.
     * 
     * @param surveyId
     * @return
     */
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public List<SurveyQuestionDTO> getSurveyQuestions(Long surveyId) {
        JpaSurvey survey = jpaSurveyDao.getSurvey(surveyId);
        if (survey == null) {
            return null;
        }

        SurveyDTO surveyDTO = surveyMapper.toSurvey(survey);

        return Lists.newArrayList(surveyDTO.getSurveyQuestions());
    }

    /**
     * Retrieve the text group object based on the supplied key.
     * @see org.jasig.portlet.survey.mvc.service.ISurveyDataService#getTextGroup(java.lang.String)
     */
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    @Override
    public ITextGroup getTextGroup(String textKey) {
        return jpaSurveyDao.getText(textKey, variantStrategy.getVariantName());
    }

    /**
     * Update question details including embedded answer data
     * 
     * @param question
     * @return {@link QuestionDTO} or null on error
     */
    @Transactional
    @Override
    public QuestionDTO updateQuestion(QuestionDTO question) {
        JpaQuestion existingQuestion = jpaSurveyDao.getQuestion( question.getId());
        if( existingQuestion.getStatus() == PublishedState.PUBLISHED) {
            log.warn( "Cannot update question in PUBLISHED state");
            return null;
        }

        JpaQuestion jpaQuestion = surveyMapper.toJpaQuestion(question);
        jpaSurveyDao.updateQuestion(jpaQuestion);

        return surveyMapper.toQuestion(jpaQuestion);
    }

    /**
     * Update base survey data.  Questions/answer relationships will not be included in the update.
     * @param survey
     * @return 
     */
    @Transactional
    @Override
    public SurveyDTO updateSurvey(SurveyDTO survey) {
        JpaSurvey existingSurvey = jpaSurveyDao.getSurvey( survey.getId());
        if( existingSurvey == null || existingSurvey.getStatus() == PublishedState.PUBLISHED) {
            log.warn( "Cannot update survey");
            return null;
        }
        
        // remove question/answer elements
        survey.setSurveyQuestions( null);
        
        JpaSurvey jpaSurvey = surveyMapper.toJpaSurvey( survey);
        jpaSurvey = jpaSurveyDao.updateSurvey( jpaSurvey);
        
        return surveyMapper.toSurvey(jpaSurvey);
    }

}
