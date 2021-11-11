package com.ems.in.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class StatusReport 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int statusId;
	@Column
	
	@NotEmpty(message = "please provide the comments")
	private String comments;
	
	@NotEmpty(message = "please provide the details")
	private String details;

	@NotNull
	private LocalDate createDate;

	private  String userId;

	private int complianceId;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "status_department",referencedColumnName = "departid")
	private Department department;
	
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "statusreport")
    @JsonIgnore
	private Compliance compliance;
	
	
	public Compliance getCompliance() {
		return compliance;
	}


	public void setCompliance(Compliance compliance) {
		this.compliance = compliance;
	}


	public StatusReport()
	{
		
	}
	

	public StatusReport( int statusId,String comments, String details, LocalDate createDate, String userId,
			int complianceId, Department department) 
	{
		super();
		this.statusId = statusId; 
		this.comments = comments;
		this.details = details;
		this.createDate = createDate;
		this.userId = userId;
		this.complianceId = complianceId;
		this.department = department;
	}
	
	public StatusReport( String comments, String details, LocalDate createDate, String userId,
			int complianceId, Department department) 
	{
		super();
		this.comments = comments;
		this.details = details;
		this.createDate = createDate;
		this.userId = userId;
		this.complianceId = complianceId;
		this.department = department;
	}



	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getComplianceId() {
		return complianceId;
	}
	public void setComplianceId(int complianceId) {
		this.complianceId = complianceId;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	

}
