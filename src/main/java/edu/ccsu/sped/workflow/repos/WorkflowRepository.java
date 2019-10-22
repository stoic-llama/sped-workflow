package edu.ccsu.sped.workflow.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.ccsu.sped.workflow.dto.Workflow;

@Repository
public interface WorkflowRepository extends CrudRepository<Workflow, Integer>{

}
