package edu.ccsu.sped.workflow.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="WorkflowDTO")
public class Workflow {
	
	@Id
	@GeneratedValue 
	private Integer wid;
	
	@OneToOne
	private User student; 
	@OneToOne
	private User primaryreader; 
	@OneToOne
	private User secondaryreader; 
	private String status; //workflow status

	public Workflow() {}
	
	public Workflow(Integer wid, User student, User primaryreader, User secondaryreader, String status) {
		this.wid = wid;
		this.student = student;
		this.primaryreader = primaryreader;
		this.secondaryreader = secondaryreader;
		this.status = status;
	}

	public Integer getWid() {
		return wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public User getstudent() {
		return student;
	}

	public void setstudent(User student) {
		this.student = student;
	}

	public User getprimaryreader() {
		return primaryreader;
	}

	public void setprimaryreader(User primaryreader) {
		this.primaryreader = primaryreader;
	}

	public User getsecondaryreader() {
		return secondaryreader;
	}

	public void setsecondaryreader(User secondaryreader) {
		this.secondaryreader = secondaryreader;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
