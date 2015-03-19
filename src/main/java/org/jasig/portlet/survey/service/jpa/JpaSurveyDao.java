
package org.jasig.portlet.survey.service.jpa;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
class JpaSurveyDao implements IJpaSurveyDao {

    @Autowired
    private JpaSurveyRepository surveyRepository;
    
    @Transactional(readOnly = true, propagation=Propagation.SUPPORTS)
    @Override
    public JpaSurvey getSurvey(Long id) {
        Validate.isTrue( id > 0, "Invalid survey id: " + id);
        JpaSurvey survey = surveyRepository.findOne( id);
        return survey;
    }
    
}
