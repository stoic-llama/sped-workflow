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
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.ccsu.sped.workflow.dto.QuestionResponse;
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
@SessionAttributes("activeWorkflow")
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
	
	//The details landing page
	@GetMapping("")
	//public String workflowDetails(@ModelAttribute ("activeWorkflow") Workflow activeWorkflow,Model model) {
	public String workflowDetails(@RequestParam(value = "wid")Integer wid, Model model) {
		
		Workflow activeWorkflow = workflowService.getWorkflowById(wid).get();
		model.addAttribute("activeWorkflow", activeWorkflow);
		
		//Get responses that are currently associated with activeWorkflow
		List<QuestionResponse> questionResponses = new ArrayList<QuestionResponse>(activeWorkflow.getQuestionResponse());
		
		//If there are no responses associated with activeWorkflow get the questions from the question template that are active
		if(questionResponses.isEmpty()) {
			model.addAttribute("templateQuestions",questionsTemplateService.getActiveQuestionsTemplates());
		}
		
		//If there are responses, then get the template question associated with each for display(template questions may not be active anymore)
		else {

			List<QuestionsTemplate> questionTemplates = new ArrayList<QuestionsTemplate>();
			for(QuestionResponse questionResponse : questionResponses) {
				questionTemplates.add(questionResponse.getQuestionsTemplate());
			}
				
			model.addAttribute("templateQuestions",questionTemplates);

		}
		
		
		if(activeWorkflow.getWorkflowComments().isEmpty()) {
			WorkflowComments tempComment = new WorkflowComments("",activeWorkflow);
			activeWorkflow.getWorkflowComments().add(tempComment);
		}
		
		model.addAttribute("questionResponses",questionResponses);
		
		return "workflowdetail";
	}

	
	@GetMapping(value = "/edit")
	public String showEditForm(@ModelAttribute("activeWorkflow") Workflow activeWorkflow, Model model) {

		if(activeWorkflow.getQuestionResponse().isEmpty()) {
			List<QuestionsTemplate> questionTemplates = questionsTemplateService.getActiveQuestionsTemplates();
			for(QuestionsTemplate questionTemplate : questionTemplates) {
				QuestionResponse currentQuestionResponse = new QuestionResponse(false, activeWorkflow, questionTemplate);
				activeWorkflow.getQuestionResponse().add(currentQuestionResponse);
			}
			
			//Add these back in if removing the second if statement from above method
			//WorkflowComments tempComment = new WorkflowComments("",activeWorkflow);
			//activeWorkflow.getWorkflowComments().add(tempComment);
			
		}
		else {

		}
		
		return "editWorkflowDetailsForm";
	}
	
	
	
	@PostMapping(value = "/save")
	public String saveQuestionResponses(@ModelAttribute("activeWorkflow") Workflow activeWorkflow, Model model) {

		workflowService.updateWorkflow(activeWorkflow);
		
		return "redirect:/";
	}
	
}