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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.jasig.portlet.survey.service.dto.SurveyDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class SurveyReportMapperImpl implements ISurveyReportMapper, ApplicationContextAware {

    private ApplicationContext applicationContext;
    private final List<ISurveyReportGenerator> generators = new ArrayList<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init() {
        Map<String, ISurveyReportGenerator> beans = applicationContext.getBeansOfType(ISurveyReportGenerator.class);
        generators.addAll(beans.values());
        Collections.sort(generators, new Comparator<ISurveyReportGenerator>() {
            @Override
            public int compare(ISurveyReportGenerator g1, ISurveyReportGenerator g2) {
                return g1.getPriority() - g2.getPriority();
            }
        });
    }

    @Override
    public ISurveyReportGenerator getReportGenerator(SurveyDTO survey) {
        // First generator that claims the survey -- in order or priority -- wins.
        ISurveyReportGenerator rslt = null;
        for (ISurveyReportGenerator g : generators) {
            if (g.appliesTo(survey)) {
                rslt = g;
                break;
            }
        }
        // There should always be a non-null return
        // value thanks to DefaultServeyReportGenerator
        return rslt;
    }

}
