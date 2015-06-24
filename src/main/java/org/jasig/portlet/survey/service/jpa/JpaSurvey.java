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
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;

import org.jasig.portlet.survey.PublishedState;

/**
 * The persistent class for the survey_survey database table.
 * 
 * @author chasegawa
 * @since 1.0
 */
@Entity
@Table(name = JpaSurveyDataService.TABLENAME_PREFIX + "SURVEY")
public class JpaSurvey implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * canonicalName is a unique reference name for a survey that allows an outside source to reference/lookup a survey.
     */
    @Column(name = "CANONICAL_NAME", nullable = true, unique = true)
    private String canonicalName;
    
    @Column(name = "DESCRIPTION", nullable = true)
    private String description;

    @SequenceGenerator(
            name = JpaSurveyDataService.TABLENAME_PREFIX + "SURVEY_GEN",
            sequenceName = JpaSurveyDataService.TABLENAME_PREFIX + "SURVEY_SEQ",
            allocationSize = 5
    )
    @TableGenerator(
            name = JpaSurveyDataService.TABLENAME_PREFIX + "SURVEY_GEN",
            pkColumnValue = JpaSurveyDataService.TABLENAME_PREFIX + "SURVEY",
            allocationSize = 5
    )
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = JpaSurveyDataService.TABLENAME_PREFIX + "SURVEY_GEN")
    @Column(name = "ID", updatable = false)
    private long id;

    @OneToMany(mappedBy = "id.jpaSurvey", fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<JpaSurveyQuestion> jpaSurveyQuestions;

    @Column(name = "LAST_UPDATE_DATE", nullable = false)
    private Timestamp lastUpdateDate;

    @Column(name = "LAST_UPDATE_USER", nullable = false)
    private String lastUpdateUser;

    @Column(name = "STATUS", nullable = false)
    private PublishedState status;

    @Column(name = "TEXT_KEY", nullable = true)
    private String textKey;

    @Column(name = "TITLE", nullable = false)
    private String title;

    public JpaSurveyQuestion addJpaSurveyQuestion(JpaSurveyQuestion jpaSurveyQuestion) {
        getJpaSurveyQuestions().add(jpaSurveyQuestion);
        jpaSurveyQuestion.getId().setJpaSurvey(this);
        return jpaSurveyQuestion;
    }

    public String getCanonicalName() {
        return canonicalName;
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }

    public List<JpaSurveyQuestion> getJpaSurveyQuestions() {
        return jpaSurveyQuestions;
    }

    public Timestamp getLastUpdateDate() {
        return lastUpdateDate;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public PublishedState getStatus() {
        return status;
    }

    public String getTextKey() {
        return textKey;
    }

    public String getTitle() {
        return title;
    }

    public JpaSurveyQuestion removeJpaSurveyQuestion(JpaSurveyQuestion jpaSurveyQuestion) {
        getJpaSurveyQuestions().remove(jpaSurveyQuestion);
        jpaSurveyQuestion.getId().setJpaSurvey(null);
        return jpaSurveyQuestion;
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

    public void setJpaSurveyQuestions(List<JpaSurveyQuestion> jpaSurveyQuestions) {
        this.jpaSurveyQuestions = jpaSurveyQuestions;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public void setStatus(PublishedState status) {
        this.status = status;
    }

    public void setTextKey(String textKey) {
        this.textKey = textKey;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}