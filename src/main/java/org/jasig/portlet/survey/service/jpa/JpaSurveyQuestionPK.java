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

import java.io.Serializable;
import javax.persistence.*;
/**
 * The primary key class for the survey_survey_question database table.
 * 
 * @author chasegawa
 * @since 1.0
 */
@Embeddable
class JpaSurveyQuestionPK implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @OneToOne(cascade = {CascadeType.PERSIST}) 
    @JoinColumn(name = "QUESTION_ID", nullable = false, insertable = false, updatable = false )
    private JpaQuestion jpaQuestion;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST}) 
    @JoinColumn(name = "SURVEY_ID", nullable = false, insertable = false, updatable = false)
    private JpaSurvey jpaSurvey;
    
    public JpaSurveyQuestionPK() {}
    
    public JpaSurveyQuestionPK(JpaQuestion jpaQuestion, JpaSurvey jpaSurvey) {
        this.jpaQuestion = jpaQuestion;
        this.jpaSurvey = jpaSurvey;
    }
    
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JpaSurveyQuestionPK)) {
            return false;
        }
        JpaSurveyQuestionPK castOther = (JpaSurveyQuestionPK) other;
        return (this.jpaSurvey.getId() == castOther.jpaSurvey.getId()) && (this.jpaQuestion.getId() == castOther.jpaQuestion.getId());
    }

    public long getQuestionId() {
        return this.jpaQuestion.getId();
    }

    public long getSurveyId() {
        return this.jpaSurvey.getId();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + ((int) (this.jpaSurvey.getId() ^ (this.jpaSurvey.getId() >>> 32)));
        hash = hash * prime + ((int) (this.jpaQuestion.getId() ^ (this.jpaQuestion.getId() >>> 32)));

        return hash;
    }

    public JpaSurvey getJpaSurvey() {
        return jpaSurvey;
    }

    public void setJpaSurvey(JpaSurvey jpaSurvey) {
        this.jpaSurvey = jpaSurvey;
    }

    public JpaQuestion getJpaQuestion() {
        return jpaQuestion;
    }

    public void setJpaQuestion(JpaQuestion jpaQuestion) {
        this.jpaQuestion = jpaQuestion;
    }
    
}