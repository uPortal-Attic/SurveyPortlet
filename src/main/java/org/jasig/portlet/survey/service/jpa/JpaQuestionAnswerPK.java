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
import javax.persistence.CascadeType;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * The primary key class for the survey_question_answer database table.
 * 
 * @author chasegawa
 * @since 1.0
 */
@Embeddable
class JpaQuestionAnswerPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.ALL})
    @JoinColumn(name = "ANSWER_ID")
    private JpaAnswer jpaAnswer;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.ALL}) // bi-directional many-to-one association to JpaQuestion
    @JoinColumn(name = "QUESTION_ID")
    private JpaQuestion jpaQuestion;
    
    public JpaQuestionAnswerPK() {}
    
    public JpaQuestionAnswerPK(JpaAnswer answer, JpaQuestion question) {
        jpaAnswer = answer;
        jpaQuestion = question;
    }
    
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JpaQuestionAnswerPK)) {
            return false;
        }
        JpaQuestionAnswerPK castOther = (JpaQuestionAnswerPK) other;
        return (this.getQuestionId() == castOther.getQuestionId()) && (this.getAnswerId() == castOther.getAnswerId());
    }

    public long getAnswerId() {
        return this.jpaAnswer.getId();
    }

    public long getQuestionId() {
        return this.jpaQuestion.getId();
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + ((int) (this.getQuestionId() ^ (this.getQuestionId() >>> 32)));
        hash = hash * prime + ((int) (this.getAnswerId() ^ (this.getAnswerId() >>> 32)));

        return hash;
    }

    public JpaAnswer getJpaAnswer() {
        return jpaAnswer;
    }

    public void setJpaAnswer(JpaAnswer jpaAnswer) {
        this.jpaAnswer = jpaAnswer;
    }

    public JpaQuestion getJpaQuestion() {
        return jpaQuestion;
    }

    public void setJpaQuestion(JpaQuestion jpaQuestion) {
        this.jpaQuestion = jpaQuestion;
    }

    
}