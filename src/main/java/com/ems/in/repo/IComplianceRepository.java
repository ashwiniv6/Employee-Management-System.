package com.ems.in.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.in.entity.Compliance;

@Repository
public interface IComplianceRepository extends JpaRepository<Compliance, Integer> 
{
	

}
