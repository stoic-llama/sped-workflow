package edu.ccsu.sped.workflow.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.ccsu.sped.workflow.dto.User;
import edu.ccsu.sped.workflow.dto.Workflow;
import edu.ccsu.sped.workflow.dto.WorkflowHelper;
import edu.ccsu.sped.workflow.services.UserService;
import edu.ccsu.sped.workflow.services.WorkflowService;

@Controller
public class WorkflowManagementController {
	
	@Autowired
	private WorkflowService workflowService;
	
	@Autowired
	private UserService userService;
    
	@GetMapping("/")
	public String index(Model model) {
		List<WorkflowHelper> workflowHelpers = new LinkedList<WorkflowHelper>();
		workflowHelpers = getActiveWorkflowsWithUsers();
		Workflow workflow = new Workflow();	
		model.addAttribute("activeWorkflows", workflowHelpers);
		model.addAttribute("users", userService.getUsers());
		model.addAttribute("workflow",workflow);	
		return "index";
	}
	
	@GetMapping("/workflow-management")
	public String workflowManagement(Model model) {
		List<WorkflowHelper> workflowHelpers = new LinkedList<WorkflowHelper>();
		workflowHelpers = getActiveWorkflowsWithUsers();
		Workflow workflow = new Workflow();	
		model.addAttribute("activeWorkflows", workflowHelpers);
		model.addAttribute("users", userService.getUsers());
		model.addAttribute("workflow",workflow);	
		return "workflow-management";
	}
	
	
	private List<WorkflowHelper> getActiveWorkflowsWithUsers () {
		// get all the workflows that are not equal to "DONE"
		List<Workflow> workflows = workflowService.getWorkflows();
		List<WorkflowHelper> workflowHelpers = new LinkedList<WorkflowHelper>();
		Optional<User> u;
		User user = new User();
		
		for (Workflow workflow : workflows) {
			if (!(workflow.getStatus().equals("DONE"))) { // Not equal Done
				WorkflowHelper w = new WorkflowHelper(); 
				
				// Get Wid
				w.setWid(workflow.getWid());
				
				// Get Primary Reader First and Last Name
				u = userService.getUserById(workflow.getPrimaryReaderUid());
				user = u.get();
				w.setPrimaryReaderFName(user.getFname());
				w.setPrimaryReaderLName(user.getLname());

				// Get Student First and Last Name
				u = userService.getUserById(workflow.getStudentUid());
				user = u.get();
				w.setStudentFName(user.getFname());
				w.setStudentLName(user.getLname());

				// Get Secondary Reader First and Last Name
				u = userService.getUserById(workflow.getSecondaryReaderUid());
				user = u.get();
				w.setSecondaryReaderFName(user.getFname());
				w.setSecondaryReaderLName(user.getLname());

				// Get Workflow Status
				w.setWorkflowStatus(workflow.getStatus());
				
				// Add element to list of workflowHelpers  
				workflowHelpers.add(w);
			}
		}
		
		// return list of all active workflows with names, embodied in list of workflowHelpers
		return workflowHelpers;	
	}
	
	
	
	
	
	
	@GetMapping(value = "/oneworkflow")
	@ResponseBody
	public Optional<Workflow> getWorkflowById(Integer Id, Model model) {
		return workflowService.getWorkflowById(Id); 
	}
	
	@PostMapping(value = "/addWorkflow/")
	public String addWorkflow( Workflow workflow ) {
		List <User> u = workflow.getUser();
		
		Optional<User> pr = userService.getUserById(workflow.getPrimaryReaderUid());
		User primaryReader = pr.get();
		u.add(primaryReader);
		
		Optional<User> s = userService.getUserById(workflow.getStudentUid());
		User student = s.get();
		u.add(student);
		
		Optional<User> sr = userService.getUserById(workflow.getSecondaryReaderUid());
		User secondaryReader = sr.get();
		u.add(secondaryReader);
		
		workflowService.addWorkflow(workflow);
		
		return "redirect:/workflow-management"; // go back to workflow-management page after updating database
	}

}