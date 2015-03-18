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

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the survey_question database table.
 * 
 * @author chasegawa
 * @since 1.0
 */
@Entity
@Table(name = JpaSurveyService.TABLENAME_PREFIX + "question")
public class JpaQuestion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "ALT_TEXT", nullable = true)
    private String altText;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private long id;

    @OneToMany(mappedBy = "jpaQuestion")
    private List<JpaQuestionAnswer> jpaQuestionAnswers;

    @OneToMany(mappedBy = "jpaQuestion")
    private List<JpaSurveyQuestion> jpaSurveyQuestions;

    @Column(name = "TEXT", nullable = false)
    private String text;

    public JpaQuestionAnswer addJpaQuestionAnswer(JpaQuestionAnswer jpaQuestionAnswer) {
        getJpaQuestionAnswers().add(jpaQuestionAnswer);
        jpaQuestionAnswer.setJpaQuestion(this);
        return jpaQuestionAnswer;
    }

    public JpaSurveyQuestion addJpaSurveyQuestion(JpaSurveyQuestion jpaSurveyQuestion) {
        getJpaSurveyQuestions().add(jpaSurveyQuestion);
        jpaSurveyQuestion.setJpaQuestion(this);
        return jpaSurveyQuestion;
    }

    public String getAltText() {
        return altText;
    }

    public long getId() {
        return id;
    }

    public List<JpaQuestionAnswer> getJpaQuestionAnswers() {
        return jpaQuestionAnswers;
    }

    public List<JpaSurveyQuestion> getJpaSurveyQuestions() {
        return jpaSurveyQuestions;
    }

    public String getText() {
        return text;
    }

    public JpaQuestionAnswer removeJpaQuestionAnswer(JpaQuestionAnswer jpaQuestionAnswer) {
        getJpaQuestionAnswers().remove(jpaQuestionAnswer);
        jpaQuestionAnswer.setJpaQuestion(null);
        return jpaQuestionAnswer;
    }

    public JpaSurveyQuestion removeJpaSurveyQuestion(JpaSurveyQuestion jpaSurveyQuestion) {
        getJpaSurveyQuestions().remove(jpaSurveyQuestion);
        jpaSurveyQuestion.setJpaQuestion(null);
        return jpaSurveyQuestion;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setJpaQuestionAnswers(List<JpaQuestionAnswer> jpaQuestionAnswers) {
        this.jpaQuestionAnswers = jpaQuestionAnswers;
    }

    public void setJpaSurveyQuestions(List<JpaSurveyQuestion> jpaSurveyQuestions) {
        this.jpaSurveyQuestions = jpaSurveyQuestions;
    }

    public void setText(String text) {
        this.text = text;
    }
}