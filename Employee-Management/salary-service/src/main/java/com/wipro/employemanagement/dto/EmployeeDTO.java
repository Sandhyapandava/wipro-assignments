package com.wipro.employemanagement.dto;


public class EmployeeDTO {
    private Long id;
    private String name;
    private DepartmentDTO department;
    private String address;
    private String mobileNumber;
    private SalaryResponseDTO salary;

    public EmployeeDTO() {}

    public EmployeeDTO(Long id, String name, DepartmentDTO department, String address, String mobileNumber, SalaryResponseDTO salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.salary = salary;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public DepartmentDTO getDepartment() { return department; }
    public void setDepartment(DepartmentDTO department) { this.department = department; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    public SalaryResponseDTO getSalary() { return salary; }
    public void setSalary(SalaryResponseDTO salary) { this.salary = salary; }
}