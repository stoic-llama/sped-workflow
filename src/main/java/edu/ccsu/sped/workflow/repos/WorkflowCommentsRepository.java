package edu.ccsu.sped.workflow.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.ccsu.sped.workflow.dto.WorkflowComments;

@Repository
public interface WorkflowCommentsRepository extends CrudRepository<WorkflowComments, Integer>{

}
