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

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the survey_question_answer database table.
 * 
 * @author chasegawa
 * @since 1.0
 */
@Entity
@Table(name = JpaSurveyService.TABLENAME_PREFIX + "question_answer")
class JpaQuestionAnswer implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private JpaQuestionAnswerPK id;

    @ManyToOne // bi-directional many-to-one association to JpaAnswer
    @JoinColumn(name = "ANSWER_ID", nullable = false, insertable = false, updatable = false)
    private JpaAnswer jpaAnswer;

    @ManyToOne // bi-directional many-to-one association to JpaQuestion
    @JoinColumn(name = "QUESTION_ID", nullable = false, insertable = false, updatable = false)
    private JpaQuestion jpaQuestion;

    @Column(name = "SEQUENCE", nullable = true)
    private int sequence;

    public JpaAnswer getJpaAnswer() {
        return this.jpaAnswer;
    }

    public JpaQuestion getJpaQuestion() {
        return this.jpaQuestion;
    }

    public void setJpaAnswer(JpaAnswer jpaAnswer) {
        this.jpaAnswer = jpaAnswer;
    }

    public void setJpaQuestion(JpaQuestion jpaQuestion) {
        this.jpaQuestion = jpaQuestion;
    }
}