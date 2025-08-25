package com.wipro.employemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.employemanagement.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
