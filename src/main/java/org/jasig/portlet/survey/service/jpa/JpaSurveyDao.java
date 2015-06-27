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

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.IteratorUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.jasig.portlet.survey.service.jpa.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class JpaSurveyDao implements IJpaSurveyDao {
    @Autowired
    private JpaAnswerRepository answerRepository;

    @Autowired
    private JpaQuestionAnswerRepository qaRepository;

    @Autowired
    private JpaQuestionRepository questionRepository;

    @Autowired
    private JpaSurveyQuestionRepository surveyQuestionRepository;

    @Autowired
    private JpaSurveyRepository surveyRepository;

    @Autowired
    private JpaResponseRepository responseRepository;

    @Autowired
    private JpaResponseAnswerRepository responseAnswerRepository;

    @Autowired
    private JpaSurveyTextRepository surveyTextRepository;

    @Override
    public JpaSurveyQuestion attachQuestionToSurvey(Long surveyId, Long questionId, JpaSurveyQuestion surveyQuestion) {
        JpaSurvey survey = getSurvey(surveyId);
        JpaQuestion question = getQuestion(questionId);

        survey.setLastUpdateDate(new Timestamp(new Date().getTime()));
        JpaSurveyQuestionPK pk = new JpaSurveyQuestionPK(question, survey);
        surveyQuestion.setId(pk);

        survey.addJpaSurveyQuestion(surveyQuestion);

        surveyRepository.save(survey);

        return surveyQuestion;
    }

    @Override
    public JpaAnswer createAnswer(JpaAnswer answer) {
        JpaAnswer newAnswer = answerRepository.save(answer);
        return newAnswer;
    }

    @Override
    public JpaQuestion createQuestion(JpaQuestion question) {
        setupQuestionForSave(question, true);
        JpaQuestion q = questionRepository.save(question);
        return q;
    }

    @Override
    public JpaQuestionAnswer createQuestionAnswer(JpaQuestion question, JpaAnswer answer, Integer sequence) {
        JpaQuestionAnswer newQa = new JpaQuestionAnswer();
        newQa.getId().setJpaAnswer(answer);
        newQa.getId().setJpaQuestion(question);
        newQa = qaRepository.save(newQa);
        return newQa;
    }

    @Override
    public JpaSurvey createSurvey(JpaSurvey survey) {
        List<JpaSurveyQuestion> sqList = survey.getJpaSurveyQuestions();
        if (sqList != null && !sqList.isEmpty()) {
            for (JpaSurveyQuestion sq : sqList) {
                sq.getId().setJpaSurvey(survey);

                JpaQuestion q = sq.getId().getJpaQuestion();
                setupQuestionForSave(q, true);
                q = createQuestion(q);
                sq.getId().setJpaQuestion(q);
            }
        }

        JpaSurvey s = surveyRepository.save(survey);
        return s;
    }

    @Override
    public JpaSurveyText createSurveyText(JpaSurveyText text) {
        JpaSurveyText newSurveyText = surveyTextRepository.save(text);
        return newSurveyText;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<JpaSurvey> getAllSurveys() {
        Iterable<?> surveyIter = surveyRepository.findAll();
        List<JpaSurvey> surveyList = IteratorUtils.toList(surveyIter.iterator());
        return surveyList;
    }

    @Override
    public JpaQuestion getQuestion(Long id) {
        JpaQuestion question = questionRepository.findOne(id);
        return question;
    }

    @Override
    public JpaAnswer getAnswer(Long id) {
        JpaAnswer answer = answerRepository.findOne(id);
        return answer;
    }

    /**
     * Search for a JpaSurvey based on the specified id.
     * 
     * @param id
     * @return
     */
    @Override
    public JpaSurvey getSurvey(Long id) {
        Validate.isTrue(id > 0, "Invalid survey id: " + id);
        JpaSurvey survey = surveyRepository.findOne(id);
        return survey;
    }

    @Override
    public JpaSurvey getSurveyByCanonicalName(String canonicalName) {
        if (StringUtils.isEmpty(canonicalName)) {
            return null;
        }
        return surveyRepository.findByCanonicalName(canonicalName);
    }

    /**
     * @param key: may not be null
     * @param variant: may be null. Whitespace trimmed.
     * @return a non-null object
     * @see org.jasig.portlet.survey.service.jpa.IJpaSurveyDao#getText(java.lang.String, java.lang.String)
     */
    @Override
    public JpaSurveyText getText(String key, String variant) {
        if (StringUtils.isEmpty(key)) {
            return new JpaSurveyText();
        }
        JpaSurveyText result = surveyTextRepository.findByKeyAndVariant(key, StringUtils.trimToEmpty(variant));
        return result == null ? new JpaSurveyText() : result;
    }

    private void setupQuestionForSave(JpaQuestion jpaQuestion, boolean createAnswer) {
        Set<JpaQuestionAnswer> qaList = jpaQuestion.getJpaQuestionAnswers();
        if (qaList != null && !qaList.isEmpty()) {
            for (JpaQuestionAnswer qa : qaList) {
                JpaAnswer answer = qa.getId().getJpaAnswer();
                
                // This is not cascading... no idea why not
                // so save it here first
                createAnswer(answer);
                
                qa.getId().setJpaQuestion(jpaQuestion);
                qa.getId().setJpaAnswer(answer);
                
                if( jpaQuestion.getId() != 0) { // only on question update
                    JpaQuestionAnswer existingQA = qaRepository.findOne( qa.getId());
                    if( existingQA != null) {
                        existingQA.setSequence( qa.getSequence());
                        existingQA.setLogic( qa.getLogic());
                        existingQA.setCanonicalName( qa.getCanonicalName());
                        qaRepository.save( existingQA);
                    }
                    else {
                        qaRepository.save(qa);
                    }
                }
            }
        }
    }

    @Override
    public JpaQuestion updateQuestion(JpaQuestion question) {
        setupQuestionForSave( question, false);
        JpaQuestion updatedQuestion = questionRepository.save(question);
        return updatedQuestion;
    }

    @Override
    public JpaSurvey updateSurvey(JpaSurvey survey) {
        JpaSurvey newSurvey = surveyRepository.save(survey);
        return newSurvey;
    }

    @Override
    public void createResponse(JpaResponse jpaResponse) {
        JpaResponse result = responseRepository.save(jpaResponse);
    }

    @Override
    public JpaResponse getResponse(long id) {
        return responseRepository.findOne(id);
    }

    @Override
    public List<JpaResponse> getResponseByUser(String user) {
        Iterable<?> responseIter = responseRepository.findByUser(user);
        List<JpaResponse> responseList = IteratorUtils.toList(responseIter.iterator());
        return responseList;
    }

    @Override
    public JpaResponse getResponseByUserAndSurvey(String user, long surveyId) {
        //return responseRepository.findByUserAndSurvey(user, surveyId);
        return (JpaResponse) responseRepository.findByUser(user);
    }

    @Override
    public JpaResponse updateResponse(JpaResponse jpaResponse) {
        JpaResponse newResponse = responseRepository.save(jpaResponse);
        return newResponse;
    }

}
