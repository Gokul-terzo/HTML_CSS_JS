package com.example.springMVC.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDto {
    private int id;
    @NotEmpty(message = "Employee name is a mandatory field!")
    private String name;
    @NotEmpty(message = "Employee email is a mandatory field!")
    private String email;
    @NotEmpty(message = "Employee designation is a mandatory field!")
    private String designation;
    @NotEmpty(message = "Employee address is a mandatory field!")
    private String address;
    @NotEmpty(message = "Employee department is a mandatory field!")
    private String department;
    private long mobile;
}
