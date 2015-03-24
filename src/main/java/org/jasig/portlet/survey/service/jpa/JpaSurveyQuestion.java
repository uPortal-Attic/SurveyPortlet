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
import javax.persistence.Table;

/**
 * The persistent class for the survey_survey_question database table.
 * 
 * @author chasegawa
 * @since 1.0
 */
@Entity
@Table(name = JpaSurveyService.TABLENAME_PREFIX + "survey_question")
class JpaSurveyQuestion implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private JpaSurveyQuestionPK id;

    @Column(name = "NUM_ALLOWED_ANSWERS", nullable = false)
    private int numAllowedAnswers;

    @Column(name = "SEQUENCE", nullable = true)
    private int sequence;

    public JpaSurveyQuestionPK getId() {
        return id;
    }

    public int getNumAllowedAnswers() {
        return numAllowedAnswers;
    }

    public int getSequence() {
        return sequence;
    }

    public void setId(JpaSurveyQuestionPK id) {
        this.id = id;
    }

    public void setNumAllowedAnswers(int numAllowedAnswers) {
        this.numAllowedAnswers = numAllowedAnswers;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

}