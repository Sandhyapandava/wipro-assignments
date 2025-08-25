package com.wipro.employemanagement.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.employemanagement.dto.EmployeeDTO;

@FeignClient(name = "EMPLOYEE-SERVICE")
public interface EmployeeServiceClient {
    
    @GetMapping("/employees/{id}")
    EmployeeDTO getEmployeeById(@PathVariable("id") Long id);
    
    @GetMapping("/employees/batch")
    List<EmployeeDTO> getEmployeesByIds(@RequestParam("ids") List<Long> ids);
}