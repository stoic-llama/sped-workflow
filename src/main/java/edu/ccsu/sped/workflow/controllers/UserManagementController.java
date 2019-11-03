package edu.ccsu.sped.workflow.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ccsu.sped.workflow.dto.User;
import edu.ccsu.sped.workflow.dto.UserCreationDto;
import edu.ccsu.sped.workflow.services.UserService;

@Controller
@RequestMapping("/user-management")

public class UserManagementController {
	
	@Autowired
	private UserService userService;
	
	private Map<String, String> mapRoles = Map.of(
		"reader", "Reader",
		"instructor", "Instructor",
		"coordinator", "Coordinator",
		"student", "Student"
	);

	@GetMapping("")
	public String userManagement(Model model) {
		model.addAttribute("users", userService.getUsers());
		model.addAttribute("mapRoles",mapRoles);
		return "user-management";
	}

	@GetMapping(value = "/create")
	public String showCreateForm(Model model) {
		UserCreationDto usersForm = new UserCreationDto();
		
		usersForm.addUser(new User());
		
		model.addAttribute("form",usersForm);
		model.addAttribute("mapRoles",mapRoles);
		
		return "createUsersForm";
	}
	
	@GetMapping(value = "/edit")
	public String showEditForm(Model model) {
		List<User> users = new ArrayList<>();
		userService.getUsers().iterator().forEachRemaining(users::add);
		
		model.addAttribute("form", new UserCreationDto(users));
		model.addAttribute("mapRoles",mapRoles);
		
		return "editUsersForm";
	}
	
	@PostMapping(value = "/save")
	public String saveUsers(@ModelAttribute UserCreationDto form, Model model) {
		userService.saveAll(form.getUsers());
		
		model.addAttribute("users", userService.getUsers());
		
		return "redirect:/user-management";
	}
	
}