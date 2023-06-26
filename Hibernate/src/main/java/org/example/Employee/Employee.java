package org.example.Employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity

public class Employee {
    @Id
    private int id;
    private String name;
    private int deptId;
    private int roleId;
    private int salary;

    public Employee(){

    }

    public Employee(int id, String name, int deptId, int roleId, int salary) {
        this.id = id;
        this.name = name;
        this.deptId = deptId;
        this.roleId = roleId;
        this.salary = salary;
    }

    @ManyToOne
    private Department department;

    @ManyToOne
    private Role role;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deptId=" + deptId +
                ", roleId=" + roleId +
                ", salary=" + salary +
                ", department=" + department +
                ", role=" + role +
                '}';
    }
}
