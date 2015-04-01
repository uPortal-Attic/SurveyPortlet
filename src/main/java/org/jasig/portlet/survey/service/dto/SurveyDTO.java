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

import org.jasig.portlet.survey.PublishedState;
import org.jasig.portlet.survey.mvc.service.ISurveyDataService;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

@ApiObject(name = "SurveyDTO")
public class SurveyDTO implements ILookupTextable, Serializable {
    private static final long serialVersionUID = 1L;

    @ApiObjectField
    private String altText;
    @ApiObjectField
    private String canonicalName;
    @ApiObjectField
    private String definitionText;
    @ApiObjectField
    private String description;
    @ApiObjectField
    private String helpText;
    @ApiObjectField
    private long id;
    @ApiObjectField(description = "Timestamp in millis",required = true)
    private Date lastUpdateDate;
    @ApiObjectField(required = true)
    private String lastUpdateUser;
    @ApiObjectField
    private PublishedState status;
    @ApiObjectField
    private Set<SurveyQuestionDTO> surveyQuestions = new HashSet<SurveyQuestionDTO>();
    @ApiObjectField
    private String text;
    @ApiObjectField
    private String textKey;
    @ApiObjectField
    private String title;

    public String getAltText() {
        return altText;
    }

    public String getCanonicalName() {
        return canonicalName;
    }

    public String getDefinitionText() {
        return definitionText;
    }

    public String getDescription() {
        return description;
    }

    public String getHelpText() {
        return helpText;
    }

    public long getId() {
        return id;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public PublishedState getStatus() {
        return status;
    }

    public Set<SurveyQuestionDTO> getSurveyQuestions() {
        return surveyQuestions;
    }

    public String getText() {
        return text;
    }

    public String getTextKey() {
        return textKey;
    }

    public String getTitle() {
        return title;
    }

    /**
     * Use the dataService to acquire any needed text sets for any keys we have.
     * @see org.jasig.portlet.survey.service.dto.ILookupTextable#retrieveText(org.jasig.portlet.survey.mvc.service.ISurveyDataService)
     */
    @Override
    public void retrieveText(ISurveyDataService dataService) {
        ITextGroup textGroup = dataService.getTextGroup(this.textKey);
        this.altText = textGroup.getAltText();
        this.helpText = textGroup.getHelpText();
        this.definitionText = textGroup.getDefinitionText();
        this.text = textGroup.getText();
        // TODO - enhancement: call the retrieveText for set of questions
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public void setCanonicalName(String canonicalName) {
        this.canonicalName = canonicalName;
    }

    public void setDefinitionText(String definitionText) {
        this.definitionText = definitionText;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public void setStatus(PublishedState status) {
        this.status = status;
    }

    public void setSurveyQuestions(Set<SurveyQuestionDTO> surveyQuestions) {
        this.surveyQuestions = surveyQuestions;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTextKey(String textKey) {
        this.textKey = textKey;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
