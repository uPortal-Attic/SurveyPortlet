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

@ApiObject(name = "QuestionAnswerDTO")
public class QuestionAnswerDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiObjectField
    private AnswerDTO answer;
    @ApiObjectField
    private String canonicalName;
    @ApiObjectField
    private String logic;
    @ApiObjectField
    private Integer sequence;

    public AnswerDTO getAnswer() {
        return answer;
    }

    public String getCanonicalName() {
        return canonicalName;
    }

    public String getLogic() {
        return logic;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setAnswer(AnswerDTO answer) {
        this.answer = answer;
    }

    public void setCanonicalName(String canonicalName) {
        this.canonicalName = canonicalName;
    }

    public void setLogic(String logic) {
        this.logic = logic;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

}
