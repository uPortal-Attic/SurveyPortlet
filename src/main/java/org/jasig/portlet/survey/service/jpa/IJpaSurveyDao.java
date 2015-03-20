
package org.jasig.portlet.survey.service.jpa;

import java.util.List;


interface IJpaSurveyDao {

    public JpaSurvey getSurvey(Long id);
    public List<JpaSurvey> getAllSurveys();
}
