package com.wipro.employemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wipro.employemanagement.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	@Query("SELECT p FROM Project p JOIN p.employeeIds e WHERE e = :employeeId")
	List<Project> findProjectsByEmployeeId(@Param("employeeId") Long employeeId);

	@Query("SELECT DISTINCT p FROM Project p JOIN p.employeeIds e WHERE e IN :employeeIds")
	List<Project> findProjectsByEmployeeIds(@Param("employeeIds") List<Long> ids);
}