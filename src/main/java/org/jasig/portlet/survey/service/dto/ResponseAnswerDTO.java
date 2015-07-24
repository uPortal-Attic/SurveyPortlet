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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Data Transfer Object of user response answers. Minimal to match JSON expectations.
 * The data required is a question ID and a multi-value answer. The answer may be one
 * ore more answer IDs but is considered a single answer to a particular question.
 *
 * @author Benito J. Gonzalez <bgonzalez@unicon.net>
 * @since 1.1
 */
@ApiObject(name = "ResponseAnswerDTO")
@JsonSerialize(using = ResponseAnswerDtoSerializer.class)
@JsonDeserialize(using = ResponseAnswerDtoDeserializer.class)
public class ResponseAnswerDTO implements Serializable {
    private static final long serialVersionUID = 1l;

    @ApiObjectField
    private Long questionId;

    @JsonIgnore
    private boolean multiple = false;

    @ApiObjectField
    private Set<Long> answer = new HashSet<>();

    public Long getQuestion() {
        return questionId;
    }

    public Boolean isMultiple() {
        return multiple;
    }
    public Set<Long> getAnswer() {
        return Collections.unmodifiableSet(answer);
    }

    public void setQuestion(Long questionId) {
        this.questionId = questionId;
    }

    public void setMultiple(Boolean multiple) {
        this.multiple = multiple;
    }

    public void setAnswer(Set<Long> answer) {
        this.answer.clear();
        this.answer.addAll(answer);
    }

    public void addAnswerId(Long answerId) {
        this.answer.add(answerId);
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
