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
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

@ApiObject(name = "SurveyQuestionDTO")
public class SurveyQuestionDTO implements Serializable {
    private static final long serialVersionUID = 1l;

    @ApiObjectField
    private int numAllowedAnswers;
    @ApiObjectField
    private QuestionDTO question;
    @ApiObjectField
    private int sequence;

    public int getNumAllowedAnswers() {
        return numAllowedAnswers;
    }

    public QuestionDTO getQuestion() {
        return question;
    }

    public int getSequence() {
        return sequence;
    }

    public void setNumAllowedAnswers(int numAllowedAnswers) {
        this.numAllowedAnswers = numAllowedAnswers;
    }

    public void setQuestion(QuestionDTO question) {
        this.question = question;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

}
