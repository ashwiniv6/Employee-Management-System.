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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "my_unique",columnNames = {"email"}) )
public class Employee   {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String userId;
	
	@NotEmpty(message = "please provide the firstname")
	@Size(min = 3,max = 10, message="first name should be minimum of 3 characters")
	private String firstName;
	
	@NotEmpty(message = "please provide the lastname")
	@Size(min = 3,max = 10, message="last name should be minimum of 3 characters")
	private String lastName;
	
	@NotNull
	private LocalDate dob;

	@NotNull
	@Email(message = "email should be a valid email")
	private String email;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dep_fnk", referencedColumnName = "departid")
	private  Department department; 
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_emp", referencedColumnName = "userId")
	private User  user; 
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	public Employee ()
	{
		
	}

	public Employee( String firstName, String lastName, LocalDate dob, String email,Department department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.department = department; 
	}
	
	
	public Employee(String userId, String firstName, String lastName, LocalDate dob, String email,Department department) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.department = department;  
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
