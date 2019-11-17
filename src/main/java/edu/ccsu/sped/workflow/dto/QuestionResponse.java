package edu.ccsu.sped.workflow.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="QuestionResponses")
public class QuestionResponse {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "qrid", nullable= false)
	private Integer qrid;
	
	@Column(name = "response")
	private Boolean response; //Yes or no on grade
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "wid")
	@JsonBackReference
	private Workflow workflow; 
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "questionsTemplate_qtid")
	@JsonBackReference
	private QuestionsTemplate questionsTemplate; // one question response mapped to one question template

	
	// Constructor
	public QuestionResponse() {}
	
	public QuestionResponse(Integer qrid, Boolean response) {
		this.qrid = qrid;
		this.response = response;
	}

	public QuestionResponse(Integer qrid, Boolean response, Workflow workflow) {
		this.qrid = qrid;
		this.response = response;
		this.workflow = workflow;
	}
	
	public QuestionResponse(Boolean response, Workflow workflow, QuestionsTemplate questionsTemplate) {
		this.response = response;
		this.workflow = workflow;
		this.questionsTemplate = questionsTemplate;
	}
	
	public Integer getQrid() {
		return qrid;
	}

	public void setQrid(Integer qrid) {
		this.qrid = qrid;
	}

	public Boolean getResponse() {
		return response;
	}

	public void setResponse(Boolean response) {
		this.response = response;
	}

	public Workflow getWorkflow() {
		return workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}
	
	public QuestionsTemplate getQuestionsTemplate() {
		return questionsTemplate;
	}
	
	public void setQuestionsTemplate(QuestionsTemplate questionsTemplate) {
		this.questionsTemplate = questionsTemplate;
	}
	
}
