package edu.ccsu.sped.workflow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WorkflowManagementController {
	
	@GetMapping("/start-new-workflow")
	public String workflowManagement() {
		return "start-new-workflow";
	}
}
