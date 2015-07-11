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
package org.jasig.portlet.survey.mvc.service;

import java.util.List;

import org.jasig.portlet.survey.service.dto.*;

public interface ISurveyDataService {
    public boolean addQuestionToSurvey(Long surveyId, Long questionId, SurveyQuestionDTO surveyQuestion);

    public AnswerDTO createAnswerForQuestion(Long questionId, AnswerDTO answer);
    public SurveyDTO createSurvey(SurveyDTO survey);
    public QuestionDTO createQuestion(QuestionDTO question);
    public ITextGroup createTextGroup(ITextGroup textGroup);

    public List<SurveyDTO> getAllSurveys();
    public SurveyDTO getSurvey(long id);
    public SurveyDTO getSurveyByName(String surveyName);
    public List<SurveyQuestionDTO> getSurveyQuestions(Long surveyId);
    public ITextGroup getTextGroup(String textKey);

    public SurveyDTO updateSurvey(SurveyDTO survey);
    public QuestionDTO updateQuestion(QuestionDTO question);

    ResponseDTO createResponse(ResponseDTO response);
    ResponseDTO getResponse(long id);
    List<ResponseDTO> getResponseByUser(String user);
    ResponseDTO getResponseByUserAndSurvey(String user, long surveyId);
    ResponseDTO updateResponse(ResponseDTO response);

    SurveySummaryDTO getSurveySummary(Long surveyId);
}
