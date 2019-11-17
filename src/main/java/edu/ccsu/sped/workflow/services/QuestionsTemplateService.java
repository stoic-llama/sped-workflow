package edu.ccsu.sped.workflow.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ccsu.sped.workflow.dto.QuestionsTemplate;
import edu.ccsu.sped.workflow.repos.QuestionsTemplateRepository;

@Service
public class QuestionsTemplateService {

	@Autowired
	private QuestionsTemplateRepository questionsTemplateRepository;
	
	// GET all 
		public List<QuestionsTemplate> getQuestionsTemplates() {
			return (List<QuestionsTemplate>) questionsTemplateRepository.findAll();
		}
		
	// GET all Active
		public List<QuestionsTemplate> getActiveQuestionsTemplates() {
			
			List<QuestionsTemplate> allQuestionsTemplates = new ArrayList<QuestionsTemplate>((Collection<? extends QuestionsTemplate>) questionsTemplateRepository.findAll());
			allQuestionsTemplates.removeIf(q -> q.getTemplateActive()==false);
			
			return allQuestionsTemplates;
		}
	
	// GET single instance
	public Optional<QuestionsTemplate> getQuestionTemplateById(Integer Id) {
		return questionsTemplateRepository.findById(Id);
	}
	
	// POST new instance
	public void addQuestionsTemplate(QuestionsTemplate questionsTemplate) {
		questionsTemplateRepository.save(questionsTemplate);
	}
	
	// PUT single existing instance to update
	public void updateQuestionsTemplate(QuestionsTemplate questionsTemplate) {
		questionsTemplateRepository.save(questionsTemplate);
	}
	
	// DELETE single instance
	public void deleteQuestionsTemplateById(Integer Id) {
		questionsTemplateRepository.deleteById(Id);
	}
	
	public void saveAll(List<QuestionsTemplate> questionsTemplates) {
		
		for(QuestionsTemplate questionsTemplate : questionsTemplates) {
			questionsTemplateRepository.save(questionsTemplate);
		}
	}
	
	
}
