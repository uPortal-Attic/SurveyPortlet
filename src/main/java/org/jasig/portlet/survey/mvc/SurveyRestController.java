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
package org.jasig.portlet.survey.mvc;

import java.security.Principal;
import java.util.List;

import org.jasig.portlet.survey.mvc.service.ISurveyDataService;
import org.jasig.portlet.survey.service.dto.ITextGroup;
import org.jasig.portlet.survey.service.dto.QuestionDTO;
import org.jasig.portlet.survey.service.dto.SurveyDTO;
import org.jasig.portlet.survey.service.dto.SurveyQuestionDTO;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(name = "SurveyPortlet services", description = "Methods for managing surveys")
@Controller
@RequestMapping(value = SurveyRestController.REQUEST_ROOT, produces = MediaType.APPLICATION_JSON_VALUE)
public class SurveyRestController {
    static final String REQUEST_ROOT = "/v1/surveys";
    @Autowired
    private ISurveyDataService dataService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * Create a new question that is not associated with a survey.
     * 
     * @param question
     * @return
     */
    @PreAuthorize("hasRole('ADMIN')")
    @ApiMethod(description = "Create a new question that is not associated with a survey.", responsestatuscode = "201 - Created")
    @RequestMapping(method = RequestMethod.POST, value = "/questions")
    public @ApiResponseObject ResponseEntity<QuestionDTO> addQuestion(@ApiBodyObject @RequestBody QuestionDTO question) {
        QuestionDTO newQuestion = dataService.createQuestion(question);
        return new ResponseEntity<>(newQuestion, HttpStatus.CREATED);
    }

    /**
     * Create a survey
     * 
     * @param survey
     * @return
     */
    @PreAuthorize("hasRole('ADMIN')")
    @ApiMethod(description = "Create a survey", responsestatuscode = "201")
    @RequestMapping(method = RequestMethod.POST, value = "/")
    public @ApiResponseObject ResponseEntity<SurveyDTO> addSurvey(@ApiBodyObject @RequestBody SurveyDTO survey, Principal principal) {
        survey.setLastUpdateUser(principal.getName());
        SurveyDTO newSurvey = null;
        HttpStatus status = HttpStatus.CREATED;

        try {
            newSurvey = dataService.createSurvey(survey);
        }
        catch (Exception e) {
            status = HttpStatus.BAD_REQUEST;
            log.error("Error creating survey: " + survey.toString(), e);
        }

        return new ResponseEntity<>(newSurvey, status);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ApiMethod(description = "Create a text group", responsestatuscode = "201")
    @RequestMapping(method = RequestMethod.POST, value = "/textGroup")
    public @ApiResponseObject ResponseEntity<ITextGroup> addTextGroup(@ApiBodyObject @RequestBody TextGroupImpl textGroup) {
        ITextGroup tg = dataService.createTextGroup(textGroup);
        return new ResponseEntity<>(tg, HttpStatus.CREATED);
    }

    /**
     * Search for all surveys
     * 
     * @return
     */
    @ApiMethod(description = "Fetch all surveys", responsestatuscode = "201")
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public @ApiResponseObject ResponseEntity<List<SurveyDTO>> getAllSurveys() {
        log.debug("Get all surveys");
        List<SurveyDTO> surveyDTOList = dataService.getAllSurveys();
        return new ResponseEntity<>(surveyDTOList, HttpStatus.OK);
    }

    /**
     * Search for survey specified by survey.
     * 
     * @param survey
     * @return
     */
    @ApiMethod(description = "Fetch a survey by id", responsestatuscode = "201")
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(method = RequestMethod.GET, value = "/{survey}")
    public @ApiResponseObject ResponseEntity<SurveyDTO> getSurvey(@ApiPathParam(name = "survey") @PathVariable Long survey) {
        log.debug("Get survey: " + survey);
        SurveyDTO surveyDTO = dataService.getSurvey(survey);
        return new ResponseEntity(surveyDTO, HttpStatus.OK);
    }

    /**
     * Search for survey specified by surveyname.
     * 
     * @param surveyName
     * @return
     */
    @ApiMethod(description = "Fetch a survey by name", responsestatuscode = "201")
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(method = RequestMethod.GET, value = "/surveyByName/{surveyName}")
    public ResponseEntity<SurveyDTO> getSurvey(@ApiPathParam(name = "surveyName") @PathVariable String surveyName) {
        log.debug("Get survey: " + surveyName);
        SurveyDTO surveyDTO = dataService.getSurveyByName(surveyName);
        return new ResponseEntity(surveyDTO, HttpStatus.OK);
    }

    /**
     * Search for questions/answers that are associated with the specified survey.
     * 
     * @param survey
     * @return
     */
    @ApiMethod
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(method = RequestMethod.GET, value = "/{survey}/questions")
    public ResponseEntity<SurveyDTO> getSurveyQuestions(@ApiPathParam(name = "survey") @PathVariable Long survey) {
        log.debug("Get survey: " + survey);

        List<SurveyQuestionDTO> sqList = dataService.getSurveyQuestions(survey);
        return new ResponseEntity(sqList, HttpStatus.OK);
    }

    /**
     * Fetch method for getting text detail by key.
     * 
     * @param textKey
     * @return
     */
    @ApiMethod(description = "Fetch a text group by key", responsestatuscode = "201")
    @RequestMapping(method = RequestMethod.GET, value = "/textGroup/{textKey}")
    public ResponseEntity<ITextGroup> getTextGroup(@PathVariable String textKey) {
        log.debug("Get text group by key: " + textKey);
        ITextGroup textGroup = dataService.getTextGroup(textKey);
        return new ResponseEntity<>(textGroup, HttpStatus.OK);
    }

    /**
     * Associate an existing question to an existing survey
     * 
     * @param survey
     * @param question
     * @param surveyQuestion
     * @return
     */
    @PreAuthorize("hasRole('ADMIN')")
    @ApiMethod(description = "Associate an existing question to an existing survey", responsestatuscode = "201")
    @RequestMapping(method = RequestMethod.POST, value = "/{survey}/questions/{question}")
    public @ApiResponseObject ResponseEntity<Boolean> linkQuestionToSurvey(
                    @ApiPathParam(name = "survey") @PathVariable Long survey,
                    @ApiPathParam(name = "question") @PathVariable Long question,
                    @ApiBodyObject @RequestBody SurveyQuestionDTO surveyQuestion) {
        Boolean ret;
        HttpStatus status = HttpStatus.CREATED;

        try {
            ret = dataService.addQuestionToSurvey(survey, question, surveyQuestion);
        }
        catch (Exception e) {
            status = HttpStatus.BAD_REQUEST;
            ret = false;
            log.error("Error linking question to survey", e);
        }
        return new ResponseEntity<>(ret, status);
    }

    /**
     * 
     * @param questionId
     * @param question
     * @return
     */
    @PreAuthorize("hasRole('ADMIN')")
    @ApiMethod(description = "Update a question", responsestatuscode = "201 - Created")
    @RequestMapping(method = RequestMethod.PUT, value = "/questions/{questionId}")
    public ResponseEntity<QuestionDTO> updateQuestion(@ApiPathParam(name = "questionId") @PathVariable Long questionId,
                    @ApiBodyObject @RequestBody QuestionDTO question) {
        HttpStatus status = HttpStatus.CREATED;
        QuestionDTO updatedQuestion = null;

        try {
            question.setId(questionId);
            updatedQuestion = dataService.updateQuestion(question);

            if (updatedQuestion == null) {
                status = HttpStatus.BAD_REQUEST;
            }
        }
        catch (Exception e) {
            status = HttpStatus.BAD_REQUEST;
            log.error("Error linking question to survey", e);
        }

        return new ResponseEntity<>(updatedQuestion, status);
    }

    /**
     * Update survey
     * 
     * @param surveyId
     * @param survey 
     *            {@link SurveyDTO} containing data to update
     * @return
     */
    @PreAuthorize("hasRole('ADMIN')")
    @ApiMethod(description = "Update survey", responsestatuscode = "201 - Created")
    @RequestMapping(method = RequestMethod.PUT, value = "/{surveyId}")
    public ResponseEntity<SurveyDTO> updateSurvey(@ApiPathParam(name = "surveyId") @PathVariable Long surveyId,
                    @ApiBodyObject @RequestBody SurveyDTO survey, Principal principal) {
        survey.setLastUpdateUser(principal.getName());
        HttpStatus status = HttpStatus.CREATED;
        SurveyDTO updatedSurvey = null;

        try {
            survey.setId(surveyId);
            updatedSurvey = dataService.updateSurvey(survey);

            if (updatedSurvey == null) {
                status = HttpStatus.BAD_REQUEST;
            }
        }
        catch (Exception e) {
            status = HttpStatus.BAD_REQUEST;
            log.error("Error linking question to survey", e);
        }

        return new ResponseEntity<>(updatedSurvey, status);

    }
}
