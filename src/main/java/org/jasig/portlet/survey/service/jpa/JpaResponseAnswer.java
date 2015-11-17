/**
 * Licensed to Apereo under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Apereo licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.portlet.survey.service.jpa;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jasig.portlet.survey.mvc.service.JpaSurveyDataService;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * The persistent class for the survey_response_answer database table.
 * The response answer for a particular question may be multi-value.
 *
 * @since 1.0
 */
@Entity
@Table(name = JpaSurveyDataService.TABLENAME_PREFIX + "RESPONSE_ANSWER")
@SecondaryTable(name = JpaSurveyDataService.TABLENAME_PREFIX + "RESPONSE_ANSWER")
public class JpaResponseAnswer implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private JpaResponseAnswerPK id;

    @ManyToMany(targetEntity = JpaAnswer.class, fetch = FetchType.LAZY)
    @JoinTable(
            name = JpaSurveyDataService.TABLENAME_PREFIX + "RESPONSE_ANSWERS",
            joinColumns = {
                    @JoinColumn(name = "RESPONSE_ID", table = JpaSurveyDataService.TABLENAME_PREFIX + "RESPONSE_ANSWER",
                        referencedColumnName = "RESPONSE_ID"),
                    @JoinColumn(name = "QUESTION_ID", table = JpaSurveyDataService.TABLENAME_PREFIX + "RESPONSE_ANSWER",
                        referencedColumnName = "QUESTION_ID")
            },
            inverseJoinColumns = @JoinColumn(table = JpaSurveyDataService.TABLENAME_PREFIX + "ANSWER", name = "ANSWER_ID",
                    referencedColumnName = "ID"))
    private Set<JpaAnswer> answer = new HashSet<>();

    public JpaResponseAnswerPK getId() {
        return id;
    }

    public Set<JpaAnswer> getAnswer() {
        return Collections.unmodifiableSet(answer);
    }
    public void setId(JpaResponseAnswerPK id) {
        this.id = id;
    }

    public void setAnswer(Set<JpaAnswer> answer) {
        this.answer.clear();
        this.answer.addAll(answer);
    }

    public void addJpaAnswer(JpaAnswer answer) {
        this.answer.add(answer);
    }

    public void removeJpaAnswer(JpaAnswer answer) {
        this.answer.remove(answer);
    }

    @Override
    public String toString() {
        //return ToStringBuilder.reflectionToString(this);
        return new ToStringBuilder(this)
                .append("ResponseId", id.getResponseId())
                .append("QuestionId", id.getQuestionId())
                .append("answer", answer).toString();
    }
}