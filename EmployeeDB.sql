SELECT e.First_name AS Highest_Paid,s.Salary_amount
FROM Employee e
         JOIN salary s ON e.Employee_id = s.Employee_id
WHERE s.Salary_amount = (SELECT MAX(Salary_amount) FROM salary);

SELECT e.First_name AS Employee_name,s.Salary_amount
FROM Employee e
         JOIN salary s ON e.Employee_id = s.Employee_id
WHERE s.Salary_amount > (SELECT AVG(Salary_amount) FROM salary);

Select * from Employee where Job_title REGEXP 'Manager';

Select * from Employee where Job_title NOT LIKE 'Manager';

Select * from Employee e JOIN Address a ON e.Employee_id=a.Employee_id WHERE a.City REGEXP 'CHENNAI';

SELECT e.First_name,e.Job_Title,d.Department_name FROM Employee e JOIN Department d ON e.Dept_id=d.Department_id WHERE d.Department_id=1;

SELECT First_name,Job_Title from Employee where Job_Title Like "%Team Lead";

SELECT e.First_name AS Employee_name,s.Salary_amount
FROM Employee e
         JOIN salary s ON e.Employee_id = s.Employee_id
WHERE s.Salary_amount>=400000;

SELECT e.First_name AS Employee,d.Department_name
FROM Employee e
         JOIN salary s ON e.Employee_id = s.Employee_id
JOIN Department d ON e.Dept_id=d.Department_id
WHERE s.Salary_amount>=400000;

SELECT * FROM Employee e JOIN Leaves_data l ON e.Employee_id=l.Employee_id WHERE End_date-Start_date>=10;

SELECT First_name,Job_Title,d.Department_name FROM Employee e 
JOIN Department d ON e.Dept_id=d.Department_id ORDER BY d.Department_name,e.Job_Title;

SELECT d.Department_name, COUNT(e.Employee_id) AS "Number of Employees"
FROM Department d JOIN Employee e ON e.Dept_id = d.Department_id WHERE
e.Hire_date BETWEEN '2023-06-01' AND '2023-06-31' GROUP BY d.Department_id,
d.Department_name;

SELECT e.First_name as "Employee Name" , DATEDIFF(el.End_date,el.Start_date) AS
'Days Absent' FROM Employee e JOIN Department d on e.Dept_id = d.Department_id join
Salary s on e.Employee_id = s.Employee_id join Leaves_data el on e.Employee_id = el.Employee_id
where d.Department_name = "Sales" and s.Salary_amount >300000;

SELECT e.First_name AS "Employee Name", SUM(s.Salary_amount) AS "Total Salary"
FROM Employee e JOIN Salary s ON e.Employee_id = s.Employee_id WHERE
YEAR(s.start_date) = 2023 GROUP BY e.Employee_id, e.First_name


