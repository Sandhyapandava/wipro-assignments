package com.wipro.employemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String name;
    private Department department;
    private String address;
    private String mobileNumber;
    private SalaryDTO salaryDTO;

    
}
