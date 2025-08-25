package com.wipro.employemanagement.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryDTO {
	  private Long id;
	    private Long employeeId;
	    private BigDecimal basicSalary;
	    private BigDecimal hra;
	    private BigDecimal da;
	    private BigDecimal totalSalary;
    
}