package org.jasig.portlet.survey.service.jpa;

import org.springframework.data.repository.CrudRepository;

public interface JpaQuestionAnswerRepository extends CrudRepository<JpaQuestionAnswer, Long> {
    
}
