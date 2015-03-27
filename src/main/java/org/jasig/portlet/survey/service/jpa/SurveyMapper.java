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

import org.dozer.Mapper;
import org.jasig.portlet.survey.service.dto.AnswerDTO;
import org.jasig.portlet.survey.service.dto.QuestionAnswerDTO;
import org.jasig.portlet.survey.service.dto.QuestionDTO;
import org.jasig.portlet.survey.service.dto.SurveyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

/**
 * This class does the simple translation between the DTO and the JPA objects. 
 * @since 1.0
 */
@Service
class SurveyMapper implements ISurveyMapper {

    @Autowired
    private Mapper beanMapper;

    @Override
    public SurveyDTO toSurvey(JpaSurvey survey) {
        SurveyDTO result = beanMapper.map(survey, SurveyDTO.class);
        return result;
    }

    @Override
    public JpaSurvey toJpaSurvey(SurveyDTO survey) {
        return beanMapper.map(survey, JpaSurvey.class);
    }

    @Override
    public List<SurveyDTO> toSurveyList(List<JpaSurvey> jpaList) {
        return Lists.transform(jpaList, new Function<JpaSurvey, SurveyDTO>() {
            @Override
            public SurveyDTO apply(JpaSurvey jpaSurvey) {
                return toSurvey(jpaSurvey);
            }
        });
    }

    @Override
    public List<QuestionAnswerDTO> toQuestionAnswerList(List<JpaQuestionAnswer> jpaList) {
        return Lists.transform(jpaList, new Function<JpaQuestionAnswer, QuestionAnswerDTO>() {
            @Override
            public QuestionAnswerDTO apply(JpaQuestionAnswer jpaQuestionAnswer) {
                return toQuestionAnswer(jpaQuestionAnswer);
            }
        });
    }

    @Override
    public QuestionDTO toQuestion(JpaQuestion question) {
        return beanMapper.map(question, QuestionDTO.class);
    }

    @Override
    public JpaQuestion toJpaQuestion(QuestionDTO question) {
        return beanMapper.map(question, JpaQuestion.class);
    }

    @Override
    public AnswerDTO toAnswer(JpaAnswer answer) {
        return beanMapper.map(answer, AnswerDTO.class);
    }

    @Override
    public JpaAnswer toJpaAnswer(AnswerDTO answer) {
        return beanMapper.map(answer, JpaAnswer.class);
    }

    @Override
    public QuestionAnswerDTO toQuestionAnswer(JpaQuestionAnswer qa) {
        return beanMapper.map(qa, QuestionAnswerDTO.class);
    }

    @Override
    public JpaQuestionAnswer toJpaQuestionAnswer(QuestionAnswerDTO qa) {
        return beanMapper.map(qa, JpaQuestionAnswer.class);
    }

}
