package edu.ccsu.sped.workflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ccsu.sped.workflow.dto.QuestionResponse;
import edu.ccsu.sped.workflow.repos.QuestionResponseRepository;

@Service
public class QuestionResponseService {

	@Autowired
	private QuestionResponseRepository questionResponseRepository;
	
	// GET all 
		public List<QuestionResponse> getQuestionResponses() {
			return (List<QuestionResponse>) questionResponseRepository.findAll();
		}
	
	// GET single instance
	public Optional<QuestionResponse> getQuestionResponseById(Integer Id) {
		return questionResponseRepository.findById(Id);
	}
	
	// POST new instance
	public void addQuestionResponse(QuestionResponse questionResponse) {
		questionResponseRepository.save(questionResponse);
	}
	
	// PUT single existing instance to update
	public void updateQuestionResponse(QuestionResponse questionResponse) {
		questionResponseRepository.save(questionResponse);
	}
	
	// DELETE single instance
	public void deleteQuestionResponseById(Integer Id) {
		questionResponseRepository.deleteById(Id);
	}
	
	public void saveAll(List<QuestionResponse> questionResponses) {
		
		for(QuestionResponse questionResponse : questionResponses) {
			questionResponseRepository.save(questionResponse);
		}
	}
	
	
}