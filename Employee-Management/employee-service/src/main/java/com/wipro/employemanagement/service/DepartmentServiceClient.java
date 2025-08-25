package com.wipro.employemanagement.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.employemanagement.dto.Department;

@FeignClient(name = "department-service")
public interface DepartmentServiceClient {
    @GetMapping("api/departments/{id}")
    Department getDepartmentById(@PathVariable Long id);
}