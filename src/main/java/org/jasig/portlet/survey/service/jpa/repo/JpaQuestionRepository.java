package org.jasig.portlet.survey.service.jpa.repo;

import org.jasig.portlet.survey.service.jpa.JpaQuestion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaQuestionRepository extends CrudRepository<JpaQuestion, Long> {
    
}
