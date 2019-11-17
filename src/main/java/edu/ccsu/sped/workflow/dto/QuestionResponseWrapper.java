package edu.ccsu.sped.workflow.dto;

import java.util.ArrayList;
import java.util.List;

public class QuestionResponseWrapper {
	
	private List<QuestionResponse> questionResponses;
	
	public QuestionResponseWrapper() {
		this.questionResponses = new ArrayList<>();
	}
	
	public QuestionResponseWrapper(List<QuestionResponse> questionResponses) {
		this.questionResponses = questionResponses;
	}
	
	public List<QuestionResponse> getQuestionResponses() {
		return questionResponses;
	}
	
	public void setQuestionResponses(List<QuestionResponse> questionResponses) {
		this.questionResponses = questionResponses;
	}
	
	public void addQuestionResponse (QuestionResponse questionResponse) {
		this.questionResponses.add(questionResponse);
	}
}