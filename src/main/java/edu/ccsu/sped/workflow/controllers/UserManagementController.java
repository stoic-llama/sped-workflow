package edu.ccsu.sped.workflow.controllers;

import java.util.ArrayList;
// import java.util.Arrays;
import java.util.HashMap;
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
	
	
	// TODO Replace with a function that locally create Map<String,String> and returns Map
	// 2/6/2020 - John Liu
	//	private Map<String, String> mapRoles = Map.of(
	//		"reader", "Reader",
	//		"instructor", "Instructor",
	//		"coordinator", "Coordinator",
	//		"student", "Student"
	//	);
	
	private Map<String, String> returnRoles() {
		Map<String,String> mapRoles = new HashMap<String, String>(); { // initialize HashMap Java 8 way
			mapRoles.put("reader", "Reader");
			mapRoles.put("instructor", "Instructor");
			mapRoles.put("coordinator", "Coordinator");
			mapRoles.put("student", "Student");
		}
		return mapRoles;
	}
		
	@GetMapping("")
	public String userManagement(Model model) {
		model.addAttribute("users", userService.getUsers());
		model.addAttribute("mapRoles",returnRoles());
		//model.addAttribute("mapRoles",mapRoles);
		return "user-management";
	}

	@GetMapping(value = "/create")
	public String showCreateForm(Model model) {
		UserCreationDto usersForm = new UserCreationDto();
		
		usersForm.addUser(new User());
		
		model.addAttribute("form",usersForm);
		model.addAttribute("mapRoles",returnRoles());
		// model.addAttribute("mapRoles",mapRoles);
		
		return "createUsersForm";
	}
	
	@GetMapping(value = "/edit")
	public String showEditForm(Model model) {
		List<User> users = new ArrayList<>();
		userService.getUsers().iterator().forEachRemaining(users::add);
		
		model.addAttribute("form", new UserCreationDto(users));
		model.addAttribute("mapRoles",returnRoles());
		// model.addAttribute("mapRoles",mapRoles);
		
		return "editUsersForm";
	}
	
	@PostMapping(value = "/save")
	public String saveUsers(@ModelAttribute UserCreationDto form, Model model) {
		
		List<User> allUsers= new ArrayList<>(form.getUsers());
		
		for (User user : allUsers) {
			LoginData userLoginData = loginDataService.getLoginDataByUser(user);
			userLoginData.setUsername(user.getEmail());
			userLoginData.setPassword(passwordEncoder.encode(Integer.toString(user.getCcsuID())));;
			loginDataService.updateLoginData(userLoginData);
			
			List<UserAuthorities> userAuthorities = userAuthoritiesService.getUserAuthoritiesByLoginData(userLoginData);
			userAuthorities.get(0).setAuthority(user.getRole());
			userAuthoritiesService.saveAll(userAuthorities);
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