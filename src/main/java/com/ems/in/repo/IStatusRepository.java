package com.ems.in.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ems.in.entity.StatusReport;

@Repository
public interface IStatusRepository extends JpaRepository<StatusReport, Integer>
{

	Optional<StatusReport> findByuserId(String userId);

}
