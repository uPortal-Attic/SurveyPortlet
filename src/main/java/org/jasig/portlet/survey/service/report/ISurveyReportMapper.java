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

import org.jasig.portlet.survey.service.dto.SurveyDTO;

/**
 * This interface defines the contract through which the REST API knows which
 * {@link ISurveyReportGenerator} to use for a specific survey.  The 'report' is
 * the screen that appears when a user completes a survey and submits his
 * answers (a.k.a. the 'Response').  Reports for responses submitted in the past
 * may be re-generated and re-displayed.
 *
 * @author drewwills
 */
public interface ISurveyReportMapper {


    /**
     * Provides the one instance of {@link ISurveyReportGenerator} mapped to the
     * survey with the specified cannonicalName.  This method will never return
     * null;  there is a {@link DefaultSurveyReportGenerator} that merely thanks
     * the user for his response.
     *
     * @param survey The survey instance for which a generator is needed
     * @return A working instance of {@link ISurveyReportGenerator};  never null.
     */
    ISurveyReportGenerator getReportGenerator(SurveyDTO survey);

}
