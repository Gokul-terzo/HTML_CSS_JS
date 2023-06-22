import java.time.LocalDate;

public class Employee {
   private String employeeName;
   private String employeePhone;

    private int employeeSal;

    private String employeeDepartment;

    private LocalDate joinDate;

    public Employee(String employeeName, String employeePhone, int employeeSal, String employeeDepartment, LocalDate joinDate) {
        this.employeeName = employeeName;
        this.employeePhone = employeePhone;
        this.employeeSal = employeeSal;
        this.employeeDepartment = employeeDepartment;
        this.joinDate = joinDate;
    }

    public int getEmployeeSal() {
        return employeeSal;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setEmployeeSal(int employeeSal) {
        this.employeeSal = employeeSal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeePhone='" + employeePhone + '\'' +
                ", employeeSal=" + employeeSal +
                ", employeeDepartment='" + employeeDepartment + '\'' +
                ", joinDate=" + joinDate +
                '}';
    }
}
