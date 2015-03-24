package org.jasig.portlet.survey.service.jpa;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import java.util.List;
import org.dozer.Mapper;
import org.jasig.portlet.survey.service.dto.AnswerDTO;
import org.jasig.portlet.survey.service.dto.QuestionAnswerDTO;
import org.jasig.portlet.survey.service.dto.QuestionDTO;
import org.jasig.portlet.survey.service.dto.SurveyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class SurveyMapper implements ISurveyMapper {

    @Autowired
    private Mapper beanMapper;
    
    @Override
    public SurveyDTO toSurvey( JpaSurvey survey) {
        return beanMapper.map( survey, SurveyDTO.class);
    }
    
    @Override
    public JpaSurvey toJpaSurvey( SurveyDTO survey) {
        return beanMapper.map( survey, JpaSurvey.class);
    }
    
    @Override
    public List<SurveyDTO> toSurveyList( List<JpaSurvey> jpaList) {
        return Lists.transform( jpaList, new Function<JpaSurvey, SurveyDTO>() {
            @Override
            public SurveyDTO apply(JpaSurvey jpaSurvey) {
                return toSurvey(jpaSurvey);
            }
        });
    }

    @Override
    public List<QuestionAnswerDTO> toQuestionAnswerList( List<JpaQuestionAnswer> jpaList) {
        return Lists.transform( jpaList, new Function<JpaQuestionAnswer, QuestionAnswerDTO>() {
            @Override
            public QuestionAnswerDTO apply(JpaQuestionAnswer jpaQuestionAnswer) {
                return toQuestionAnswer(jpaQuestionAnswer);
            }
        });
    }
    
    @Override
    public QuestionDTO toQuestion(JpaQuestion question) {
        return beanMapper.map( question, QuestionDTO.class);
    }

    @Override
    public JpaQuestion toJpaQuestion(QuestionDTO question) {
        return beanMapper.map( question, JpaQuestion.class);
    }

    @Override
    public AnswerDTO toAnswer(JpaAnswer answer) {
        return beanMapper.map( answer, AnswerDTO.class);
    }

    @Override
    public JpaAnswer toJpaAnswer(AnswerDTO answer) {
        return beanMapper.map( answer, JpaAnswer.class);
    }

    @Override
    public QuestionAnswerDTO toQuestionAnswer(JpaQuestionAnswer qa) {
        return beanMapper.map( qa, QuestionAnswerDTO.class);
    }

    @Override
    public JpaQuestionAnswer toJpaQuestionAnswer(QuestionAnswerDTO qa) {
        return beanMapper.map( qa, JpaQuestionAnswer.class);
    }
    
    
}
