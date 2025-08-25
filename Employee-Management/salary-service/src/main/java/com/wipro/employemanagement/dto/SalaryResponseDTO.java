package com.wipro.employemanagement.dto;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SalaryResponseDTO {
    private Long id;
    private Long employeeId;
    private BigDecimal basicSalary;
    private BigDecimal hra;
    private BigDecimal da;
    private BigDecimal totalSalary;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public SalaryResponseDTO() {}

    public SalaryResponseDTO(Long id, Long employeeId, BigDecimal basicSalary, BigDecimal hra, BigDecimal da,
                              BigDecimal totalSalary, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.id = id;
        this.employeeId = employeeId;
        this.basicSalary = basicSalary;
        this.hra = hra;
        this.da = da;
        this.totalSalary = totalSalary;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public BigDecimal getBasicSalary() { return basicSalary; }
    public void setBasicSalary(BigDecimal basicSalary) { this.basicSalary = basicSalary; }

    public BigDecimal getHra() { return hra; }
    public void setHra(BigDecimal hra) { this.hra = hra; }

    public BigDecimal getDa() { return da; }
    public void setDa(BigDecimal da) { this.da = da; }

    public BigDecimal getTotalSalary() { return totalSalary; }
    public void setTotalSalary(BigDecimal totalSalary) { this.totalSalary = totalSalary; }

    public LocalDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }

    public LocalDateTime getUpdatedDate() { return updatedDate; }
    public void setUpdatedDate(LocalDateTime updatedDate) { this.updatedDate = updatedDate; }
}