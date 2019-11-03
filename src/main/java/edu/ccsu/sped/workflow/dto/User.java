package edu.ccsu.sped.workflow.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="UserDTO")
public class User {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id", nullable= false)
	private Integer id;	
	
	@Column(name = "fname")
	private String fname; //first name
	
	@Column(name = "lname")
	private String lname; //last name
	
	@Column(name = "ccsuid")
	private Integer ccsuID;
	
	@Column(name = "role")
	private String role; 
	
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "status")
	private String status; //user status
	
	// Constructor
	public User() {}
	
	public User(Integer id, String fname, String lname, Integer ccsuID, String role, String email, String status) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.ccsuID = ccsuID;
		this.role = role;
		this.email = email;
		this.status = status;
	}

	// Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
