cl scr;
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
  surgeryAddress VARCHAR2(100) NOT NULL,
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

-- CREATE TABLE MedicalConditions(
--   ID NUMBER NOT NULL,
--   conditionFk char(30) NOT NULL REFERENCES Conditions,
--   patientFk VARCHAR2(20) NOT NULL REFERENCES Patients,
--  PRIMARY KEY (ID));

CREATE TABLE Visits(
  visitDate DATE NOT NULL,
  patientFk VARCHAR2(20) NOT NULL REFERENCES Patients,
  gpFk VARCHAR2(20) NOT NULL REFERENCES Gp,
  conditionFk char(30) NOT NULL REFERENCES Conditions,
  perscriptionFk NUMBER NOT NULL REFERENCES Perscriptions,
  surgeryFk VARCHAR2(20) NOT NULL REFERENCES Surgery,
  CONSTRAINT visitPk PRIMARY KEY (patientFk,visitDate));

PROMPT Inserting Conditions(name,description)--------------------------------------------------;
INSERT INTO Conditions VALUES('Type 1 Diabetes','Low blood suger');
INSERT INTO Conditions VALUES('Type 2 Diabetes','Low blodd sugar');
INSERT INTO Conditions VALUES('High Blood Pressure','');

PROMPT Inserting Patients(name,address,dateOfBirth,bloodGroup,phoneNo)--------------------------------------------------;
INSERT INTO Patients VALUES('tim','1 doverfield cottages',TO_DATE('11-02-1989', 'dd-mm-yy'),'A','0121666');
INSERT INTO Patients VALUES('tom','2 fin lane',TO_DATE('12-08-1980', 'dd-mm-yy'),'C','0121667');
INSERT INTO Patients VALUES('bill','3 charlesvile',TO_DATE('12-08-1990', 'dd-mm-yy'),'B','0121668');
INSERT INTO Patients VALUES('bob','3 charlesvile',TO_DATE('12-08-1990', 'dd-mm-yy'),'B','0121668');
INSERT INTO Patients VALUES('henry','3 charlesvile',TO_DATE('12-08-1990', 'dd-mm-yy'),'B','0121668');
INSERT INTO Patients VALUES('phil','3 charlesvile',TO_DATE('12-08-1990', 'dd-mm-yy'),'B','0121668');

PROMPT Inserting Surgery(name,address,phoneNo)--------------------------------------------------;
INSERT INTO Surgery VALUES('Hertford Surgery' ,'6 camphill road'       ,'0247685867');
INSERT INTO Surgery VALUES('Cov and warwick'  ,'6 binley road coventry','0247686940');

PROMPT Insertig OpeningTimes(ID,Surgery,day,openingTime,closingTime)--------------------------------------------------;
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

PROMPT Insertig Gp(name,surgery,speciality)--------------------------------------------------;
INSERT INTO Gp VALUES('Dr. S. Patel','Hertford Surgery','Blood');
INSERT INTO Gp VALUES('Dr. P. Jones','Cov and warwick','Blood');

PROMPT Insertig Medication(name)--------------------------------------------------;
INSERT INTO Medication VALUES('Glipzide');
INSERT INTO Medication VALUES('Insulin');
INSERT INTO Medication VALUES('Bumetanide');

PROMPT Inserting Perscriptions--------------------------------------------------;
INSERT INTO Perscriptions VALUES(1 ,'Glipzide',100 ,'mg','Take glipizide 30 minutes before a meal');
INSERT INTO Perscriptions VALUES(2 ,'Insulin',50 ,'mg','Two to for a day');
INSERT INTO Perscriptions VALUES(3 ,'Bumetanide',50 ,'mg','Once a week');

PROMPT Insertig Visits--------------------------------------------------;
INSERT INTO Visits VALUES(TO_DATE('03/01/2007','dd/mm/yy'),'tim','Dr. S. Patel','Type 1 Diabetes',2,'Hertford Surgery');
INSERT INTO Visits VALUES(TO_DATE('02/03/2007','dd/mm/yy'),'tim','Dr. S. Patel','High Blood Pressure',3,'Hertford Surgery');
INSERT INTO Visits VALUES(TO_DATE('03/04/2007','dd/mm/yy'),'tim','Dr. S. Patel','Type 1 Diabetes',2,'Hertford Surgery');
INSERT INTO Visits VALUES(TO_DATE('04/05/2007','dd/mm/yy'),'tom','Dr. S. Patel','High Blood Pressure',3,'Hertford Surgery');
INSERT INTO Visits VALUES(TO_DATE('05/02/2007','dd/mm/yy'),'tom','Dr. S. Patel','Type 2 Diabetes',1,'Hertford Surgery');
INSERT INTO Visits VALUES(TO_DATE('02/03/2007','dd/mm/yy'),'tom','Dr. P. Jones','Type 2 Diabetes',1,'Cov and warwick');
INSERT INTO Visits VALUES(TO_DATE('03/10/2017','dd/mm/yy'),'tom','Dr. P. Jones','Type 2 Diabetes',1,'Cov and warwick');
INSERT INTO Visits VALUES(TO_DATE('04/11/2017','dd/mm/yy'),'tom','Dr. S. Patel','Type 2 Diabetes',1,'Hertford Surgery');

INSERT INTO Visits VALUES(TO_DATE('01/01/2007','dd/mm/yy'),'tom','Dr. S. Patel','Type 2 Diabetes',1,'Hertford Surgery');
INSERT INTO Visits VALUES(TO_DATE('02/01/2007','dd/mm/yy'),'bob','Dr. S. Patel','Type 2 Diabetes',1,'Hertford Surgery');
INSERT INTO Visits VALUES(TO_DATE('03/01/2007','dd/mm/yy'),'henry','Dr. S. Patel','Type 1 Diabetes',2,'Hertford Surgery');
INSERT INTO Visits VALUES(TO_DATE('04/01/2007','dd/mm/yy'),'phil','Dr. S. Patel','Type 2 Diabetes',1,'Hertford Surgery');


INSERT INTO Visits VALUES(TO_DATE('01/01/2007','dd/mm/yy'),'bill','Dr. S. Patel','Type 1 Diabetes',2,'Hertford Surgery');
INSERT INTO Visits VALUES(TO_DATE('02/03/2007','dd/mm/yy'),'bill','Dr. P. Jones','Type 1 Diabetes',2,'Cov and warwick');
INSERT INTO Visits VALUES(TO_DATE('03/04/2007','dd/mm/yy'),'bill','Dr. P. Jones','Type 1 Diabetes',2,'Cov and warwick');
INSERT INTO Visits VALUES(TO_DATE('04/12/2017','dd/mm/yy'),'bill','Dr. P. Jones','High Blood Pressure',3,'Cov and warwick');

INSERT INTO Visits VALUES(TO_DATE('04/08/2006','dd/mm/yy'),'bill','Dr. P. Jones','High Blood Pressure',3,'Cov and warwick');
INSERT INTO Visits VALUES(TO_DATE('04/09/2006','dd/mm/yy'),'bill','Dr. P. Jones','High Blood Pressure',3,'Cov and warwick');

INSERT INTO Visits VALUES(TO_DATE('04/01/2006','dd/mm/yy'),'phil','Dr. S. Patel','Type 2 Diabetes',1,'Hertford Surgery');
INSERT INTO Visits VALUES(TO_DATE('09/01/2006','dd/mm/yy'),'phil','Dr. S. Patel','Type 2 Diabetes',1,'Hertford Surgery');
INSERT INTO Visits VALUES(TO_DATE('08/01/2006','dd/mm/yy'),'phil','Dr. S. Patel','Type 2 Diabetes',1,'Hertford Surgery');
PROMPT Performing Query 1--------------------------------------------------;
SELECT name, bloodGroup FROM Patients WHERE name IN 
    (SELECT patientFk FROM Visits WHERE 
    gpFk = (SELECT name FROM Gp WHERE name = 'Dr. S. Patel') AND 
    conditionFk = (SELECT name FROM Conditions WHERE name = 'High Blood Pressure')) ;

PROMPT Performing Query 2--------------------------------------------------;

SELECT patientFk, conditionFk,visitDate FROM Visits WHERE surgeryFk = 'Hertford Surgery' AND perscriptionFk =
    (SELECT ID FROM Perscriptions WHERE medicationFk = 'Glipzide')
    AND visitDate > TO_DATE('31/12/2006','dd/mm/yy') 
    AND visitDate < TO_DATE('01/02/2007','dd/mm/yy'); 

PROMPT Performing Query 3--------------------------------------------------;

SELECT patientFk,conditionFk FROM Visits WHERE visitDate >= add_months(TRUNC(SYSDATE), -2);


PROMPT Performing Query 4--------------------------------------------------;
SELECT DISTINCT s.surgeryAddress, g.name FROM Surgery s, Gp g, Visits v WHERE s.name IN 
(SELECT surgeryFk FROM OpeningTimes WHERE closingTime > 64800 GROUP BY surgeryFk) 
AND s.name = g.surgeryFk AND v.gpFk = g.name AND v.conditionFk = 'Type 2 Diabetes';


PROMPT Performing Query 5--------------------------------------------------;


-- SELECT v.gpFk,COUNT(*) as visitcount FROM Visits v 
-- WHERE v.visitDate > TO_DATE('31/12/2005','dd/mm/yy') 
-- AND v.visitDate < TO_DATE('01/01/2007','dd/mm/yy') GROUP BY v.gpFk;

-- SELECT MAX(visitcount) as maxVisitCount FROM 
-- (SELECT v.gpFk,COUNT(*) as visitcount FROM Visits v 
-- WHERE v.visitDate > TO_DATE('31/12/2005','dd/mm/yy') 
-- AND v.visitDate < TO_DATE('01/01/2007','dd/mm/yy') GROUP BY v.gpFk);

-- SELECT c.gpFk, MAX(c.visitcount) FROM 
-- (SELECT gpFk, COUNT(*) as visitcount FROM Visits 
-- WHERE visitDate > TO_DATE('31/12/2005','dd/mm/yy') 
-- AND visitDate < TO_DATE('01/01/2007','dd/mm/yy') GROUP BY gpFk) GROUP BY gpFk;

SELECT gpname,MAX(visitCount) FROM (SELECT v.gpFk as gpname, COUNT(*) as visitcount FROM Visits v 
WHERE v.visitDate > TO_DATE('31/12/2005','dd/mm/yy') 
AND v.visitDate < TO_DATE('01/01/2007','dd/mm/yy') GROUP BY v.gpFk) GROUP BY gpname;

COMMIT;

-- //"H:\M26CDE_SQL\Course work\10_12_2017\CompositeForeignKeys.sql"
