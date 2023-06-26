package org.example.Employee;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Role {
    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "role")
    private List<Employee> employee= new ArrayList<>();

    public Role(){

    }
    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
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

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
