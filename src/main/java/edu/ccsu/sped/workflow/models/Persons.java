package edu.ccsu.sped.workflow.models;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Persons {
	
	// Attributes
	@Id
	private Integer id;
	private String fname; // first name
	private String mi; // middle initial
	private String lname; // last name
	private String ccsuId;
	private String type; // reader, coordinator, instructor, student
	
	// Constructors
	public Persons() {
		
	};
	
	public Persons(Integer id, String fname, String mi, String lname, String ccsuId, String type) {
		this.id = id;
		this.fname = fname;
		this.mi = mi;
		this.lname = lname;
		this.ccsuId = ccsuId;
		this.type = type;
	}


	
	// Getting and Setters
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

	public String getMi() {
		return mi;
	}

	public void setMi(String mi) {
		this.mi = mi;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getCcsuId() {
		return ccsuId;
	}

	public void setCcsuId(String ccsuId) {
		this.ccsuId = ccsuId;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
