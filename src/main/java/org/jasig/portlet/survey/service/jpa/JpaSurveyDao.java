
package org.jasig.portlet.survey.service.jpa;

import java.util.List;
import org.apache.commons.collections.IteratorUtils;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class JpaSurveyDao implements IJpaSurveyDao {

    @Autowired
    private JpaSurveyRepository surveyRepository;
    
    /**
     * Search for a JpaSurvey based on the specified id.
     * 
     * @param id
     * @return 
     */
    @Override
    public JpaSurvey getSurvey(Long id) {
        Validate.isTrue( id > 0, "Invalid survey id: " + id);
        JpaSurvey survey = surveyRepository.findOne( id);
        return survey;
    }

    /**
     * 
     * @return All surveys
     */
    @Override
    public List<JpaSurvey> getAllSurveys() {
        Iterable surveyIter = surveyRepository.findAll();
        List<JpaSurvey> surveyList = IteratorUtils.toList( surveyIter.iterator());
        return surveyList;
    }
    
}
