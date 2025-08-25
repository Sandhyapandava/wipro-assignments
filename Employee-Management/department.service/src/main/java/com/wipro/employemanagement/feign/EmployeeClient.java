package com.wipro.employemanagement.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.employemanagement.dto.EmployeeDTO;

@FeignClient(name = "employee-service")
public interface EmployeeClient {
	 @GetMapping("/employees/department/{departmentId}")
	    public ResponseEntity<List<EmployeeDTO>> getEmployeesByDepartment(@PathVariable Long departmentId);
}
