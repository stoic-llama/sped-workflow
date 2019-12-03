package edu.ccsu.sped.workflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ccsu.sped.workflow.dto.Workflow;
import edu.ccsu.sped.workflow.repos.WorkflowRepository;

@Service
public class WorkflowService {

	@Autowired
	private WorkflowRepository workflowRepository;
	
	// GET all 
	public List<Workflow> getWorkflows() {
		return (List<Workflow>) workflowRepository.findAll();
	}
	
	// GET single instance
	public Optional<Workflow> getWorkflowById(Integer Id) {
		return workflowRepository.findById(Id);
	}
	
	// POST new instance
	public void addWorkflow(Workflow workflow) {
		workflowRepository.save(workflow);
	}
	
	// PUT single existing instance to update
	public void updateWorkflow(Workflow workflow) {
		workflowRepository.save(workflow);
	}
	
	// DELETE single instance
	public void deleteWorkflowById(Integer Id) {
		workflowRepository.deleteById(Id);
	}
	
}
