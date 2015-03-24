
package org.jasig.portlet.survey.service.jpa;

import java.util.List;
import org.jasig.portlet.survey.service.dto.AnswerDTO;
import org.jasig.portlet.survey.service.dto.QuestionAnswerDTO;
import org.jasig.portlet.survey.service.dto.QuestionDTO;
import org.jasig.portlet.survey.service.dto.SurveyDTO;

interface ISurveyMapper {
    SurveyDTO toSurvey( JpaSurvey survey);
    JpaSurvey toJpaSurvey( SurveyDTO survey);
    
    QuestionDTO toQuestion( JpaQuestion question);
    JpaQuestion toJpaQuestion( QuestionDTO question);
    
    AnswerDTO toAnswer( JpaAnswer answer);
    JpaAnswer toJpaAnswer( AnswerDTO answer);
    
    QuestionAnswerDTO toQuestionAnswer( JpaQuestionAnswer qa);
    JpaQuestionAnswer toJpaQuestionAnswer( QuestionAnswerDTO qa);
    
    public List<SurveyDTO> toSurveyList( List<JpaSurvey> jpaList);
    public List<QuestionAnswerDTO> toQuestionAnswerList( List<JpaQuestionAnswer> jpaList);
}
