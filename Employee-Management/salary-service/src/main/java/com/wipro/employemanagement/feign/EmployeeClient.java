package com.wipro.employemanagement.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.employemanagement.dto.EmployeeDTO;

@FeignClient(name = "employee-service")
public interface EmployeeClient {

	@GetMapping("/employees/department/{departmentId}")
    List<EmployeeDTO> getEmployeesByDepartment(@PathVariable Long departmentId);

    @GetMapping("/api/employees/{id}")
    EmployeeDTO getEmployeeById(@PathVariable("id") Long id);
}