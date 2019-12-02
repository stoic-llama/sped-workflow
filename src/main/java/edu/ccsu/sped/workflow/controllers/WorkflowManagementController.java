package edu.ccsu.sped.workflow.controllers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.ccsu.sped.workflow.dto.LoginData;
import edu.ccsu.sped.workflow.dto.User;
import edu.ccsu.sped.workflow.dto.UserAuthorities;
import edu.ccsu.sped.workflow.dto.UserCreationDto;
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
    	
	@GetMapping(value={"/","/index"})
	public String index(Model model) {
		List<WorkflowHelper> workflowHelpers = new LinkedList<WorkflowHelper>();
		workflowHelpers = getActiveWorkflowsByAuthenticatedUser();
		Workflow workflow = new Workflow();	
		model.addAttribute("activeWorkflows", workflowHelpers);
		model.addAttribute("users", userService.getUsers());
		model.addAttribute("workflow",workflow);	
		return "index";
	}
	
	@GetMapping(value={"/view-all-workflows"})
	public String viewAllWorkflows(Model model) {
		List<WorkflowHelper> workflowHelpers = new LinkedList<WorkflowHelper>();
		workflowHelpers = getActiveWorkflowsWithUsers();
		Workflow workflow = new Workflow();	
		model.addAttribute("activeWorkflows", workflowHelpers);
		model.addAttribute("users", userService.getUsers());
		model.addAttribute("workflow",workflow);	
		return "view-all-workflows";
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
	
	@GetMapping("/submitassignment")
	public String submitAssignment(Model model) {
		List<WorkflowHelper> workflows= getActiveWorkflowsByAuthenticatedUser();
		
		WorkflowHelper workflowHelper = workflows.get(0);
		
		
		Workflow workflow = workflowService.getWorkflowById(workflowHelper.getWid()).get();
		
		model.addAttribute("activeworkflow", workflow);
		
		return"submit-assignment";
	}
	
	@PostMapping(value = "/saveportfolio")
	public String savePortfolioURL(@ModelAttribute("activeworkflow") Workflow activeworkflow, Model model) {

		workflowService.updateWorkflow(activeworkflow);
		
		return "redirect:/";
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
	
	private List<WorkflowHelper> getActiveWorkflowsByAuthenticatedUser() {
		List<Workflow> workflows = workflowService.getWorkflows();
		List<Workflow> activeWorkflows = new LinkedList<Workflow>();
		List<WorkflowHelper> workflowHelpers = new LinkedList<WorkflowHelper>();
		List<Workflow> activeWorkflowsToUser = new LinkedList<Workflow>();
		Optional<User> u;
		User user = new User();
		Boolean userAuthenticatedWithActiveWorkflow = false;

		String username = getAuthenticatedUserName();
		
		// build list of all active workflows
		for (Workflow workflow : workflows) {
			if (!(workflow.getStatus().equals("DONE"))) { // Not equal Done		
				activeWorkflows.add(workflow);
			}
		}
		
		// trim the active workflow list to only workflows tied to authenticated user
		for (Workflow workflow : activeWorkflows) {
			if (getEmailFromWorkflow(workflow, "primaryReader").equals(username) || // authenticated user equal primary reader
			    getEmailFromWorkflow(workflow, "secondaryReader").equals(username) || // or authenticated user equal secondary reader
			    getEmailFromWorkflow(workflow, "student").equals(username)) { // or authenticated user equal to student
					activeWorkflowsToUser.add(workflow);
					userAuthenticatedWithActiveWorkflow = true;
			}
		}
		
		// build list of active workflows tied to authenticated user
		if (userAuthenticatedWithActiveWorkflow == true) {
			for (Workflow workflow : activeWorkflowsToUser) { 
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
		
		// return list of all active workflows tied to authenticated user
		return workflowHelpers;
	}
	
	private String getEmailFromWorkflow(Workflow workflow, String userType) {
		String email = "";
		
		Optional<User> pr = userService.getUserById(workflow.getPrimaryReaderUid());
		User primaryReader = pr.get();
		
		Optional<User> s = userService.getUserById(workflow.getStudentUid());
		User student = s.get();
		
		Optional<User> sr = userService.getUserById(workflow.getSecondaryReaderUid());
		User secondaryReader = sr.get();
		
		switch (userType) {
			case "primaryReader":
				email = primaryReader.getEmail();
				break;
			case "student":
				email = student.getEmail();
				break;
			case "secondaryReader":
				email = secondaryReader.getEmail();
				break;
		} // end switch
		return email;
	} // end getEmailFromWorkflow
	
	private String getAuthenticatedUserName() {
		String username = "";
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
			username = authentication.getName();
		}
		return username;
	}
	

}