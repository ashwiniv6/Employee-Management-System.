package com.ems.in.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Department {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int departid;
	  @Column
	  @NotEmpty(message="departmentname is required")
      private String departname;
	  
	 @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "department")
	 @JsonIgnore
	 private StatusReport statusreport;
	 
	 
	 @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "Compliance_department")
	 @JsonIgnore
	 private Compliance compliance;
	 
	 
	 @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "department")
	 @JsonIgnore
	 private Employee employee;
	 
	 
   public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	 

	public Department()
      {
    	  
      }
      
	  public Department ( String departname) 
      {
    	  this.setDepartname(departname);
      }
	  
      public Department (int departid, String departname) 
      {
    	  this.setDepartid(departid);
    	  this.setDepartname(departname);
      }

	public int getDepartid() {
		return departid;
	}

	public void setDepartid(int departid) {
		this.departid = departid;
	}

	public String getDepartname() {
		return departname;
	}

	public void setDepartname(String departname) {
		this.departname = departname;
	}

//	public Department get() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public StatusReport getStatusreport() {
		return statusreport;
	}

	public void setStatusreport(StatusReport statusreport) {
		this.statusreport = statusreport;
	}
	
    public Compliance getCompliance() {
		return compliance;
	}

	public void setCompliance(Compliance compliance) {
		this.compliance = compliance;
	}
      
}
