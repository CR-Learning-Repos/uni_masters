cl scr; -- Clear screen

PROMPT Dropping tables -------------------------------------------------------;

DROP TABLE Visits;
DROP TABLE PrediscribedItems;
DROP TABLE Gp;
DROP TABLE Patients;
DROP TABLE Surgery;

PROMPT Table Creations ------------------------------------------------;

CREATE TABLE Patients
(
 NAME VARCHAR2(20) PRIMARY KEY,
 ADDRESS VARCHAR2(20),
 PHONE_NO VARCHAR2(20),
 DATE_OF_BIRTH DATE,
 BLOOD_GROUP VARCHAR2(20),
 EXISITING_CONDITIONS VARCHAR2(20)
 );

CREATE TABLE Gp
 (
  NAME VARCHAR2(20) PRIMARY KEY,
  SPECIALITY VARCHAR2(15),
  SURGERY VARCHAR2(20)
 );

CREATE TABLE Visits
 (
  PATIENT_NAME VARCHAR2(20) REFERENCES Patients,
  DOCTOR VARCHAR2(20) REFERENCES Gp,
  VISIT_DATETIME DATE,
  REASON VARCHAR2(20),
  DIAGNOSIS VARCHAR2(20),
  MEDICATION VARCHAR2(20),
  CONSTRAINT visit_id PRIMARY KEY (PATIENT_NAME,DOCTOR,VISIT_DATETIME)
 );

CREATE TABLE Surgery
 (
  ADDRESS VARCHAR2(20),
  PHONE_NO varchar2(15),
  OPENTIME DATE,
  CLOSETIME DATE
);


CREATE TABLE PrediscribedItems
 (
  MEDICATION VARCHAR2(20) PRIMARY KEY,
  PATIENTNAME VARCHAR2(20) REFERENCES PATIENTS,
  QUANTITY VARCHAR2(20),
  UNITMEASUREMENT VARCHAR2(20), 
  DOSAGE VARCHAR2(20)
 );


//(i)
PROMPT Insert surgery-------------------------------------------;
INSERT INTO Surgery VALUES('HighStreet', '0121 799 666', TO_DATE('09:00:00','hh24-mi-ss'),TO_DATE('23:00:00','hh24-mi-ss'));
INSERT INTO Surgery VALUES('LowerStreet','0121 799 667', TO_DATE('09:00:00','hh24-mi-ss'),TO_DATE('23:00:00','hh24-mi-ss')); 

PROMPT Insert Patients------------------------------------------;
INSERT INTO Patients VALUES('Chris'    ,'Address A', 'Phone Number A', TO_DATE('01-01-2017','dd-MM-yyyy'), 'A', 'Existing Condition1');
INSERT INTO Patients VALUES('Iskander' ,'Address B', 'Phone Number B', TO_DATE('01-01-2017','dd-MM-yyyy'), 'A', 'Existing Condition2');
INSERT INTO Patients VALUES('Dumbei'   ,'Address C', 'Phone Number C', TO_DATE('01-01-2017','dd-MM-yyyy'), 'B', 'Existing Condition3');
INSERT INTO Patients VALUES('Kane'     ,'Address D', 'Phone Number D', TO_DATE('01-01-2017','dd-MM-yyyy'), 'C', 'Existing Condition4');

PROMPT Insert Gp------------------------------------------------;
INSERT INTO Gp VALUES('DR. S. Patel', 'Eyes', 'Surgery A');
INSERT INTO Gp VALUES('DR B', 'CardioVascular', 'Surgery A');

PROMPT Insert visits --------------------------------------------------;
INSERT INTO Visits VALUES('Chris', 'DR. S. Patel', TO_DATE('01-01-2017','dd-MM-yyyy'), 'High blood pressure', '', '');
INSERT INTO Visits VALUES('Iskander', 'DR. S. Patel', TO_DATE('02-01-2017','dd-MM-yyyy'), 'High blood pressure', '', '')

//(ii)
//INSERT INTO PATIENTS VALUES('Patient B', 'Address B', 'Phone Number A', TO_DATE('01-01-2017','dd-MM-yyyy'), 'A', 'Existing A');
//INSERT INTO VISITS VALUES('Patient B', 'DR. B', TO_DATE('01-01-2007','dd-MM-yyyy'), '', 'Diagnosis B', '');
//INSERT INTO PRESCRIBED_ITEMS VALUES('Glipizide', 'Patient B', '', '', '');
//INSERT INTO GP VALUES('GP A', 'Patient B', '1', 'Hertford Street');
//SELECT A.NAME, B.DIAGNOSIS, C.MEDICATION, D.SURGERY, B.VISIT_DATETIME FROM PATIENTS A, VISITS B, PRESCRIBED_ITEMS C, GP D WHERE A.NAME=B.PATIENT_NAME AND A.NAME=C.PATIENT_NAME AND A.NAME=D.PATIENT_NAME AND C.MEDICATION = 'Glipizide' AND D.SURGERY = 'Hertford Street' AND B. VISIT_DATETIME < TO_DATE('01-02-2007','dd-mm-yyyy');

//(iii)
//INSERT INTO PATIENTS VALUES('Patient C', '', '', '', '', '');
//INSERT INTO VISITS VALUES('Patient C', '', TO_DATE('01-10-2017','dd-MM-yyyy'), '', 'Diagnosis C1', '');
//INSERT INTO VISITS VALUES('Patient C', '', TO_DATE('31-10-2017','dd-MM-yyyy'), '', 'Diagnosis C2', '');
//INSERT INTO VISITS VALUES('Patient C', '', TO_DATE('01-11-2017','dd-MM-yyyy'), '', 'Diagnosis C3', '');
//INSERT INTO VISITS VALUES('Patient C', '', TO_DATE('30-11-2017','dd-MM-yyyy'), '', 'Diagnosis C4', '');
//INSERT INTO PRESCRIBED_ITEMS VALUES('Medication C', 'Patient C', '', '', '');
//INSERT INTO GP VALUES('GP B', 'Patient C', '1', '');
//SELECT A.NAME FROM PATIENTS A, VISITS B, PRESCRIBED_ITEMS C, GP D WHERE A.NAME=B.PATIENT_NAME AND A.NAME=C.PATIENT_NAME AND A.NAME=D.PATIENT_NAME GROUP BY A.NAME HAVING COUNT(B.VISIT_DATETIME) > 3;

//(v)
//INSERT INTO PATIENTS VALUES('Patient D', '', '', '', '', '');
//INSERT INTO VISITS VALUES('Patient D', '', TO_DATE('01-01-2006','dd-MM-yyyy'), '', 'Diagnosis D1', '');
//INSERT INTO VISITS VALUES('Patient D', '', TO_DATE('31-01-2006','dd-MM-yyyy'), '', 'Diagnosis D2', '');
//INSERT INTO PRESCRIBED_ITEMS VALUES('Medication D', 'Patient D', '', '', '');
//INSERT INTO GP VALUES('GP C', 'Patient D', '1', '');


//SELECT * FROM (SELECT D.NAME, MAX(B.VISIT_DATETIME) FROM PATIENTS A, VISITS B, PRESCRIBED_ITEMS C, GP D WHERE A.NAME=B.PATIENT_NAME AND A.NAME=C.PATIENT_NAME AND A.NAME=D.PATIENT_NAME AND TO_CHAR(B.VISIT_DATETIME, 'YYYY') = '2006' GROUP BY D.NAME);

