package org.jasig.portlet.survey.service.jpa.repo;

import org.jasig.portlet.survey.service.jpa.JpaSurveyQuestion;
import org.springframework.data.repository.CrudRepository;

public interface JpaSurveyQuestionRepository extends CrudRepository<JpaSurveyQuestion, Long> {
    
}
