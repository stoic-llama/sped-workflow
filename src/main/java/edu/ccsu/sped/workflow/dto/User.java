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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Users")
public class User {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "uid", nullable= false)
	private Integer uid;
	
	@Column(name = "fname")
	private String fname; //first name
	
	@Column(name = "lname")
	private String lname; //last name
	
	@Column(name = "ccsuid")
	private Integer ccsuID;
	
	@Column(name = "role")
	private String role; 
	
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "status")
	private String status; //user status
	
	@ManyToMany(mappedBy="user") // mapped by user attribute in Workflow object, so avoid duplicate third table map uid to wid
	@JsonBackReference
	private List<Workflow> workflow; 
	
	// Constructor
	public User() {}
	
	public User(Integer uid, String fname, String lname, Integer ccsuID, String role, String email, String status) {
		this.uid = uid;
		this.fname = fname;
		this.lname = lname;
		this.ccsuID = ccsuID;
		this.role = role;
		this.email = email;
		this.status = status;
	}


	public User(Integer uid, String fname, String lname, Integer ccsuID, String role, String email, String status,
			List<Workflow> workflow) {
		this.uid = uid;
		this.fname = fname;
		this.lname = lname;
		this.ccsuID = ccsuID;
		this.role = role;
		this.email = email;
		this.status = status;
		this.workflow = workflow;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public void setCcsuID(Integer ccsuID) {
		this.ccsuID = ccsuID;
	}
	
	public Integer getCcsuID() {
		return ccsuID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Workflow> getWorkflow() {
		return workflow;
	}

	public void setWorkflow(List<Workflow> workflow) {
		this.workflow = workflow;
	}
	
}
