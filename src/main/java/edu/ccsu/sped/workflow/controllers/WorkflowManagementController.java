package edu.ccsu.sped.workflow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.ccsu.sped.workflow.services.UserService;
import edu.ccsu.sped.workflow.services.WorkflowService;

@Controller
public class WorkflowManagementController {
	
	@Autowired
	private WorkflowService workflowService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/start-new-workflow")
	public String workflowManagement(Model model) {
		model.addAttribute("workflow", workflowService.getWorkflows());
		model.addAttribute("user", userService.getUsers());
		return "start-new-workflow";
	}
	
	
	
}
