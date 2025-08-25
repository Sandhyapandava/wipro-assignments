package com.wipro.employemanagement.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wipro.employemanagement.dto.EmployeeDTO;
import com.wipro.employemanagement.dto.ProjectDTO;
import com.wipro.employemanagement.entity.Department;
import com.wipro.employemanagement.exception.DepartmentNotFoundException;
import com.wipro.employemanagement.feign.EmployeeClient;
import com.wipro.employemanagement.feign.ProjectClient;
import com.wipro.employemanagement.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentRepository departmentRepository;
	private final EmployeeClient employeeClient;
	private final ProjectClient projectClient;

	public DepartmentServiceImpl(DepartmentRepository departmentRepository, EmployeeClient employeeClient,
			ProjectClient projectClient) {
		this.departmentRepository = departmentRepository;
		this.employeeClient = employeeClient;
		this.projectClient = projectClient;
	}

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentById(Long id) {
		Optional<Department> department = departmentRepository.findById(id);
		if (department.isPresent()) {
			return department.get();
		}
		throw new DepartmentNotFoundException("Department not found with id: " + id);
	}

	@Override
	public Department updateDepartment(Long id, Department updatedDepartment) {
		Department existingDepartment = getDepartmentById(id);
		existingDepartment.setName(updatedDepartment.getName());
		existingDepartment.setLocation(updatedDepartment.getLocation());
		return departmentRepository.save(existingDepartment);
	}

	@Override
	public void deleteDepartment(Long id) {
		Department existingDepartment = getDepartmentById(id);
		departmentRepository.delete(existingDepartment);
	}

	@Override
	public List<EmployeeDTO> getEmployeeByDept(Long id) {
		ResponseEntity<List<EmployeeDTO>> employeesByDepartment = employeeClient.getEmployeesByDepartment(id);
		return employeesByDepartment.getBody();
	}

	public List<ProjectDTO> getAllProjectsUnderADepartment(Long departmentId) {
		// 1. Get employees for the department
		ResponseEntity<List<EmployeeDTO>> employeesByDepartment = employeeClient.getEmployeesByDepartment(departmentId);
		List<EmployeeDTO> list = employeesByDepartment.getBody();
		if (list.isEmpty()) {
			return Collections.emptyList();
		}

		List<Long> employeeIds = list.stream().map(EmployeeDTO::getId).toList();
		System.out.println(list);
		List<ProjectDTO> projects = projectClient.getProjectsByEmployeeIds(employeeIds);
		System.out.println(projects);
		return projects.stream().collect(Collectors.toMap(ProjectDTO::getId, p -> p, (p1, p2) -> p1)).values().stream()
				.toList();
	}
}
