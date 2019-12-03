package edu.ccsu.sped.workflow.dto;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="WorkflowDTO")
public class Workflow {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer wid;
	private String status = "INITIATED"; // initial workflow status
	private Integer primaryReaderUid;
	private Integer secondaryReaderUid;
	private Integer studentUid;
	private String portfolioURL;
	
	
	@ManyToMany
	@JsonManagedReference
	private List<User> user = new LinkedList<User>(); // one workflow mapped to three users (student, primaryreader, secondaryreader)
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="workflow")
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<QuestionResponse> questionResponse = new LinkedList<QuestionResponse>(); // one workflow mapped to multiple question responses
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="workflow")
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonManagedReference
	private List<WorkflowComments> workflowComments = new LinkedList<WorkflowComments>(); // one workflow mapped to multiple comments

	// Constructors
	public Workflow() {}
	
	// Getters and Setters
	public Integer getWid() {
		return wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPrimaryReaderUid() {
		return primaryReaderUid;
	}

	public void setPrimaryReaderUid(Integer primaryReaderUid) {
		this.primaryReaderUid = primaryReaderUid;
	}

	public Integer getSecondaryReaderUid() {
		return secondaryReaderUid;
	}

	public void setSecondaryReaderUid(Integer secondaryReaderUid) {
		this.secondaryReaderUid = secondaryReaderUid;
	}

	public Integer getStudentUid() {
		return studentUid;
	}

	public void setStudentUid(Integer studentUid) {
		this.studentUid = studentUid;
	}

	public String getPortfolioURL() {
		return portfolioURL;
	}

	public void setPortfolioURL(String portfolioURL) {
		this.portfolioURL = portfolioURL;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}
	
	public List<QuestionResponse> getQuestionResponse() {
		return questionResponse;
	}
	
	public void setQuestionResponse(List<QuestionResponse> questionResponse) {
		this.questionResponse = questionResponse;
	}
	
	public List<WorkflowComments> getWorkflowComments() {
		return workflowComments;
	}
	
	public void setWorkflowComments(List<WorkflowComments> workflowComments) {
		this.workflowComments = workflowComments;
	}
	
}
