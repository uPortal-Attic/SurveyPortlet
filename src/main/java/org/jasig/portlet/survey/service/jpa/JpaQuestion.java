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

import org.jasig.portlet.survey.mvc.service.JpaSurveyDataService;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.jasig.portlet.survey.PublishedState;

/**
 * The persistent class for the survey_question database table.
 * 
 * @author chasegawa
 * @since 1.0
 */
@Entity
@Table(name = JpaSurveyDataService.TABLENAME_PREFIX + "QUESTION")
public class JpaQuestion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "ALT_TEXT", nullable = true)
    private String altText;

    /**
     * canonicalName is a unique reference name for a question that allows an outside source to reference a question.
     */
    @Column(name = "CANONICAL_NAME", nullable = true, unique = true)
    private String canonicalName;
    
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "HELP_TEXT", nullable = true)
    private String helpText;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private long id;

    @OneToMany(mappedBy = "id.jpaQuestion", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    private Set<JpaQuestionAnswer> jpaQuestionAnswers;
    
    @Column(name = "STATUS", nullable = false)
    private PublishedState status;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "TEXT", nullable = false)
    private String text;
    
    public JpaQuestionAnswer addJpaQuestionAnswer(JpaQuestionAnswer jpaQuestionAnswer) {
        getJpaQuestionAnswers().add(jpaQuestionAnswer);
        jpaQuestionAnswer.getId().setJpaQuestion(this);
        return jpaQuestionAnswer;
    }

    public JpaSurveyQuestion addJpaSurveyQuestion(JpaSurveyQuestion jpaSurveyQuestion) {
        jpaSurveyQuestion.getId().setJpaQuestion(this);
        return jpaSurveyQuestion;
    }

    public String getAltText() {
        return altText;
    }

    public String getCanonicalName() {
        return canonicalName;
    }

    public String getHelpText() {
        return helpText;
    }

    public long getId() {
        return id;
    }

    public Set<JpaQuestionAnswer> getJpaQuestionAnswers() {
        return jpaQuestionAnswers;
    }

    public PublishedState getStatus() {
        return status;
    }

    public String getText() {
        return text;
    }

    public JpaQuestionAnswer removeJpaQuestionAnswer(JpaQuestionAnswer jpaQuestionAnswer) {
        getJpaQuestionAnswers().remove(jpaQuestionAnswer);
        jpaQuestionAnswer.getId().setJpaQuestion(null);
        return jpaQuestionAnswer;
    }

    public JpaSurveyQuestion removeJpaSurveyQuestion(JpaSurveyQuestion jpaSurveyQuestion) {
        jpaSurveyQuestion.getId().setJpaQuestion(null);
        return jpaSurveyQuestion;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public void setCanonicalName(String canonicalName) {
        this.canonicalName = canonicalName;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setJpaQuestionAnswers(Set<JpaQuestionAnswer> jpaQuestionAnswers) {
        this.jpaQuestionAnswers = jpaQuestionAnswers;
    }

    public void setStatus(PublishedState status) {
        this.status = status;
    }

    public void setText(String text) {
        this.text = text;
    }
}