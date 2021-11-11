package com.ems.in.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "user_table")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotEmpty(message = "please provide UserId")
    private  String userId;
 
//    @NotEmpty(message="This Field is mandatory")
    private String roles;
    
	@Column(name="password")
    @NotEmpty(message = "please provide password")
//   @Size(min = 5,max = 15)
    private  String password;
    

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	@JsonIgnore
    private Employee employee;


    public User() {
    }

    public User(String userId,String password,String roles) {
        this.userId=userId;
        this.password=password;
       
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}


}
