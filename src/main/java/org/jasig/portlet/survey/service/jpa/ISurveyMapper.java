
package org.jasig.portlet.survey.service.jpa;

import org.jasig.portlet.survey.service.dto.SurveyDTO;

interface ISurveyMapper {
    SurveyDTO toSurvey( JpaSurvey survey);
    JpaSurvey toJpaSurvey( SurveyDTO survey);
}
