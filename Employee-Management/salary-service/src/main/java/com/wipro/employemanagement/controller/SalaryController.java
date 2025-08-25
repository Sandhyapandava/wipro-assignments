package com.wipro.employemanagement.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.employemanagement.dto.SalaryRequestDTO;
import com.wipro.employemanagement.dto.SalaryResponseDTO;
import com.wipro.employemanagement.entity.service.SalaryService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/salaries")
@Tag(name = "Salary API", description = "Operations related to salaries")
public class SalaryController {

    private final SalaryService service;

    public SalaryController(SalaryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SalaryResponseDTO> create(@Valid @RequestBody SalaryRequestDTO request) {
        SalaryResponseDTO resp = service.createSalary(request);
        return ResponseEntity.ok(resp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaryResponseDTO> update(@PathVariable Long id, @Valid @RequestBody SalaryRequestDTO request) {
        SalaryResponseDTO resp = service.updateSalary(id, request);
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteSalary(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<SalaryResponseDTO> getByEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(service.getSalaryByEmployeeId(employeeId));
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<SalaryResponseDTO>> getByDepartment(@PathVariable Long departmentId) {
        return ResponseEntity.ok(service.getSalariesByDepartment(departmentId));
    }

    @GetMapping
    public ResponseEntity<List<SalaryResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAllSalaries());
    }
    @GetMapping("/batch")
    public List<SalaryResponseDTO> getEmployeesByIds(@RequestParam("ids") List<Long> ids) {
        return service.getSalariesByIds(ids);
    }
}