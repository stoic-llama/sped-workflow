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
@Table(name="WorkflowComments")
public class WorkflowComments {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "wcid", nullable= false)
	private Integer wcid;
	
	@Column(name = "comments")
	private String comments;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_workflow")
	@JsonBackReference
	private Workflow workflow; 

	// Constructor
	public WorkflowComments() {}
	
	public WorkflowComments(Integer wcid, String comments) {
		this.wcid = wcid;
		this.comments = comments;
	}

	public WorkflowComments(Integer wcid, String comments, Workflow workflow) {
		this.wcid = wcid;
		this.comments = comments;
		this.workflow = workflow;
	}
	
	public Integer getWcid() {
		return wcid;
	}

	public void setWcid(Integer wcid) {
		this.wcid = wcid;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Workflow getWorkflow() {
		return workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}
	
}
