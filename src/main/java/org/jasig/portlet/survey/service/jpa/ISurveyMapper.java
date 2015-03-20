
package org.jasig.portlet.survey.service.jpa;

import java.util.List;
import org.jasig.portlet.survey.service.dto.SurveyDTO;

interface ISurveyMapper {
    SurveyDTO toSurvey( JpaSurvey survey);
    JpaSurvey toJpaSurvey( SurveyDTO survey);
    
    public List<SurveyDTO> toSurveyList( List<JpaSurvey> jpaList);
}
