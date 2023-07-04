package com.example.springMVC.service;

import com.example.springMVC.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> findAllEmployees();

    void saveEmployee(EmployeeDto employeeDto);

    void delete(int empId);

    EmployeeDto findEmployeeById(int empId);
}
