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

import org.jasig.portlet.survey.mvc.service.JpaSurveyDataService;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The persistent class for the survey_question_answer database table.
 * 
 * @author chasegawa
 * @since 1.0
 */
@Entity
@Table(name = JpaSurveyDataService.TABLENAME_PREFIX + "QUESTION_ANSWER")
public class JpaQuestionAnswer implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * canonicalName is a unique reference name for this answer that allows an outside source to know what selection 
     * was made for a question
     */
    @Column(name = "CANONICAL_NAME", nullable = true, unique = true)
    private String canonicalName;

    @EmbeddedId
    private JpaQuestionAnswerPK id;
    
    @Column(name = "LOGIC", nullable = true)
    private String logic;

    @Column(name = "SEQUENCE", nullable = true)
    private int sequence;

    @Column(name = "VALUE", nullable = true)
    private Integer value;

    public String getCanonicalName() {
        return canonicalName;
    }

    public JpaQuestionAnswerPK getId() {
        return id;
    }

    public String getLogic() {
        return logic;
    }

    public int getSequence() {
        return sequence;
    }

    public int getValue() {
        return value;
    }

    public void setCanonicalName(String canonicalName) {
        this.canonicalName = canonicalName;
    }

    public void setId(JpaQuestionAnswerPK id) {
        this.id = id;
    }

    public void setLogic(String logic) {
        this.logic = logic;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
