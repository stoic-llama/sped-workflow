package edu.ccsu.sped.workflow.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.ccsu.sped.workflow.dto.QuestionResponse;

@Repository
public interface QuestionResponseRepository extends CrudRepository<QuestionResponse, Integer>{

}
