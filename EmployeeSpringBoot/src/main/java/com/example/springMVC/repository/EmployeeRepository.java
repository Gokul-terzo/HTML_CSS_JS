package com.example.springMVC.repository;

import com.example.springMVC.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Optional<Employee> findEmployeeByName(String name);
    Employee findById(int id);
}
