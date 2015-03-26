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
package org.jasig.portlet.survey.service.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.jasig.portlet.survey.SurveyState;

public class SurveyDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String canonicalName;
    private String description;
    private long id;
    private String instructions;
    private Date lastUpdateDate;
    private String lastUpdateUser;
    private SurveyState status;
    private Set<SurveyQuestionDTO> surveyQuestions = new HashSet<SurveyQuestionDTO>();

    private String title;
    
    public String getCanonicalName() {
        return canonicalName;
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }

    public String getInstructions() {
        return instructions;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public SurveyState getStatus() {
        return status;
    }

    public Set<SurveyQuestionDTO> getSurveyQuestions() {
        return surveyQuestions;
    }

    public String getTitle() {
        return title;
    }

    public void setCanonicalName(String canonicalName) {
        this.canonicalName = canonicalName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public void setStatus(SurveyState status) {
        this.status = status;
    }

    public void setSurveyQuestions(Set<SurveyQuestionDTO> surveyQuestions) {
        this.surveyQuestions = surveyQuestions;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
}
