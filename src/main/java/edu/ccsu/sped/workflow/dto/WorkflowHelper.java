package edu.ccsu.sped.workflow.dto;

public class WorkflowHelper {
	private Integer wid;
	private String primaryReaderFName;
	private String primaryReaderLName;
	private String primaryReaderFullName;
	private String studentFName;
	private String studentLName;
	private String studentFullName;
	private String secondaryReaderFName;
	private String secondaryReaderLName;
	private String secondaryReaderFullName;
	private String workflowStatus;
	
	// Constructor
	public WorkflowHelper() {}
	
	public WorkflowHelper(Integer wid, String primaryReaderFName, String primaryReaderLName, String studentFName,
			String studentLName, String secondaryReaderFName, String secondaryReaderLName, String workflowStatus) {
		this.wid = wid;
		this.primaryReaderFName = primaryReaderFName;
		this.primaryReaderLName = primaryReaderLName;
		this.primaryReaderFullName = primaryReaderFName + " " + primaryReaderLName;
		this.studentFName = studentFName;
		this.studentLName = studentLName;
		this.studentFullName = studentFName + " " + studentLName;
		this.secondaryReaderFName = secondaryReaderFName;
		this.secondaryReaderLName = secondaryReaderLName;
		this.secondaryReaderFullName = secondaryReaderFName + " " + secondaryReaderLName;
		this.workflowStatus = workflowStatus;
	}

	
	// Getters and Setters
	public Integer getWid() {
		return wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public String getPrimaryReaderFName() {
		return primaryReaderFName;
	}

	public void setPrimaryReaderFName(String primaryReaderFName) {
		this.primaryReaderFName = primaryReaderFName;
	}

	public String getPrimaryReaderLName() {
		return primaryReaderLName;
	}

	public void setPrimaryReaderLName(String primaryReaderLName) {
		this.primaryReaderLName = primaryReaderLName;
	}

	public String getStudentFName() {
		return studentFName;
	}

	public void setStudentFName(String studentFName) {
		this.studentFName = studentFName;
	}

	public String getStudentLName() {
		return studentLName;
	}

	public void setStudentLName(String studentLName) {
		this.studentLName = studentLName;
	}

	public String getSecondaryReaderFName() {
		return secondaryReaderFName;
	}

	public void setSecondaryReaderFName(String secondaryReaderFName) {
		this.secondaryReaderFName = secondaryReaderFName;
	}

	public String getSecondaryReaderLName() {
		return secondaryReaderLName;
	}

	public void setSecondaryReaderLName(String secondaryReaderLName) {
		this.secondaryReaderLName = secondaryReaderLName;
	}

	public String getWorkflowStatus() {
		return workflowStatus;
	}

	public void setWorkflowStatus(String workflowStatus) {
		this.workflowStatus = workflowStatus;
	}

	public String getPrimaryReaderFullName() {
		return primaryReaderFullName;
	}

	public void setPrimaryReaderFullName(String primaryReaderFullName) {
		this.primaryReaderFullName = primaryReaderFullName;
	}

	public String getStudentFullName() {
		return studentFullName;
	}

	public void setStudentFullName(String studentFullName) {
		this.studentFullName = studentFullName;
	}

	public String getSecondaryReaderFullName() {
		return secondaryReaderFullName;
	}

	public void setSecondaryReaderFullName(String secondaryReaderFullName) {
		this.secondaryReaderFullName = secondaryReaderFullName;
	}
	
}
