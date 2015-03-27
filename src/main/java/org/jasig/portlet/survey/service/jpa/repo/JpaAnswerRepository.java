package org.jasig.portlet.survey.service.jpa.repo;

import org.jasig.portlet.survey.service.jpa.JpaAnswer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAnswerRepository extends CrudRepository<JpaAnswer, Long> {
    
}
