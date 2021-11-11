package com.ems.in.repo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ems.in.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	@Query(value = "select count(*) from employee",nativeQuery = true)
	public int getNumberOfEmployees();

	public Optional<Employee> findByuserId(String userId);
	
	@Modifying
	@Transactional
	public void deleteByUserId (String userId);
	
	
}
