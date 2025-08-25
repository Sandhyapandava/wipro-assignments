package com.wipro.employemanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.employemanagement.dto.Department;
import com.wipro.employemanagement.dto.EmployeeDTO;
import com.wipro.employemanagement.dto.SalaryDTO;
import com.wipro.employemanagement.entity.Employee;
import com.wipro.employemanagement.exception.EmployeeNotFoundException;
import com.wipro.employemanagement.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentServiceClient departmentServiceClient;

	@Autowired
	private SalaryServiceClient salaryServiceClient;

	public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		employee.setName(employeeDTO.getName());
		employee.setDepartmentId(employeeDTO.getDepartment().getId());
		employee.setAddress(employeeDTO.getAddress());
		employee.setMobileNumber(employeeDTO.getMobileNumber());
		employee.setSalaryId(employeeDTO.getSalaryDTO().getId());

		Employee savedEmployee = employeeRepository.save(employee);
		return convertToDTO(savedEmployee);
	}

	public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));

		employee.setName(employeeDTO.getName());
		employee.setDepartmentId(employeeDTO.getDepartment().getId());
		employee.setAddress(employeeDTO.getAddress());
		employee.setMobileNumber(employeeDTO.getMobileNumber());
		employee.setSalaryId(employeeDTO.getSalaryDTO().getId());

		Employee updatedEmployee = employeeRepository.save(employee);
		return convertToDTO(updatedEmployee);
	}

	public void deleteEmployee(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
		employeeRepository.deleteById(id);
	}

	public EmployeeDTO getEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
		return convertToDTO(employee);
	}

	public List<EmployeeDTO> getAllEmployees() {
		return employeeRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	public List<EmployeeDTO> getEmployeesByDepartment(Long departmentId) {
		List<Employee> byDepartmentId = employeeRepository.findByDepartmentId(departmentId);
		return byDepartmentId.stream().map(this::convertToDTO).collect(Collectors.toList());

	}

	public List<EmployeeDTO> getEmployeesBySalary(Double minSalary, Double maxSalary) {
		return getAllEmployees().stream()
				.filter(e -> e.getSalaryDTO().getTotalSalary().longValueExact() >= minSalary
						&& e.getSalaryDTO().getTotalSalary().longValueExact() <= maxSalary)
				.collect(Collectors.toList());
	}

	public List<EmployeeDTO> getEmployeesByIds(List<Long> ids) {
		List<Employee> employees = employeeRepository.findAllById(ids);

		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		for (Employee emp : employees) {
			employeeDTOs.add(convertToDTO(emp));
		}
		System.out.println(employeeDTOs);

		return employeeDTOs;
	}

	private EmployeeDTO convertToDTO(Employee employee) {
		Department department = departmentServiceClient.getDepartmentById(employee.getDepartmentId());
		SalaryDTO salary = salaryServiceClient.getSalaryById(employee.getSalaryId());
		System.out.println(salary);
		return new EmployeeDTO(employee.getId(), employee.getName(), department, employee.getAddress(),
				employee.getMobileNumber(), salary);
	}
}