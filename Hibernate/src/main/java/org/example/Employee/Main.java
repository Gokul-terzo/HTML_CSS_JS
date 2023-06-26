package org.example.Employee;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Employee> emp=new ArrayList<>();
        ArrayList<Role> roles=new ArrayList<>();

        int employeeCount=0;
        int roleCount=3;
        Configuration configuration = new Configuration().addAnnotatedClass(Employee.class).
                addAnnotatedClass(Role.class).addAnnotatedClass(Department.class);
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sf = configuration.buildSessionFactory();
        Session  session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        //1.Save to DB

        Department department=new Department(1,"Engineering");

        emp.add(new Employee(1,"Gokul",1,1,10000));
        emp.add(new Employee(2,"Yogavarshan",1,2,20000));
        emp.add(new Employee(3,"Yusvanth",1,1,30000));

        employeeCount=emp.size();

        emp.forEach(e->
                session.save(e));

        session.save(department);

        roles.add(new Role(1,"Platforms"));
        roles.add(new Role(2,"Full-Stack"));
        roles.add(new Role(3,"QA"));

        roles.forEach(e->
                session.save(e));

        emp.clear();
        //2.Fetch from DB
        for (int i=0;i<employeeCount;i++){
            Employee emp1=session.get(Employee.class,i+1);
            emp.add(emp1);
        }
        System.out.println("Employee Details fetched:");
        for(var a:emp){
            System.out.println(a);
        }

        //3.Create new Department
        Department dept=new Department();
        dept.setName("Analyst");
        dept.setId(2);

//        session.save(dept);


        //4.Mapping the new Department to an Employee
        Employee emp1=session.get(Employee.class,1);
        int depid=dept.getId();
        emp1.setDeptId(depid);
        emp1.setDepartment(dept);
        session.update(emp1);

        //5.Update Role name with id=1

        Role r=session.get(Role.class,1);
        r.setName("Platforms Engineering");
        session.update(r);

        //6.Delete an employee
        session.remove(emp1);

        transaction.commit();
    }
}
