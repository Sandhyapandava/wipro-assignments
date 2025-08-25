package com.wipro.employemanagement.service;

import java.util.List;

import com.wipro.employemanagement.dto.EmployeeDTO;
import com.wipro.employemanagement.dto.ProjectDTO;
import com.wipro.employemanagement.entity.Department;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    Department updateDepartment(Long id, Department department);
    void deleteDepartment(Long id);
	List<EmployeeDTO> getEmployeeByDept(Long id);
	List<ProjectDTO> getAllProjectsUnderADepartment(Long departmentId);
}
