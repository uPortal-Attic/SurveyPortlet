package org.jasig.portlet.survey.service.jpa;

import org.springframework.data.repository.CrudRepository;

public interface JpaSurveyQuestionRepository extends CrudRepository<JpaSurveyQuestion, Long> {
    
}
