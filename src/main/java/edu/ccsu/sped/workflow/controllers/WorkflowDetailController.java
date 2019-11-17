package edu.ccsu.sped.workflow.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ccsu.sped.workflow.dto.QuestionResponse;
import edu.ccsu.sped.workflow.dto.QuestionResponseWrapper;
import edu.ccsu.sped.workflow.dto.QuestionsTemplate;
import edu.ccsu.sped.workflow.dto.User;
import edu.ccsu.sped.workflow.dto.UserCreationDto;
import edu.ccsu.sped.workflow.dto.Workflow;
import edu.ccsu.sped.workflow.dto.WorkflowComments;
import edu.ccsu.sped.workflow.services.QuestionResponseService;
import edu.ccsu.sped.workflow.services.QuestionsTemplateService;
import edu.ccsu.sped.workflow.services.UserService;
import edu.ccsu.sped.workflow.services.WorkflowCommentsService;
import edu.ccsu.sped.workflow.services.WorkflowService;

@Controller
@RequestMapping("/workflowdetail")

public class WorkflowDetailController {
	
	@Autowired
	private WorkflowService workflowService;
	
	@Autowired
	private QuestionsTemplateService questionsTemplateService;
	
	@Autowired
	private QuestionResponseService questionResponseService;
	
	@Autowired
	private WorkflowCommentsService workflowCommentsService;
	

	@GetMapping("")
	public String workflowDetails(@RequestParam(value = "wid")Integer wid,Model model) {
		Workflow activeWorkflow = workflowService.getWorkflowById(wid).get();
		List<QuestionResponse> questionResponses = new ArrayList<QuestionResponse>(activeWorkflow.getQuestionResponse());
		
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
		model.addAttribute("workflowComments",activeWorkflow.getWorkflowComments());
		model.addAttribute("activeWorkflow",activeWorkflow);
		return "workflowdetail";
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
	
*/
	@GetMapping(value = "/edit")
	public String showEditForm(@ModelAttribute("questionResponses") ArrayList<QuestionResponse> questionResponses,@ModelAttribute("workflowComments") WorkflowComments workflowComments,@ModelAttribute("activeWorkflow") Workflow activeWorkflow, Model model) {

		QuestionResponseWrapper formQuestionResponseWrapper = new QuestionResponseWrapper();
		if(questionResponses.isEmpty()) {
			List<QuestionsTemplate> questionTemplates = questionsTemplateService.getActiveQuestionsTemplates();
			for(QuestionsTemplate questionTemplate : questionTemplates) {
				formQuestionResponseWrapper.addQuestionResponse(new QuestionResponse(false, activeWorkflow, questionTemplate));
			}
		}
		else {
			formQuestionResponseWrapper = new QuestionResponseWrapper(questionResponses);
		}
		
		model.addAttribute("form", formQuestionResponseWrapper);
		
		return "editWorkflowDetailsForm";
	}
	
	@PostMapping(value = "/save")
	public String saveUsers(@ModelAttribute("form") QuestionResponseWrapper form,  Model model) {
		questionResponseService.saveAll(form.getQuestionResponses());
		
		//model.addAttribute("questionResponses", questionResponseService.getQuestionResponses());
		
		return "redirect:/";
	}
}