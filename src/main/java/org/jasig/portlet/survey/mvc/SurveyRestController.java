/*
 * Copyright 2015 Jasig.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jasig.portlet.survey.mvc;

import org.jasig.portlet.survey.mvc.service.ISurveyDataService;
import org.jasig.portlet.survey.service.dto.SurveyDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = SurveyRestController.REQUEST_ROOT, produces = MediaType.APPLICATION_JSON_VALUE)
public class SurveyRestController {
    private final Logger log = LoggerFactory.getLogger( getClass());
    static final String REQUEST_ROOT = "/v1/survey";
    
    @Autowired
    private ISurveyDataService dataService;
    
    
    /**
     * Search for survey specified by survey.
     * 
     * @param survey
     * @return 
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{survey}/questions")
    @ResponseBody SurveyDTO getSurveyQuestions( @PathVariable Long survey) {
        log.debug( "Get survey: " + survey);
        
        SurveyDTO surveyDTO = dataService.getSurvey( survey);
        return surveyDTO;
    }
    
    /**
     * Search for all surveys
     * 
     * @return 
     */
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    @ResponseBody List<SurveyDTO> getAllSurveyQuestions() {
        log.debug( "Get all surveys");
        
        List<SurveyDTO> surveyDTOList = dataService.getAllSurveys();
        return surveyDTOList;
    }
}
    
