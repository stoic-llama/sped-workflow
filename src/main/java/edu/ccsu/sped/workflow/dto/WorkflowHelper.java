package edu.ccsu.sped.workflow.dto;

public class WorkflowHelper {
	private Integer wid;
	private String primaryReaderFName;
	private String primaryReaderLName;
	private String studentFName;
	private String studentLName;
	private String secondaryReaderFName;
	private String secondaryReaderLName;
	private String workflowStatus;
	
	// Constructor
	public WorkflowHelper() {}
	
	public WorkflowHelper(Integer wid, String primaryReaderFName, String primaryReaderLName, String studentFName,
			String studentLName, String secondaryReaderFName, String secondaryReaderLName, String workflowStatus) {
		this.wid = wid;
		this.primaryReaderFName = primaryReaderFName;
		this.primaryReaderLName = primaryReaderLName;
		this.studentFName = studentFName;
		this.studentLName = studentLName;
		this.secondaryReaderFName = secondaryReaderFName;
		this.secondaryReaderLName = secondaryReaderLName;
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
	
	
	
	
}
