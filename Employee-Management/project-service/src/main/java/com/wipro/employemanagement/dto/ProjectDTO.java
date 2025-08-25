package com.wipro.employemanagement.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class ProjectDTO {
    private Long id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Set<Long> employeeIds;
    private List<EmployeeDTO> employees;
    
    public ProjectDTO() {}
    
    public ProjectDTO(Long id, String name, String description, LocalDate startDate, 
                     LocalDate endDate, Set<Long> employeeIds) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employeeIds = employeeIds;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    
    public Set<Long> getEmployeeIds() { return employeeIds; }
    public void setEmployeeIds(Set<Long> employeeIds) { this.employeeIds = employeeIds; }
    
    public List<EmployeeDTO> getEmployees() { return employees; }
    public void setEmployees(List<EmployeeDTO> employees) { this.employees = employees; }
}