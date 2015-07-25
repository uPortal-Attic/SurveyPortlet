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

import org.jasig.portlet.survey.service.dto.ResponseDTO;
import org.jasig.portlet.survey.service.dto.SurveyDTO;
import org.springframework.web.servlet.ModelAndView;

/**
 * Concrete instances of this interface know how to generate a report for a
 * survey.  The 'report' is the screen that appears when a user completes a
 * survey and submits his answers (a.k.a. the 'Response').
 *
 * @author drewwills
 */
public interface ISurveyReportGenerator {

    /**
     * Used to decide which {@link ISurveyReportGenerator} instances take
     * precedence over others.  Lower priority values trump higher values.  The
     * first {@link ISurveyReportGenerator} that claims a report wins.
     */
    int getPriority();

    /**
     * {@link ISurveyReportGenerator} instances are responsible for knowing the
     * surveys for which they are supposed to generate reports.  There is a
     * {@link DefaultSurveyReportGenerator} that will prepare a report if no
     * other generator claims the survey.
     */
    boolean appliesTo(SurveyDTO survey);

    ModelAndView generateReport(SurveyDTO survey, ResponseDTO response);

}
