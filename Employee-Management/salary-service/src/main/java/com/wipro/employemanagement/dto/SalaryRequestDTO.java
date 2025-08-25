package com.wipro.employemanagement.dto;


import java.math.BigDecimal;

public class SalaryRequestDTO {
    private Long employeeId;
    private BigDecimal basicSalary;
    private BigDecimal hra;
    private BigDecimal da;

    public SalaryRequestDTO() {}

    public SalaryRequestDTO(Long employeeId, BigDecimal basicSalary, BigDecimal hra, BigDecimal da) {
        this.employeeId = employeeId;
        this.basicSalary = basicSalary;
        this.hra = hra;
        this.da = da;
    }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public BigDecimal getBasicSalary() { return basicSalary; }
    public void setBasicSalary(BigDecimal basicSalary) { this.basicSalary = basicSalary; }

    public BigDecimal getHra() { return hra; }
    public void setHra(BigDecimal hra) { this.hra = hra; }

    public BigDecimal getDa() { return da; }
    public void setDa(BigDecimal da) { this.da = da; }
}