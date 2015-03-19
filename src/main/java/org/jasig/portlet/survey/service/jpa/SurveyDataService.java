
package org.jasig.portlet.survey.service.jpa;

import org.jasig.portlet.survey.mvc.service.ISurveyDataService;
import org.jasig.portlet.survey.service.dto.SurveyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SurveyDataService implements ISurveyDataService {
    
    @Autowired
    private IJpaSurveyDao surveyDao;
    
    @Autowired
    private ISurveyMapper surveyMapper;
    
    @Override
    @Transactional(readOnly = true)
    public SurveyDTO getSurvey( long id) {
        JpaSurvey survey = surveyDao.getSurvey( id);
        if( survey == null) {
            return null;
        }
        
        return surveyMapper.toSurvey( survey);
    }
}
