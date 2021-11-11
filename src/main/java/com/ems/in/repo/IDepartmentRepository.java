package com.ems.in.repo;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.in.entity.Department;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department,Integer>{

	Optional<Department> findById(Integer departid);

	
	@SuppressWarnings("unchecked")
	Department save(Department department);

	List<Department> findAll();

	void deleteById(Integer departid);
	


	
}
