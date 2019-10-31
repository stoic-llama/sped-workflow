package edu.ccsu.sped.workflow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ccsu.sped.workflow.services.UserService;

@Controller
public class UserManagementController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user-management")
	public String userManagement() {
		return "user-management";
	}
}