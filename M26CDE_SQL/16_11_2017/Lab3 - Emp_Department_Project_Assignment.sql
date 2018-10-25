cl scr; -- Clear screen
PROMPT Dropping tables -------------------------------------------------------;
DROP TABLE Employee;
DROP TABLE Department;
--
--
PROMPT Creating Department -------------------------------------------------------;
  CREATE TABLE Department
       (dept_no NUMBER(2) PRIMARY KEY,
	dept_name VARCHAR2(20) NOT NULL,
	dept_location VARCHAR2(20));
--
--
PROMPT Creating Employee-------------------------------------------------------;
  CREATE TABLE Employee
       (emp_no CHAR(9) PRIMARY KEY,
	emp_last_name VARCHAR2(10) NOT NULL,
	emp_first_name VARCHAR2(10) NOT NULL, 
	emp_date_of_birth DATE,
	emp_salary NUMBER(7,2) CHECK(emp_salary <= 85000),
	emp_gender CHAR,
	emp_dept_no NUMBER REFERENCES department ON DELETE SET NULL);
--
--
PROMPT Displaying table Schemas -------------------------------------------------------;
DESC Department;
DESC Employee;
--
--
PROMPT Inserting Department -------------------------------------------------------;
INSERT INTO Department VALUES(1,'Production','Selly Oak');
INSERT INTO Department VALUES(2,'Marketing','Edgbaston');
INSERT INTO Department VALUES(3,'Sales','Northfield');
--
--
PROMPT Inserting Employee -------------------------------------------------------;
INSERT INTO Employee VALUES('666','Joyner','Suzanne',TO_DATE('12-06-1980', 'dd-mm-yy'),30000,'F',1);
INSERT INTO Employee VALUES('444','Zhu','Waiman',TO_DATE('12-08-1970', 'dd-mm-yy'),43000,'M',2);
INSERT INTO Employee VALUES('777','Hussain','Ryad',TO_DATE('10-08-1975', 'dd-mm-yy'),35000,'M',1);
INSERT INTO Employee VALUES('111','Keita','Salif',TO_DATE('29-03-1969', 'dd-mm-yy'),43000,'M',3);
INSERT INTO Employee VALUES('888','Shahines','Nadia',TO_DATE('04-05-1960', 'dd-mm-yy'),45000,'F',2);
INSERT INTO Employee VALUES('222','Kamarazov','Boris',TO_DATE('31-07-1978', 'dd-mm-yy'),28000,'M',3);
INSERT INTO Employee VALUES('333','Patel','Shishir',TO_DATE('09-11-1955', 'dd-mm-yy'),45000,'M',2);
INSERT INTO Employee VALUES('555','Silva','Carmen',TO_DATE('20-02-77', 'dd-mm-yy'),40000,'F',3);
INSERT INTO Employee VALUES('999','Kurusawa','Mifune',TO_DATE('08-09-52', 'dd-mm-yy'),50000,'M',2);
--
--
PROMPT Select Statements LAB 3 -------------------------------------------------------;

SELECT * FROM Employee;
SELECT * FROM Department;

PROMPT QUestion 1
SELECT emp_first_name,emp_last_name,emp_date_of_birth FROM Employee;
PROMPT QUestion 2
SELECT emp_no,emp_last_name,emp_salary FROM Employee WHERE emp_salary > 40000 ;
PROMPT QUestion 3
SELECT emp_last_name,emp_date_of_birth FROM Employee WHERE emp_last_name LIKE 'S%';
PROMPT QUestion 4
SELECT emp_last_name,emp_first_name FROM Employee WHERE emp_gender = 'F' ORDER BY emp_first_name ASC;
PROMPT QUestion 5
SELECT emp_last_name,emp_first_name, emp_dept_no FROM Employee WHERE emp_gender = 'M' AND emp_dept_no != 2;
PROMPT QUestion 6
SELECT emp_last_name,emp_first_name FROM Employee WHERE emp_gender = 'F' AND emp_salary > 35000 AND emp_date_of_birth < TO_DATE('01,01,1980','dd:mm:yy') ORDER BY emp_last_name;

PROMPT Aggregat Statements  Remember "" instead of '' for projecting new Column-------------------------------------------------------;
PROMPT QUestion 1
SELECT AVG(emp_salary) "Averge Employee Salary" FROM Employee;
PROMPT QUestion 2
SELECT SUM(emp_salary) "Total Employee Salary" FROM Employee;
PROMPT QUestion 3
SELECT MAX(emp_salary) "MAX Employee Salary", MIN(emp_salary) "MIN Employee Salary" FROM Employee;
PROMPT Question 4
SELECT Count(emp_no) "Employee Count", AVG(emp_salary) "AVG Employee Salary" FROM Employee;
PROMPT QUestion 5
SELECT AVG(emp_salary) "Averge Employee Salary", AVG(emp_salary * 0.25) FROM Employee GROUP BY emp_dept_no;
PROMPT QUestion 6
SELECT MAX(emp_salary) "MAX Employee Salary Per dep" FROM Employee GROUP BY emp_dept_no;
PROMPT QUestion 7
SELECT MAX(emp_salary) "MAX Employee Salary" FROM Employee GROUP BY emp_dept_no;
PROMPT QUestion 8
SELECT AVG(emp_salary) "AVG_salaray" FROM Employee WHERE (SELECT AVG(emp_salary) "AVG_salaray" FROM Employee) > 35000;
PROMPT QUestion 9
SELECT AVG(emp_salary) FROM Employee WHERE emp_dept_no != 1 AND (SELECT AVG(emp_salary) "AVG_salaray" FROM Employee) > 35000;
PROMPT Question 10 
SELECT AVG(emp_salary) FROM Employee WHERE (SELECT COUNT(emp_no) FROM Employee) > 2 AND (SELECT AVG(emp_salary) "AVG_salaray" FROM Employee) > 35000;
PROMPT Question 11
SELECT MAX(AVG(emp_salary)) FROM Employee GROUP BY emp_dept_no;


PROMPT Select Statements LAB 4 -------------------------------------------------------;
SELECT P.pro_name, D.dept_name FROM Project P, Department D WHERE P.pro_dept_no = D.dept_no;


COMMIT;