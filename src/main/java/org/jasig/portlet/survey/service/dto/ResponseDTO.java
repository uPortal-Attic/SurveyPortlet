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
package org.jasig.portlet.survey.service.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Data Transfer Object of user response. Minimal to match JSON expectations.
 * Note the lack of reference to a corresponding survey.
 *
 * @since 1.0
 */
@ApiObject(name = "ResponseDTO")
public class ResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiObjectField
    private long id;
    @ApiObjectField(required = true)
    private String user;
    @ApiObjectField(required = true)
    private long survey;
    @ApiObjectField(required = true)
    private Date lastUpdated;
    @ApiObjectField
    private Set<ResponseAnswerDTO> answers = new HashSet<>();
    @ApiObjectField
    private String feedback;

    public long getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public long getSurvey() {
        return survey;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public Set<ResponseAnswerDTO> getAnswers() {
        return Collections.unmodifiableSet(answers);
    }

    public String getFeedback() {
        return feedback;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSurvey(long survey) {
        this.survey = survey;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setAnswers(Set<ResponseAnswerDTO> answers) {
        this.answers.clear();
        this.answers.addAll(answers);
    }

    public void addAnswer(ResponseAnswerDTO answer) {
        this.answers.add(answer);
    }

    public void setFeedback(String fb) {
        this.feedback = fb;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
