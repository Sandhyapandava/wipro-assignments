package com.wipro.employemanagement.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.employemanagement.dto.SalaryDTO;

@FeignClient(name = "salary-service")
public interface SalaryServiceClient {
    @GetMapping("api/salaries/employee/{id}")
    SalaryDTO getSalaryById(@PathVariable Long id);
}