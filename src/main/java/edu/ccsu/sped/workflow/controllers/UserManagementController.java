package edu.ccsu.sped.workflow.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ccsu.sped.workflow.services.UserService;

@Controller
public class UserManagementController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user-management")
	public String listUsers(Model model) {
		model.addAttribute("users", userService.getUsers());
		return "user-management";
	}
	
}