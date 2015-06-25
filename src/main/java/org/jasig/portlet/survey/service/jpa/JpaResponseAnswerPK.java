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

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The primary key class for the survey_response_answer database table.
 * Reference to parent response and question that is answered.
 *
 * @author Benito J. Gonzalez <bgonzalez@unicon.net>
 * @since 1.0
 */
@Embeddable
public class JpaResponseAnswerPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.ALL})
    @JoinColumn(name = "RESPONSE_ID")
    private JpaResponse jpaResponse;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.ALL})
    @JoinColumn(name = "QUESTION_ID")
    private JpaQuestion jpaQuestion;

    public JpaResponseAnswerPK() {}

    public JpaResponseAnswerPK(JpaResponse response, JpaQuestion question) {
        jpaResponse = response;
        jpaQuestion = question;
    }

    public long getResponseId() {
        return this.jpaResponse.getId();
    }

    public long getQuestionId() {
        return this.jpaQuestion.getId();
    }

    public JpaResponse getJpaResponse() {
        return jpaResponse;
    }

    public void setJpaResponse(JpaResponse jpaResponse) {
        this.jpaResponse = jpaResponse;
    }

    public JpaQuestion getJpaQuestion() {
        return jpaQuestion;
    }

    public void setJpaQuestion(JpaQuestion jpaQuestion) {
        this.jpaQuestion = jpaQuestion;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JpaResponseAnswerPK)) {
            return false;
        }
        JpaResponseAnswerPK castOther = (JpaResponseAnswerPK) other;
        return (this.getQuestionId() == castOther.getQuestionId()) && (this.getResponseId() == castOther.getResponseId());
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + ((int) (this.getQuestionId() ^ (this.getQuestionId() >>> 32)));
        hash = hash * prime + ((int) (this.getResponseId() ^ (this.getResponseId() >>> 32)));
        return hash;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}