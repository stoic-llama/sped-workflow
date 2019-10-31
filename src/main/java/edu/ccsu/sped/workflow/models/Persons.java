package edu.ccsu.sped.workflow.models;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Persons {
	
	// Attributes
	@Id
	private Integer uid;	
	private String fname; //first name
	private String lname; //last name
	private Integer ccsuID;
	private String role; 
	private String email;
	private String status; //user status
	
	// Constructor
	public Persons() {}
	
	public Persons(Integer uid, String fname, String lname, Integer ccsuID, String role, String email, String status) {
		this.uid = uid;
		this.fname = fname;
		this.lname = lname;
		this.ccsuID = ccsuID;
		this.role = role;
		this.email = email;
		this.status = status;
	}

	// Getters and Setters
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
}
