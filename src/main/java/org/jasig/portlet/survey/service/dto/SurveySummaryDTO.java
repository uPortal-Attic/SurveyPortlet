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
import org.jasig.portlet.survey.service.jpa.JpaAnswer;
import org.jasig.portlet.survey.service.jpa.JpaResponse;
import org.jasig.portlet.survey.service.jpa.JpaResponseAnswer;
import org.jasig.portlet.survey.service.jpa.JpaResponseAnswerPK;
import org.jsondoc.core.annotation.ApiObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Data Transfer Object of survey response summary.
 *
 * @since 1.0
 */
@ApiObject(name = "SurveySummaryDTO")
public class SurveySummaryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long responseCount = 0;
    private Map<String, Map<String, Long>> answerCounts;

    //public void setResponses(List<JpaResponse> responses) {
    public SurveySummaryDTO(List<JpaResponse> responses) {
        //private List<JpaResponse> responses = new ArrayList<>();
        // set response collection
        //this.responses.clear();
        //this.responses.addAll(responses);

        // calculate summary info
        this.responseCount = responses.size();
        answerCounts = new HashMap<>();
        for (JpaResponse response : responses) {
            for (JpaResponseAnswer respAnswer : response.getJpaResponseAnswers()) {
                JpaResponseAnswerPK pk = respAnswer.getId();
                String question = respAnswer.getId().getJpaQuestion().getText();
                Map<String, Long> answerCount = answerCounts.get(question);
                if (answerCount == null) {
                    answerCount = new HashMap<>();
                    answerCounts.put(question, answerCount);
                }
                for (JpaAnswer answer : respAnswer.getAnswer()) {
                    Long count = answerCount.get(answer.getText());
                    if (count == null) {
                        count = new Long(1);
                    } else {
                        ++count;
                    }
                    answerCount.put(answer.getText(), count);
                }
            }
        }
    }

    public long getResponseCount() {
        return this.responseCount;
    }

    public Map<String, Map<String, Long>> getAnswerCounts() {
        return this.answerCounts;
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
