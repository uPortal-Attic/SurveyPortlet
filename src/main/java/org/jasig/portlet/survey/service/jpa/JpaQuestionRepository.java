package org.jasig.portlet.survey.service.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaQuestionRepository extends CrudRepository<JpaQuestion, Long> {
    
}
