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
import java.util.Set;

import org.apache.commons.collections.IteratorUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.jasig.portlet.survey.service.jpa.repo.JpaAnswerRepository;
import org.jasig.portlet.survey.service.jpa.repo.JpaQuestionAnswerRepository;
import org.jasig.portlet.survey.service.jpa.repo.JpaQuestionRepository;
import org.jasig.portlet.survey.service.jpa.repo.JpaSurveyQuestionRepository;
import org.jasig.portlet.survey.service.jpa.repo.JpaSurveyRepository;
import org.jasig.portlet.survey.service.jpa.repo.JpaSurveyTextRepository;
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
    private JpaSurveyTextRepository surveyTextRepository;
    
    @Override
    public JpaSurveyQuestion attachQuestionToSurvey(Long surveyId, Long questionId, JpaSurveyQuestion surveyQuestion) {
        JpaSurvey survey = getSurvey(surveyId);
        JpaQuestion question = getQuestion(questionId);

        JpaSurveyQuestionPK pk = new JpaSurveyQuestionPK(question, survey);
        surveyQuestion.setId(pk);

        JpaSurveyQuestion sq = surveyQuestionRepository.save(surveyQuestion);
        return sq;
    }

    @Override
    public JpaAnswer createAnswer(JpaAnswer answer) {
        JpaAnswer newAnswer = answerRepository.save(answer);
        return newAnswer;
    }

    /**
     * 
     * @param question
     * @return
     */
    @Override
    public JpaQuestion createQuestion(JpaQuestion question) {
        setupQuestionForSave(question);
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

    /**
     * 
     * @param survey
     * @return
     */
    @Override
    public JpaSurvey createSurvey(JpaSurvey survey) {
        List<JpaSurveyQuestion> sqList = survey.getJpaSurveyQuestions();
        if (sqList != null && !sqList.isEmpty()) {
            for (JpaSurveyQuestion sq : sqList) {
                sq.getId().setJpaSurvey(survey);

                JpaQuestion q = sq.getId().getJpaQuestion();
                setupQuestionForSave(q);
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

    /**
     * @return All surveys
     */
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
     * @see org.jasig.portlet.survey.service.jpa.IJpaSurveyDao#getText(java.lang.String, java.lang.String)
     */
    @Override
    public JpaSurveyText getText(String key, String variant) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        return surveyTextRepository.findByKeyAndVariant(key, StringUtils.trimToEmpty(variant));
    }

    private void setupQuestionForSave(JpaQuestion jpaQuestion) {
        Set<JpaQuestionAnswer> qaList = jpaQuestion.getJpaQuestionAnswers();
        if (qaList != null && !qaList.isEmpty()) {
            for (JpaQuestionAnswer qa : qaList) {
                JpaAnswer answer = qa.getId().getJpaAnswer();

                // This is not cascading... no idea why not
                // so save it here first
                createAnswer(answer);
                qa.getId().setJpaQuestion(jpaQuestion);
                qa.getId().setJpaAnswer(answer);
            }
        }
    }

    @Override
    public JpaQuestion updateQuestion(JpaQuestion question) {
        JpaQuestion updatedQuestion = questionRepository.save(question);
        return updatedQuestion;
    }

    @Override
    public JpaSurvey updateSurvey(JpaSurvey survey) {
        JpaSurvey newSurvey = surveyRepository.save(survey);
        return newSurvey;
    }

}
