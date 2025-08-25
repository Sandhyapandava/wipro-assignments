package com.wipro.employemanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.employemanagement.entity.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
    Optional<Salary> findByEmployeeId(Long employeeId);
    List<Salary> findByEmployeeIdIn(List<Long> employeeIds);
}