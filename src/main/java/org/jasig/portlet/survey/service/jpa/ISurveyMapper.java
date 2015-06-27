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

import java.util.List;

import org.jasig.portlet.survey.service.dto.*;

public interface ISurveyMapper {
    SurveyDTO toSurvey(JpaSurvey survey);
    JpaSurvey toJpaSurvey(SurveyDTO survey);

    QuestionDTO toQuestion(JpaQuestion question);
    JpaQuestion toJpaQuestion(QuestionDTO question);

    AnswerDTO toAnswer(JpaAnswer answer);
    JpaAnswer toJpaAnswer(AnswerDTO answer);

    QuestionAnswerDTO toQuestionAnswer(JpaQuestionAnswer qa);
    JpaQuestionAnswer toJpaQuestionAnswer(QuestionAnswerDTO qa);

    public List<SurveyDTO> toSurveyList(List<JpaSurvey> jpaList);
    public List<QuestionAnswerDTO> toQuestionAnswerList(List<JpaQuestionAnswer> jpaList);

    ResponseDTO toResponse(JpaResponse response);
    JpaResponse toJpaResponse(ResponseDTO response);

    ResponseAnswerDTO toResponseAnswer(JpaResponseAnswer answer);
    JpaResponseAnswer toJpaResponseAnswer(ResponseAnswerDTO answer);

    List<ResponseDTO> toResponseList(List<JpaResponse> responseList);
}
