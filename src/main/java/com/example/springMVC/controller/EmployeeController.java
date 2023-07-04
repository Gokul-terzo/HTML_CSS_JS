package com.example.springMVC.controller;

import com.example.springMVC.dto.EmployeeDto;
import com.example.springMVC.models.Employee;
import com.example.springMVC.service.EmployeeService;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String employeesList(Model model){
        List<EmployeeDto> employees=employeeService.findAllEmployees();
        model.addAttribute("employees",employees);
        return "employee-list";
    }

    @GetMapping("/employee/new")
    public String newEmployee(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "employee-new";
    }

    @PostMapping("/employee/new")
    public String newEmployeeCreate(Model model, @Valid @ModelAttribute("employee") EmployeeDto employeeDto, BindingResult result){
        if(result.hasErrors()){
         model.addAttribute("employee",employeeDto);
         return "employee-new";
        }
        employeeService.saveEmployee(employeeDto);
        return "redirect:/employees";
    }

    @GetMapping("/employee/{empId}/delete")
    public String deleteClub(@PathVariable("empId") int empId,Model model){
        EmployeeDto employeeDto=employeeService.findEmployeeById(empId);
        model.addAttribute("employee",employeeDto);
        return "employee-detail-delete";
    }

    @GetMapping("/employee/{empId}/confirm/delete")
    public String deleteClubConfirm(@PathVariable("empId") int empId,Model model){
        employeeService.delete(empId);
        return "redirect:/employees";
    }

    @GetMapping("/employee/{empId}/view")
    public String viewEmployee(@PathVariable("empId") int empId,Model model){
       EmployeeDto employeeDto=employeeService.findEmployeeById(empId);
       model.addAttribute("employee",employeeDto);
       return "employee-detail";
    }

    @GetMapping("/employee/{empId}/edit")
    public String editEmployeeForm(@PathVariable("empId") int empId,Model model){
        EmployeeDto employeeDto=employeeService.findEmployeeById(empId);
        model.addAttribute("employee",employeeDto);
        return "employee-edit";
    }

    @PostMapping("/employee/{empId}/edit")
    public String editEmployee(@PathVariable("empId") int empId,@Valid @ModelAttribute("employee") EmployeeDto employeeDto,BindingResult
                             result,Model model  ) {
        if(result.hasErrors()){
            model.addAttribute("employee",employeeDto);
            return "employee-edit";
        }
        employeeDto.setId(empId);
        employeeService.saveEmployee(employeeDto);
        return "redirect:/employees";
    }



}
