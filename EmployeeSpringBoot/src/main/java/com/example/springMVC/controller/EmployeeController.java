package com.example.springMVC.controller;

import com.example.springMVC.dto.EmployeeDto;
import com.example.springMVC.dto.RegistrationDto;
import com.example.springMVC.service.AuthoritiesService;
import com.example.springMVC.service.EmployeeService;
import com.example.springMVC.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;


    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }




    @GetMapping("/employees")
    public List<EmployeeDto> employeesList(Model model){
        List<EmployeeDto> employees=employeeService.findAllEmployees();
        return employees;
    }

    @PostMapping("/employee/new")
    public EmployeeDto newEmployeeCreate(@RequestBody EmployeeDto employeeDto){
        employeeService.saveEmployee(employeeDto);
        return employeeDto;
    }

    @DeleteMapping("/employee/{empId}/delete")
    public EmployeeDto deleteClub(@PathVariable("empId") int empId){
        EmployeeDto employeeDto=employeeService.findEmployeeById(empId);
        employeeService.delete(empId);
        return employeeDto;
    }


    @GetMapping("/employee/{empId}/view")
    public EmployeeDto viewEmployee(@PathVariable("empId") int empId){
       EmployeeDto employeeDto=employeeService.findEmployeeById(empId);
       return employeeDto;
    }

    @PutMapping("/employee/{empId}/edit")
    public EmployeeDto editEmployee(@PathVariable("empId") int empId,@RequestBody EmployeeDto employeeDto) {
        employeeDto.setId(empId);
        employeeService.saveEmployee(employeeDto);
        return employeeDto;
    }


}
