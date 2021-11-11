package com.ems.in.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Compliance")
public class Compliance 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int compliancedId;
	
	@NotEmpty(message = "Please provide rlType")
	private String rlType;
	
	@NotEmpty(message = "please provide the details")
	private String details;
	
	@NotNull
	private LocalDate createDate;

    @NotNull(message = "Please provide employee count")
	private int empCount;
	
    @NotNull(message = "Please provide  status count")
	private int stsCount;
	
	private String status;
	
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "compliance_department",referencedColumnName = "departid")
	private Department Compliance_department;
	
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "Compliance_Status",referencedColumnName = "statusId")
	@JsonIgnore
	private StatusReport statusreport;
	
	
	public Compliance()
	{
		
	}
	
	public Compliance( String rlType, String details, LocalDate createDate, Department department,
			int empCount, int stsCount, String status)
	{
		super();
		this.rlType = rlType;
		this.details = details;
		this.createDate = createDate;
		this.Compliance_department = department;
		this.empCount = empCount;
		this.stsCount = stsCount;
		this.status = status;
	}
	
	
	public Compliance(int compliancedId, String rlType, String details, LocalDate createDate, Department department,
			int empCount, int stsCount, String status)
	{
		super();
		this.compliancedId = compliancedId;
		this.rlType = rlType;
		this.details = details;
		this.createDate = createDate;
		this.Compliance_department = department;
		this.empCount = empCount;
		this.stsCount = stsCount;
		this.status = status;
	}



	public int getCompliancedId() {
		return compliancedId;
	}
	public void setCompliancedId(int compliancedId) {
		this.compliancedId = compliancedId;
	}
	public String getRlType() {
		return rlType;
	}
	public void setRlType(String rlType) {
		this.rlType = rlType;
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
	public int getEmpCount() {
		return empCount;
	}
	public void setEmpCount(int empCount) {
		this.empCount = empCount;
	}
	public int getStsCount() {
		return stsCount;
	}
	public void setStsCount(int stsCount) {
		this.stsCount = stsCount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

	public StatusReport getStatusreport() {
		return statusreport;
	}

	public void setStatusreport(StatusReport statusreport) {
		this.statusreport = statusreport;
	}


	public Department getCompliance_department() {
		return Compliance_department;
	}


	public void setCompliance_department(Department compliance_department) {
		Compliance_department = compliance_department;
	}
	

}
