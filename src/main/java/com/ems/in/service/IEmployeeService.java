package com.ems.in.service;

import java.util.List;

import com.ems.in.entity.Employee;
public interface IEmployeeService {
	
	public Employee addEmployee(Employee employee);
	
	public void deleteEmployee(String userId);
	
	public Employee updateEmployee(Employee employee);	
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(String userId);

	public Integer getAllEmployeeCount();
		
//	public List<Employee> getAllEmployeesByPagination(String maxPage, String ofset);
	


}
