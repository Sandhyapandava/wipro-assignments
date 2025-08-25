package com.wipro.employemanagement.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.employemanagement.dto.ProjectDTO;

@FeignClient(name = "project-service")
public interface ProjectClient {
    @GetMapping("/projects/by-employee-ids")
    List<ProjectDTO> getProjectsByEmployeeIds(@RequestParam List<Long> employeeIds);
}
