CREATE DATABASE payroll_service;
SHOW DATABASES;
USE payroll_Service;
CREATE TABLE employee_payroll(`Id` INT NOT NULL , `Emp_Name` VARCHAR(150) NOT NULL , `Salary`  Double NOT NULL , `StartDate` DATE NOT NULL , PRIMARY KEY (`ID`) );
INSERT INTO employee_payroll ( Id, Emp_Name, Salary, StartDate )   VALUES ( 01, 'shekhar', 1000000.00 , 2020-01-6),   (02, 'Naman' , 800000.00, 2020-04-13) , (03, 'Tekesh' , 600000.00, 2021-01-04) , (04, 'Navya' , 500000.00 , 2021-06-02);
SELECT * FROM employee_payroll ;
SELECT  Id,Emp_Name,Salary  FROM employee_payroll;
SELECT Salary FROM employee_payroll WHERE Emp_Name = 'shekhar';
SELECT * FROM employee_payroll WHERE StartDate BETWEEN CAST( ‘2020-01-4’ AS DATE) AND DATE(Now());
Alter TABLE employee_payroll ADD gender CHAR(1) AFTER Ename;
UPDATE employee_payroll set gender = 'M' where Emp_name in ('Shekhar' , 'Naman' , 'Tekesh');
UPDATE  employee_payroll set gender = 'F' Where Emp_name = ‘Navya’ ;
select sum(salary), avg(salary), max(salary), min(salary) from employee_payroll where gender = ‘M’ group by gender;
select sum(salary), avg(salary), max(salary), min(salary) from employee_payroll where gender = ‘F’ group by gender;