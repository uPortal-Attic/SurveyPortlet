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

package org.jasig.portlet.survey.service.report;

import java.util.HashMap;
import java.util.Map;

import org.jasig.portlet.survey.service.dto.ResponseDTO;
import org.jasig.portlet.survey.service.dto.SurveyDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 * Prepares a report for any unclaimed surveys.
 *
 * @author drewwills
 */
@Service
public class DefaultSurveyReportGenerator implements ISurveyReportGenerator {

    private static final String DEFAULT_VIEW_NAME = "reports/default";

    @Override
    public int getPriority() {
        // Always last
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean appliesTo(SurveyDTO survey) {
        /* This generator MUST be tried last;
         * it will handle any unclaimed survey.
         */
        return true;
    }

    @Override
    public ModelAndView generateReport(SurveyDTO survey, ResponseDTO response) {
        final Map<String,Object> model = new HashMap<>();
        model.put("survey", survey);
        model.put("response", response);
        return new ModelAndView(DEFAULT_VIEW_NAME, model);
    }


}
