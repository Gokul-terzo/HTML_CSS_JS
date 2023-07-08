package com.example.springMVC.mapper;

import com.example.springMVC.dto.EmployeeDto;
import com.example.springMVC.models.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        EmployeeDto employeeDto= EmployeeDto.builder()
                .id(employee.getId())
                .address(employee.getAddress())
                .name(employee.getName())
                .designation(employee.getDesignation())
                .department(employee.getDepartment())
                .mobile(employee.getMobile())
                .email(employee.getEmail()).build();
        return employeeDto;
    }
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee= Employee.builder()
                .id(employeeDto.getId())
                .address(employeeDto.getAddress())
                .name(employeeDto.getName())
                .designation(employeeDto.getDesignation())
                .department(employeeDto.getDepartment())
                .mobile(employeeDto.getMobile())
                .email(employeeDto.getEmail()).build();
        return employee;
    }
}
