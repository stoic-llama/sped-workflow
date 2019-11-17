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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ccsu.sped.workflow.dto.QuestionResponse;
import edu.ccsu.sped.workflow.dto.QuestionsTemplate;
import edu.ccsu.sped.workflow.dto.User;
import edu.ccsu.sped.workflow.dto.UserCreationDto;
import edu.ccsu.sped.workflow.dto.Workflow;
import edu.ccsu.sped.workflow.services.QuestionResponseService;
import edu.ccsu.sped.workflow.services.QuestionsTemplateService;
import edu.ccsu.sped.workflow.services.UserService;
import edu.ccsu.sped.workflow.services.WorkflowCommentsService;
import edu.ccsu.sped.workflow.services.WorkflowService;

@Controller
@RequestMapping(value = "/workflowdetail")

public class WorkflowDetailController {
	
	@Autowired
	private WorkflowService workflowService;
	
	@Autowired
	private QuestionsTemplateService questionsTemplateService;
	
	@Autowired
	private QuestionResponseService questionResponseService;
	
	@Autowired
	private WorkflowCommentsService workflowCommentsService;
	

	@GetMapping("{id}")
	public String workflowDetail(@PathVariable(value = "id")Integer wid, @RequestBody Workflow workflow,Model model) {
		List<QuestionResponse> questionResponses = new ArrayList<QuestionResponse>(workflow.getQuestionResponse());
		
		if(questionResponses.isEmpty()) {
			model.addAttribute("templateQuestions",questionsTemplateService.getActiveQuestionsTemplates());
		}
		else {
			model.addAttribute("questionResponses",questionResponses);
			List<QuestionsTemplate> questionTemplates = new ArrayList<QuestionsTemplate>();
			for(QuestionResponse questionResponse : questionResponses) {
				questionTemplates.add(questionResponse.getQuestionsTemplate());
			}
				
			model.addAttribute("templateQuestions",questionTemplates);
		}
			
		model.addAttribute("questionResponses",questionResponses);
		model.addAttribute("workflowComments",workflow.getWorkflowComments());
		return "workflowDetail";
	}
/*
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
*/
}