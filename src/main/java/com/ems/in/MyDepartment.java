package com.ems.in;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ems.in.entity.Department;
import com.ems.in.repo.IDepartmentRepository;


@Component
public class MyDepartment implements CommandLineRunner{

	
		
		@Autowired
		IDepartmentRepository departmentRepository;
		
		@Override
		public void run(String... args) throws Exception {
			Department department1=new Department(1," Human Resource");
			Department department2=new Department(2,"Marketing");
			Department department3=new Department(3,"Finance");
			Department department4=new Department(4,"Operations management");
			Department department5=new Department(5,"Developers");
			Department department6=new Department(6,"TESTER");
			
			
			
			List<Department> allDepartments=Stream.of(department1,department2,department3,department4,department5,department6)
					.collect(Collectors.toList());
			departmentRepository.saveAll(allDepartments);

	}
		

}
