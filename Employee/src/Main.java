import java.sql.*;
import java.sql.Date;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mariadb://localhost:3306/Employee";
        String username = "root";
        String password = "root";
        try {
            // Register the MariaDB JDBC driver
            Class.forName("org.mariadb.jdbc.Driver");
            // Establish the database connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            // Connection successful
            System.out.println("Connected to the database!");
            // Perform database operations...
            // Close the connection
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM Employee";
            ResultSet resultSet = stmt.executeQuery(query);

            List<Employee> employeeDetails=new ArrayList<>();
            //Traversing table and storing in lists
            String EmployeeName;
            Integer EmployeeSalary;
            String EmployeeNumber;
            String EmployeeDepartment;
            Date JoiningDate;
            while (resultSet.next()) {
                // Access the column values using resultSet.get<Type>(column_index) method
                EmployeeName=resultSet.getString(1);
                EmployeeSalary=resultSet.getInt(4);
                EmployeeNumber=resultSet.getString(3);
                EmployeeDepartment=resultSet.getString(5);
                JoiningDate=resultSet.getDate(6);
                LocalDate date=JoiningDate.toLocalDate();
                Employee emp=new Employee(EmployeeName,EmployeeNumber,EmployeeSalary,EmployeeDepartment,date);
                employeeDetails.add(emp);
            }
            int index=0;
            //1.Filter names that start with D
            System.out.println("Employees whose name starts with 'D':\n");
            List<Employee> nameFilter=employeeDetails.stream()
                    .filter(x -> x.getEmployeeName().startsWith("D"))
                    .toList();
            for(var x:nameFilter){
                System.out.println(++index+"."+x.getEmployeeName());
            }
            System.out.println();
            //2.Filter employee with no mobile number in table
            System.out.println("Employees whose number is not updated in the table:\n");
            List<Employee> numberFilter=new ArrayList<>();
            numberFilter=employeeDetails.stream()
                    .filter(x -> x.getEmployeePhone().equals("")).toList();
            index=0;
            for(var x:numberFilter){
                System.out.println(++index+"."+x.getEmployeeName());
            }
            System.out.println();

            //3.Obtain a list of employees belongs to category “QA” with salary > 10000
            System.out.println("List of employees of category QA with salary>10000:\n");
            List<Employee> salaryCategoryFilter=new ArrayList<>();
            salaryCategoryFilter=employeeDetails.stream()
                    .filter(x -> x.getEmployeeDepartment().equals("QA")).filter(x->x.getEmployeeSal()>10000).toList();
            index=0;
            for(var x:salaryCategoryFilter){
                System.out.println(++index+"."+x.getEmployeeName());
            }
            System.out.println();

            //4.Obtain a list of employees with products belong to department “IT”
            System.out.println("List of employees belonging to IT department:\n");
            List<Employee> deptFilter=employeeDetails.stream().filter(x->x.getEmployeeDepartment().equals("IT"))
                            .toList();
            index=0;
            for(var x:deptFilter){
                System.out.println(++index+"."+x.getEmployeeName());
            }
            System.out.println();

            //5.Obtain a list of employees with department = “DEV” and then apply 10% increment in the salary
            System.out.println("Employees in department DEV:\n");
            index=0;
            List<Employee> incrementList=employeeDetails.stream().filter(x->x.getEmployeeDepartment().equals("DEV")).toList();
            System.out.println("Before salary increment\n");
            for(var x:incrementList){
                System.out.println(++index+"."+x.getEmployeeName()+" "+x.getEmployeeSal());
            }
            System.out.println();
            System.out.println("After salary increment\n");
            index=0;
            for(var x:incrementList){
                int updatedSalary=x.getEmployeeSal();
                updatedSalary+=0.1*updatedSalary;
                x.setEmployeeSal(updatedSalary);
                System.out.println(++index+"."+x.getEmployeeName()+" "+x.getEmployeeSal());
            }
            System.out.println();

            //6.Obtain a list of employees joined between 01-Feb-2021 and 01-Apr-2021
            System.out.println("List of employees joined between 01.02.2021 and 01.04.2021:\n");
            LocalDate startDate= LocalDate.of(2021,02,01);
            LocalDate endDate=LocalDate.of(2021,04,01);
            List<Employee> joinDateFilter=employeeDetails.stream().
                    filter(x->x.getJoinDate().isAfter(startDate) && x.getJoinDate().isBefore(endDate)).toList();
            index=0;
            for(var x:joinDateFilter){
                System.out.println(++index+"."+x.getEmployeeName()+" "+x.getJoinDate());
            }
            System.out.println();

            //7.Get the lowest salary of employee
            ArrayList<Integer> salary=new ArrayList<>();
            for(var x:employeeDetails){
                salary.add(x.getEmployeeSal());
            }
            List<Integer> sortedsal=salary.stream().sorted().toList();
            System.out.println("Min salary:"+sortedsal.get(0));
            System.out.println();

            //8.Get the 3 most recently joined
            System.out.println("Top 3 recently joined:\n");
            employeeDetails.sort(Comparator.comparing(Employee::getJoinDate).reversed());
            employeeDetails.stream().limit(3).forEach(System.out::println);
            System.out.println();

            //9.Calculate total  sum of all salary joined in Feb 2021
            System.out.println("Sum of all salary of employees joined in Feb 2021:");
            long febSal=0;
            LocalDate febEnd=LocalDate.of(2021,02,28);
            List<Employee> febSalary=employeeDetails.stream().filter(x->x.getJoinDate().isBefore(febEnd) && x.getJoinDate().isAfter(startDate)).toList();
            for(var x:febSalary){
                febSal+=x.getEmployeeSal();
            }

            System.out.println(NumberFormat.getCurrencyInstance().format(febSal));

            //10.Calculate average salary for employee joined on 14-Mar-2021
            LocalDate exactDate=LocalDate.of(2021,03,14);
            List<Employee> avgList=employeeDetails.stream().filter(x->x.getJoinDate().isEqual(exactDate)).toList();
            long avgSalary=0;
            for (var x:avgList){
                avgSalary+=x.getEmployeeSal();
            }
            avgSalary/=avgList.size();
            System.out.println("\nAverage salary of employees joined on March 14 2021:"+avgSalary);
            System.out.println();

            //11.Obtain a data map with Department id and employees count
            List<Employee> itList=employeeDetails.stream().filter(x->x.getEmployeeDepartment().equals("IT")).toList();
            List<Employee> qaList=employeeDetails.stream().filter(x->x.getEmployeeDepartment().equals("QA")).toList();
            List<Employee> devList=employeeDetails.stream().filter(x->x.getEmployeeDepartment().equals("DEV")).toList();
            List<Employee> managerList=employeeDetails.stream().filter(x->x.getEmployeeDepartment().equals("MANAGER")).toList();
            Map<String,Integer> deptCountMap=new HashMap<>();
            deptCountMap.put("IT",itList.size());
            deptCountMap.put("QA",qaList.size());
            deptCountMap.put("DEV",devList.size());
            deptCountMap.put("MANAGER",managerList.size());
            System.out.println("Map for count of employees in each dept:");
            System.out.println(deptCountMap);
            System.out.println();

            //12.Produce a data map with employee records grouped by department
            Map<String,List<Employee>> groupMap=new HashMap<>();
            groupMap.put("IT",itList);
            groupMap.put("DEV",devList);
            groupMap.put("MANAGER",managerList);
            groupMap.put("QA",qaList);
            System.out.println("Map grouping employees by department");
            System.out.println(groupMap);
            System.out.println();

            //13.Produce a data map with department and their salary
            Map<String,List<Integer>> deptSalaryMap=new HashMap<>();
            List<Integer> itSalary=new ArrayList<>();
            List<Integer> devSalary=new ArrayList<>();
            List<Integer> qaSalary=new ArrayList<>();
            List<Integer> managerSalary=new ArrayList<>();

            for(var x:itList){
                itSalary.add(x.getEmployeeSal());
            }
            for(var x:qaList){
                qaSalary.add(x.getEmployeeSal());
            }
            for(var x:devList){
                devSalary.add(x.getEmployeeSal());
            }
            for(var x:managerList){
                managerSalary.add(x.getEmployeeSal());
            }
            deptSalaryMap.put("IT",itSalary);
            deptSalaryMap.put("DEV",devSalary);
            deptSalaryMap.put("QA",qaSalary);
            deptSalaryMap.put("MANAGER",managerSalary);
            System.out.println("Map of department and their salary list:");
            System.out.println(deptSalaryMap);
            System.out.println();

            //14.Get the  highest paid by category
            Map<String,String> highestPaidByCategory=new HashMap<>();
            int itMaxSalary= Integer.MIN_VALUE;
            int qaMaxSalary=Integer.MIN_VALUE;
            int devMaxSalary=Integer.MIN_VALUE;
            int managerMaxSalary=Integer.MIN_VALUE;
            String highestPaidIT="";
            String highestPaidDEV="";
            String highestPaidQA="";
            String highestPaidManager="";

            for (var x:itList){
                if(itMaxSalary<x.getEmployeeSal()) {
                    itMaxSalary = x.getEmployeeSal();
                    highestPaidIT=x.getEmployeeName();
                }
            }
            for (var x:qaList){
                if(qaMaxSalary<x.getEmployeeSal()) {
                    qaMaxSalary = x.getEmployeeSal();
                    highestPaidQA=x.getEmployeeName();
                }
            }
            for (var x:managerList){
                if(managerMaxSalary<x.getEmployeeSal()) {
                    managerMaxSalary = x.getEmployeeSal();
                    highestPaidManager=x.getEmployeeName();
                }
            }
            for (var x:devList){
                if(devMaxSalary<x.getEmployeeSal()) {
                    devMaxSalary = x.getEmployeeSal();
                    highestPaidDEV=x.getEmployeeName();
                }
            }
            highestPaidByCategory.put("IT",highestPaidIT);
            highestPaidByCategory.put("DEV",highestPaidDEV);
            highestPaidByCategory.put("QA",highestPaidQA);
            highestPaidByCategory.put("Manager",highestPaidManager);
            System.out.println("Highest paid employees by category:");
            System.out.println(highestPaidByCategory);

            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
