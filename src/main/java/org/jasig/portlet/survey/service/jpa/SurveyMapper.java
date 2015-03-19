
package org.jasig.portlet.survey.service.jpa;

import org.dozer.Mapper;
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
}
