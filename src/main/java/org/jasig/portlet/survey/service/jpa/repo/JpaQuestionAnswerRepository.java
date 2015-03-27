package org.jasig.portlet.survey.service.jpa.repo;

import org.jasig.portlet.survey.service.jpa.JpaQuestionAnswer;
import org.springframework.data.repository.CrudRepository;

public interface JpaQuestionAnswerRepository extends CrudRepository<JpaQuestionAnswer, Long> {
    
}
