package com.ems.in.serviceImpl;

import java.util.List;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ems.in.entity.Employee;
import com.ems.in.exception.UserNotFoundException;
import com.ems.in.repo.EmployeeRepository;
import com.ems.in.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) 
	{
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(String userId) 
	{
		employeeRepository.deleteByUserId(userId);
	}
	
	@Override
	public Employee updateEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees()
	{
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(String userId) 
	{
	
		 Optional<Employee> opt = employeeRepository.findByuserId(userId); 
		 if(opt.isPresent())
		 {
			 return opt.get();
		 }
		 else
		 {
			 throw new UserNotFoundException("User with given id "+userId+" Not available");
			 
		 }
		 
	}
/*	@Override
	public List<Employee> getAllEmployeesByPagination(String maxPage, String ofset) 
	{
		List<Employee> employeesbypagination = employeeRepository.getAllEmployeesByPagination(maxPage, ofset);
		return  employeesbypagination ;
	} */

	//real
		@Override
		public Integer getAllEmployeeCount() 
		{
			return employeeRepository.getNumberOfEmployees();
		}
	
}
