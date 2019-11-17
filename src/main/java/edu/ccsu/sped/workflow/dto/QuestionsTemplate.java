package edu.ccsu.sped.workflow.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="QuestionsTemplate")
public class QuestionsTemplate {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "qtid", nullable= false)
	private Integer qtid;
	
	@Column(name = "display")
	private String display; //Question to display
	
	@Column(name = "templateId")
	private int templateId; //version of template each question is active on
	
	@Column(name = "templateActive")
	private boolean templateActive; //Whether or not the template for the question is the active one
	
	@OneToMany(mappedBy="questionsTemplate") // mapped by questionsTemplate attribute in QuestionResponse object
	@JsonBackReference
	private List<QuestionResponse> questionResponse; 
	
	// Constructor
	public QuestionsTemplate() {}
	
	public QuestionsTemplate(Integer qtid, String display, Integer templateId, boolean templateActive) {
		this.qtid = qtid;
		this.display = display;
		this.templateId = templateId;
		this.templateActive = templateActive;
	}

	public Integer getQtid() {
		return qtid;
	}

	public void setQtid(Integer qtid) {
		this.qtid = qtid;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}
	
	public Integer getTemplateId() {
		return templateId;
	}

	public Boolean getTemplateActive() {
		return templateActive;
	}

	public void setTemplateActive(Boolean templateActive) {
		this.templateActive = templateActive;
	}
	
	public List<QuestionResponse> getQuestionResponse() {
		return questionResponse;
	}

	public void setQuestionResponse(List<QuestionResponse> questionResponse) {
		this.questionResponse = questionResponse;
	}

}
