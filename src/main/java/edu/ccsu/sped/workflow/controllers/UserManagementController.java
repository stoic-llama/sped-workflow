package edu.ccsu.sped.workflow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserManagementController {
	
	@GetMapping("/user-management")
	public String userManagement() {
		return "user-management";
	}
}