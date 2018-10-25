--Group
--Chris Rollings
--Iskandar Mohd Supian
--Thabiso Khumalo
--Dumebi Jeffreys
cl scr;
SPOOL "H:\M26CDE_SQL\Course work\14_12_2017\spooloutput.txt" REPLACE
PROMPT Dropping tables -------------------------------------------------------;
DROP TABLE Visits;
DROP TABLE Gp;
DROP TABLE OpeningTimes;
DROP TABLE Perscriptions;
DROP TABLE Surgery;
DROP TABLE Patients;
DROP TABLE Conditions;
DROP TABLE Medication;

PROMPT Table Creations ------------------------------------------------;
CREATE TABLE Conditions(
 name char(30),
 description VARCHAR2(100),
 PRIMARY KEY (name));

CREATE TABLE Patients(
 name VARCHAR2(20) NOT NULL,
 address VARCHAR2(100) NOT NULL,
 dateOfBirth DATE NOT NULL,
 bloodGroup VARCHAR2(1) NOT NULL,
 phoneNo VARCHAR2(20),
 PRIMARY KEY(name));

CREATE TABLE Surgery(
  name VARCHAR2(20) NOT NULL,
  surgeryAddress VARCHAR2(30) NOT NULL,
  phoneNo varchar2(10) NOT NULL,
  PRIMARY KEY (name));

CREATE TABLE OpeningTimes(
  ID NUMBER NOT NULL,
  surgeryFk VARCHAR2(20) NOT NULL REFERENCES Surgery,
  day VARCHAR2(20),
  openingTime NUMBER NOT NULL,
  closingTime NUMBER NOT NULL,
  PRIMARY KEY (ID));

CREATE TABLE Gp (  
  name VARCHAR2(20) NOT NULL,
  surgeryFk VARCHAR2(20) NOT NULL REFERENCES Surgery,
  speciality VARCHAR2(20),
  PRIMARY KEY (name));

CREATE TABLE Medication(
  name VARCHAR2(20) NOT NULL,
  PRIMARY KEY (name));

CREATE TABLE Perscriptions(
  ID NUMBER NOT NULL,
  medicationFk VARCHAR2(20) NOT NULL REFERENCES Medication,
  quantity NUMBER,
  units VARCHAR2(20),
  instructions VARCHAR2(150),
  PRIMARY KEY (ID));

CREATE TABLE Visits(
  visitDate DATE NOT NULL,
  patientFk VARCHAR2(20) NOT NULL REFERENCES Patients,
  gpFk VARCHAR2(20) NOT NULL REFERENCES Gp,
  conditionFk char(30) NOT NULL REFERENCES Conditions,
  perscriptionFk NUMBER NOT NULL REFERENCES Perscriptions,
  surgeryFk VARCHAR2(20) NOT NULL REFERENCES Surgery,
  CONSTRAINT visitPk PRIMARY KEY (patientFk,visitDate));

PROMPT Inserting Conditions(name,description)
INSERT INTO Conditions VALUES('Type 1 Diabetes','Low blood suger');
INSERT INTO Conditions VALUES('Type 2 Diabetes','Low blodd sugar');
INSERT INTO Conditions VALUES('High Blood Pressure','');

PROMPT Inserting Patients(name,address,dateOfBirth,bloodGroup,phoneNo)
INSERT INTO Patients VALUES('tim','1 doverfield cottages',TO_DATE('11-02-1989', 'dd-mm-yy'),'A','0121666');
INSERT INTO Patients VALUES('tom','2 fin lane',TO_DATE('12-08-1980', 'dd-mm-yy'),'C','0121667');
INSERT INTO Patients VALUES('bill','3 charlesvile',TO_DATE('12-08-1990', 'dd-mm-yy'),'B','0121668');
INSERT INTO Patients VALUES('bob','3 charlesvile',TO_DATE('12-08-1990', 'dd-mm-yy'),'B','0121668');

PROMPT Inserting Surgery(name,address,phoneNo)
INSERT INTO Surgery VALUES('Hertford Surgery' ,'6 camphill road'       ,'0247685867');
INSERT INTO Surgery VALUES('Cov and warwick'  ,'6 binley road coventry','0247686940');

PROMPT Insertig OpeningTimes(ID,Surgery,day,openingTime,closingTime)
-- Time in seconds past midnight
INSERT INTO OpeningTimes VALUES(1,'Hertford Surgery' ,'Monday'   ,21600,79200);
INSERT INTO OpeningTimes VALUES(2,'Hertford Surgery' ,'Tuesday'  ,21600,79200);
INSERT INTO OpeningTimes VALUES(3,'Hertford Surgery' ,'Wednesday',21600,79200);
INSERT INTO OpeningTimes VALUES(4,'Hertford Surgery' ,'Thrusday' ,21600,79200);
INSERT INTO OpeningTimes VALUES(5,'Hertford Surgery' ,'Friday'   ,21600,79200);
INSERT INTO OpeningTimes VALUES(6,'Cov and warwick','Monday'   ,21600,60000);
INSERT INTO OpeningTimes VALUES(7,'Cov and warwick','Tuesday'  ,21600,60000);
INSERT INTO OpeningTimes VALUES(8,'Cov and warwick','Wednesday',21600,60000);
INSERT INTO OpeningTimes VALUES(9,'Cov and warwick','Thrusday' ,21600,60000);
INSERT INTO OpeningTimes VALUES(10,'Cov and warwick','Friday'   ,21600,60000);

PROMPT Insertig Gp(name,surgery,speciality)
INSERT INTO Gp VALUES('Dr. S. Patel','Hertford Surgery','Blood');
INSERT INTO Gp VALUES('Dr. P. Jones','Cov and warwick','Blood');

PROMPT Insertig Medication(name)
INSERT INTO Medication VALUES('Glipzide');
INSERT INTO Medication VALUES('Insulin');
INSERT INTO Medication VALUES('Bumetanide');

PROMPT Inserting Perscriptions(ID,medicationFk,quantity,units,instructions)
INSERT INTO Perscriptions VALUES(1 ,'Glipzide',100 ,'mg','Take glipizide 30 minutes before a meal');
INSERT INTO Perscriptions VALUES(2 ,'Insulin',50 ,'mg','Two to for a day');
INSERT INTO Perscriptions VALUES(3 ,'Bumetanide',50 ,'mg','Once a week');

PROMPT Insertig Visits (visitDate,patientFk,gpFk,conditionFk,perscriptionFk,surgeryFk)
INSERT INTO Visits VALUES(TO_DATE('03/01/2007','dd/mm/yy'),'tim','Dr. S. Patel','Type 1 Diabetes',2,'Hertford Surgery');
INSERT INTO Visits VALUES(TO_DATE('02/03/2007','dd/mm/yy'),'tim','Dr. S. Patel','High Blood Pressure',3,'Hertford Surgery');
INSERT INTO Visits VALUES(TO_DATE('03/04/2007','dd/mm/yy'),'tim','Dr. S. Patel','Type 1 Diabetes',2,'Hertford Surgery');


INSERT INTO Visits VALUES(TO_DATE('04/05/2007','dd/mm/yy'),'tom','Dr. S. Patel','High Blood Pressure',3,'Hertford Surgery');
INSERT INTO Visits VALUES(TO_DATE('05/02/2007','dd/mm/yy'),'tom','Dr. S. Patel','Type 2 Diabetes',1,'Hertford Surgery');
INSERT INTO Visits VALUES(TO_DATE('01/01/2007','dd/mm/yy'),'tom','Dr. S. Patel','Type 2 Diabetes',1,'Hertford Surgery');
INSERT INTO Visits VALUES(TO_DATE('03/11/2017','dd/mm/yy'),'tom','Dr. S. Patel','Type 2 Diabetes',1,'Hertford Surgery');
INSERT INTO Visits VALUES(TO_DATE('01/11/2017','dd/mm/yy'),'tom','Dr. P. Jones','Type 2 Diabetes',1,'Cov and warwick');
INSERT INTO Visits VALUES(TO_DATE('02/11/2017','dd/mm/yy'),'tom','Dr. P. Jones','Type 2 Diabetes',1,'Cov and warwick');

INSERT INTO Visits VALUES(TO_DATE('01/01/2006','dd/mm/yy'),'bill','Dr. S. Patel','Type 1 Diabetes',2,'Hertford Surgery');
INSERT INTO Visits VALUES(TO_DATE('02/03/2006','dd/mm/yy'),'bill','Dr. P. Jones','Type 1 Diabetes',2,'Cov and warwick');
INSERT INTO Visits VALUES(TO_DATE('03/04/2006','dd/mm/yy'),'bill','Dr. P. Jones','Type 1 Diabetes',2,'Cov and warwick');
INSERT INTO Visits VALUES(TO_DATE('04/12/2006','dd/mm/yy'),'bill','Dr. P. Jones','High Blood Pressure',3,'Cov and warwick');
INSERT INTO Visits VALUES(TO_DATE('04/08/2007','dd/mm/yy'),'bill','Dr. P. Jones','High Blood Pressure',3,'Cov and warwick');
INSERT INTO Visits VALUES(TO_DATE('04/09/2007','dd/mm/yy'),'bill','Dr. P. Jones','High Blood Pressure',3,'Cov and warwick');

INSERT INTO Visits VALUES(TO_DATE('01/01/2006','dd/mm/yy'),'bob','Dr. S. Patel','Type 2 Diabetes',1,'Hertford Surgery');
INSERT INTO Visits VALUES(TO_DATE('02/02/2006','dd/mm/yy'),'bob','Dr. S. Patel','Type 2 Diabetes',1,'Hertford Surgery');
INSERT INTO Visits VALUES(TO_DATE('03/03/2006','dd/mm/yy'),'bob','Dr. S. Patel','Type 2 Diabetes',1,'Hertford Surgery');
INSERT INTO Visits VALUES(TO_DATE('04/04/2007','dd/mm/yy'),'bob','Dr. S. Patel','Type 2 Diabetes',1,'Hertford Surgery');
INSERT INTO Visits VALUES(TO_DATE('05/05/2007','dd/mm/yy'),'bob','Dr. S. Patel','Type 2 Diabetes',1,'Hertford Surgery');
INSERT INTO Visits VALUES(TO_DATE('06/06/2007','dd/mm/yy'),'bob','Dr. S. Patel','Type 2 Diabetes',1,'Hertford Surgery');
INSERT INTO Visits VALUES(TO_DATE('07/07/2007','dd/mm/yy'),'bob','Dr. S. Patel','Type 2 Diabetes',1,'Hertford Surgery');

PROMPT Performing Query 1
    SELECT name, bloodGroup FROM Patients WHERE name IN 
    (SELECT patientFk FROM Visits WHERE 
    gpFk =  'Dr. S. Patel' AND 
    conditionFk = (SELECT name FROM Conditions WHERE name = 'High Blood Pressure')) ;

PROMPT Performing Query 2
SELECT patientFk as patientname, conditionFk as conditionname ,visitDate as visitdate FROM Visits WHERE surgeryFk = 'Hertford Surgery' 
    AND perscriptionFk =(SELECT ID FROM Perscriptions WHERE medicationFk = 'Glipzide')
    AND visitDate > TO_DATE('31/12/2006','dd/mm/yy') 
    AND visitDate < TO_DATE('01/02/2007','dd/mm/yy'); 

PROMPT Performing Query 3
SELECT patientFk as patientname FROM
(SELECT v.patientFk as patientFk, COUNT(*) as visitcount 
FROM Visits v 
WHERE v.visitDate >= add_months(TRUNC(SYSDATE), -2) GROUP BY v.patientFk) WHERE visitcount >= 3 GROUP BY patientFk;

PROMPT Performing Query 4
SELECT DISTINCT s.surgeryAddress as surgeryaddress, g.name as gpname FROM Surgery s, Gp g, Visits v WHERE s.name IN 
(SELECT surgeryFk FROM OpeningTimes WHERE closingTime > 64800 GROUP BY surgeryFk) 
AND s.name = g.surgeryFk AND v.gpFk = g.name AND v.conditionFk = 'Type 2 Diabetes';


PROMPT Performing Query 5
SELECT gpFk as gpname,visitcount FROM 
(SELECT gpFk, COUNT(*) as visitcount FROM Visits WHERE visitDate > TO_DATE('31/12/2005','dd/mm/yy') AND visitDate < TO_DATE('01/01/2007','dd/mm/yy') GROUP BY gpFk) 
where visitcount = 
(SELECT MAX(visitcount) FROM (SELECT gpFk, COUNT(*) as visitcount FROM Visits WHERE visitDate > TO_DATE('31/12/2005','dd/mm/yy') AND visitDate < TO_DATE('01/01/2007','dd/mm/yy') GROUP BY gpFk));

COMMIT;

SPOOL OUT;
-- // start "H:\M26CDE_SQL\Course work\14_12_2017\M26CDECourseWork2.sql"
