package edu.ccsu.sped.workflow.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ccsu.sped.workflow.dto.LoginData;
import edu.ccsu.sped.workflow.dto.User;
import edu.ccsu.sped.workflow.dto.UserAuthorities;
import edu.ccsu.sped.workflow.dto.UserCreationDto;
import edu.ccsu.sped.workflow.services.LoginDataService;
import edu.ccsu.sped.workflow.services.UserAuthoritiesService;
import edu.ccsu.sped.workflow.services.UserService;

@Controller
@RequestMapping("/user-management")

public class UserManagementController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginDataService loginDataService;
	
	@Autowired
	private UserAuthoritiesService userAuthoritiesService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
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
		
		System.out.println(userService.getUserByEmail("christopher.smith@my.ccsu.edu").getLoginData().getUsername());		
		System.out.println(userService.getUserByEmail("christopher.smithers@my.ccsu.edu").getLoginData().getUsername());
		
		model.addAttribute("form", new UserCreationDto(users));
		model.addAttribute("mapRoles",mapRoles);
		
		return "editUsersForm";
	}
	
	@PostMapping(value = "/save")
	public String saveUsers(@ModelAttribute UserCreationDto form, Model model) {
		
		List<User> allUsers= new ArrayList<>(form.getUsers());
		
		for (User user : allUsers) {
			user.getLoginData().setUsername(user.getEmail());
			user.getLoginData().setPassword(passwordEncoder.encode(Integer.toString(user.getCcsuID())));
			//loginDataService.updateLoginData(user.getLoginData());
			user.getLoginData().getUserAuthorities().clear();
			user.getLoginData().getUserAuthorities().get(0).setAuthority(user.getRole());
			//userAuthoritiesService.saveAll(user.getLoginData().getUserAuthorities());
		}
		
		userService.saveAll(allUsers);
		
		model.addAttribute("users", userService.getUsers());
		
		return "redirect:/user-management";
	}
	
	@PostMapping(value = "/savenew")
	public String saveNewUser(@ModelAttribute UserCreationDto form, Model model) {
		userService.saveAll(form.getUsers());
		
		User newUser = userService.getUserByEmail(form.getUsers().get(0).getEmail());

		LoginData newUserLoginData = new LoginData(newUser.getEmail(),passwordEncoder.encode(Integer.toString(newUser.getCcsuID())),newUser);
		loginDataService.addLoginData(newUserLoginData);
			
		UserAuthorities newUserAuthorities = new UserAuthorities(newUser.getEmail(),newUser.getRole(),newUserLoginData);
		userAuthoritiesService.addUserAuthorities(newUserAuthorities);

		model.addAttribute("users", userService.getUsers());
		
		return "redirect:/user-management";
	}
	
}