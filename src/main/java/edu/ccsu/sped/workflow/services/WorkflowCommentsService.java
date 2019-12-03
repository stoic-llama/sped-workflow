package edu.ccsu.sped.workflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ccsu.sped.workflow.dto.WorkflowComments;
import edu.ccsu.sped.workflow.repos.WorkflowCommentsRepository;

@Service
public class WorkflowCommentsService {

	@Autowired
	private WorkflowCommentsRepository workflowCommentsRepository;
	
	// GET all 
		public List<WorkflowComments> getWorkflowComments() {
			return (List<WorkflowComments>) workflowCommentsRepository.findAll();
		}
	
	// GET single instance
	public Optional<WorkflowComments> getWorkflowCommentsById(Integer Id) {
		return workflowCommentsRepository.findById(Id);
	}
	
	// POST new instance
	public void addWorkflowComments(WorkflowComments workflowComments) {
		workflowCommentsRepository.save(workflowComments);
	}
	
	// PUT single existing instance to update
	public void updateWorkflowComments(WorkflowComments workflowComments) {
		workflowCommentsRepository.save(workflowComments);
	}
	
	// DELETE single instance
	public void deleteWorkflowCommentsById(Integer Id) {
		workflowCommentsRepository.deleteById(Id);
	}
	
	public void saveAll(List<WorkflowComments> workflowCommentses) {
		
		for(WorkflowComments workflowComments : workflowCommentses) {
			workflowCommentsRepository.save(workflowComments);
		}
	}
	
	
}