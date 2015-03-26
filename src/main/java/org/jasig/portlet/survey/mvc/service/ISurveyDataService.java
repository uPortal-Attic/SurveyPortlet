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
import org.jasig.portlet.survey.service.dto.AnswerDTO;
import org.jasig.portlet.survey.service.dto.QuestionDTO;
import org.jasig.portlet.survey.service.dto.SurveyDTO;
import org.jasig.portlet.survey.service.dto.SurveyQuestionDTO;

public interface ISurveyDataService {
    public boolean addQuestionToSurvey(Long surveyId, Long questionId, SurveyQuestionDTO surveyQuestion);
    
    public AnswerDTO createAnswerForQuestion(Long questionId, AnswerDTO answer);
    public QuestionDTO createQuestion(QuestionDTO question);
    public QuestionDTO createQuestionForSurvey(Long surveyId, QuestionDTO question);
    public SurveyDTO createSurvey(SurveyDTO survey);
    
    public SurveyDTO getSurvey(long id);
    
    public List<SurveyDTO> getAllSurveys();
    
    public SurveyDTO updateSurvey( SurveyDTO survey);
    public SurveyDTO getSurveyByName(String surveyName);

    public List<SurveyQuestionDTO> getSurveyQuestions(Long surveyId);

    public QuestionDTO updateQuestion(QuestionDTO question);
}
