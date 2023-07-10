package com.example.springMVC.service.implementation;

import com.example.springMVC.dto.EmployeeDto;
import com.example.springMVC.models.Employee;
import com.example.springMVC.repository.EmployeeRepository;
import com.example.springMVC.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.springMVC.mapper.EmployeeMapper.mapToEmployee;
import static com.example.springMVC.mapper.EmployeeMapper.mapToEmployeeDto;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<EmployeeDto> findAllEmployees() {
        List<Employee> employees= employeeRepository.findAll();
       return  employees.stream().map((e)->mapToEmployeeDto(e)).collect(Collectors.toList());
    }

    @Override
    public void saveEmployee(EmployeeDto employeeDto) {
        Employee employee=mapToEmployee(employeeDto);
        employeeRepository.save(employee);
    }
    @Override
    public void delete(int empId) {
        employeeRepository.deleteById(empId);
    }

    @Override
    public EmployeeDto findEmployeeById(int empId) {
        Employee employee=employeeRepository.findById(empId);
        EmployeeDto employeeDto=mapToEmployeeDto(employee);
        return employeeDto;
    }

}
