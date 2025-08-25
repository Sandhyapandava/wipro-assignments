package com.wipro.employemanagement.entity.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.employemanagement.dto.EmployeeDTO;
import com.wipro.employemanagement.dto.SalaryRequestDTO;
import com.wipro.employemanagement.dto.SalaryResponseDTO;
import com.wipro.employemanagement.entity.Salary;
import com.wipro.employemanagement.exception.ResourceNotFoundException;
import com.wipro.employemanagement.feign.EmployeeClient;
import com.wipro.employemanagement.repository.SalaryRepository;

@Service
@Transactional
public class SalaryService {

	private final SalaryRepository salaryRepository;
	private final EmployeeClient employeeClient;

	public SalaryService(SalaryRepository salaryRepository, EmployeeClient employeeClient) {
		this.salaryRepository = salaryRepository;
		this.employeeClient = employeeClient;
	}

	public SalaryResponseDTO createSalary(SalaryRequestDTO request) {
		Salary salary = new Salary();
		salary.setEmployeeId(request.getEmployeeId());
		salary.setBasicSalary(nonNull(request.getBasicSalary()));
		salary.setHra(nonNull(request.getHra()));
		salary.setDa(nonNull(request.getDa()));
		salary.setTotalSalary(calculateTotal(salary.getBasicSalary(), salary.getHra(), salary.getDa()));
		salary.setCreatedDate(LocalDateTime.now());
		salary.setUpdatedDate(LocalDateTime.now());
		Salary saved = salaryRepository.save(salary);
		return toResponse(saved);
	}

	public SalaryResponseDTO updateSalary(Long id, SalaryRequestDTO request) {
		Salary salary = salaryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Salary not found with id: " + id));
		if (request.getBasicSalary() != null)
			salary.setBasicSalary(request.getBasicSalary());
		if (request.getHra() != null)
			salary.setHra(request.getHra());
		if (request.getDa() != null)
			salary.setDa(request.getDa());
		salary.setTotalSalary(calculateTotal(salary.getBasicSalary(), salary.getHra(), salary.getDa()));
		salary.setUpdatedDate(LocalDateTime.now());
		Salary updated = salaryRepository.save(salary);
		return toResponse(updated);
	}

	public void deleteSalary(Long id) {
		if (!salaryRepository.existsById(id)) {
			throw new ResourceNotFoundException("Salary not found with id: " + id);
		}
		salaryRepository.deleteById(id);
	}

	public SalaryResponseDTO getSalaryByEmployeeId(Long employeeId) {
		Salary salary = salaryRepository.findByEmployeeId(employeeId)

				.orElseThrow(() -> new ResourceNotFoundException("Salary not found for employee: " + employeeId));
		System.out.println(salary);
		return toResponse(salary);
	}

	public List<SalaryResponseDTO> getAllSalaries() {
		List<Salary> list = salaryRepository.findAll();
		return list.stream().map(this::toResponse).collect(Collectors.toList());
	}

	public List<SalaryResponseDTO> getSalariesByDepartment(Long departmentId) {
		List<EmployeeDTO> employees = employeeClient.getEmployeesByDepartment(departmentId);
		if (employees == null || employees.isEmpty())
			return Collections.emptyList();
		List<Long> employeeIds = employees.stream().map(EmployeeDTO::getId).collect(Collectors.toList());
		List<Salary> salaries = salaryRepository.findByEmployeeIdIn(employeeIds);
		return salaries.stream().map(this::toResponse).collect(Collectors.toList());
	}

	private BigDecimal calculateTotal(BigDecimal basic, BigDecimal hra, BigDecimal da) {
		BigDecimal total = nonNull(basic);
		total = total.add(nonNull(hra)).add(nonNull(da));
		return total;
	}

	private BigDecimal nonNull(BigDecimal b) {
		return b == null ? BigDecimal.ZERO : b;
	}

	private SalaryResponseDTO toResponse(Salary s) {
		SalaryResponseDTO dto = new SalaryResponseDTO();
		dto.setId(s.getId());
		dto.setEmployeeId(s.getEmployeeId());
		dto.setBasicSalary(s.getBasicSalary());
		dto.setHra(s.getHra());
		dto.setDa(s.getDa());
		dto.setTotalSalary(s.getTotalSalary());
		dto.setCreatedDate(s.getCreatedDate());
		dto.setUpdatedDate(s.getUpdatedDate());
		return dto;
	}

	public List<SalaryResponseDTO> getSalariesByIds(List<Long> ids) {
		List<Salary> employees = salaryRepository.findAllById(ids);
		List<SalaryResponseDTO> employeeDTOs = employees.stream().map(employee -> {
			SalaryResponseDTO dto = new SalaryResponseDTO();
			BeanUtils.copyProperties(employee, dto);
			return dto;
		}).collect(Collectors.toList());

		System.out.println(employees);
		System.out.println(employeeDTOs);
		return employeeDTOs;
	}
}
