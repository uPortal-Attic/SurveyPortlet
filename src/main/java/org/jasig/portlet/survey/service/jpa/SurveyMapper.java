
package org.jasig.portlet.survey.service.jpa;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import java.util.List;
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
    
    @Override
    public List<SurveyDTO> toSurveyList( List<JpaSurvey> jpaList) {
        return Lists.transform( jpaList, new Function<JpaSurvey, SurveyDTO>() {
            @Override
            public SurveyDTO apply(JpaSurvey jpaSurvey) {
                return toSurvey(jpaSurvey);
            }
        });
    }
}
