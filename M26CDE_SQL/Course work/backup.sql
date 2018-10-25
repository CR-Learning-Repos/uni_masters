cl scr; -- Clear screen

PROMPT Dropping tables -------------------------------------------------------;

DROP TABLE Visits PURGE;
DROP TABLE PrediscribedItems PURGE;
DROP TABLE Gp PURGE;
DROP TABLE Patients PURGE;
DROP TABLE Surgery PURGE;
DROP TABLE OpeningTimes PURGE;
DROP TABLE MedicalConditions PURGE;
DROP TABLE Conditions PURGE;

PROMPT Table Creations ------------------------------------------------;

CREATE TABLE Conditions{
 name VARCHAR2(20) PRIMARY KEY,
 description VARCHAR2(20),
};

CREATE TABLE Patients
(
 name VARCHAR2(20),
 address VARCHAR2(20),
 dateOfBirth DATE,
 bloodGroup VARCHAR2(1),
 phoneNo VARCHAR2(20),
 CONSTRAINT patientId PRIMARY KEY (name,address,dateOfBirth)
 );



CREATE TABLE Surgery
 (
  name VARCHAR2(20)
  address VARCHAR2(20),
  phoneNo varchar2(15),
  CONSTRAINT surgeryId PRIMARY KEY (name,address)
);


CREATE TABLE OpeningTimes
 (
  surgaryId VARCHAR2(20) REFERENCES Surgery,
  day VARCHAR2(20),
  closingTime DATE,
  openingTime DATE
  CONSTRAINT openingTimeId PRIMARY KEY (surgaryId,day)
 );

CREATE TABLE MedicalConditions{
 conditionId VARCHAR2(20) REFERENCES Conditions,
 patientId VARCHAR2(20) REFERENCES Patients,
 perscriptionId VARCHAR2(20) REFERENCES Perscriptions, 
 CONSTRAINT medicalConditionId PRIMARY KEY (conditionId)
};

CREATE TABLE Perscriptions{
 medicationId VARCHAR2(20) REFERENCES MedicalConditions,
 quantity NUMBER,
 untis VARCHAR2(20),
 instructions VARCHAR2(150),
};


CREATE TABLE Gp
 (
  name VARCHAR2(20) PRIMARY KEY,
  surgeryId VARCHAR2(20) REFERENCES Surgery,
  speciality VARCHAR2(20)
 );

CREATE TABLE Visits
 (
  gpId VARCHAR2(20) REFERENCES Gp, 
  patientId VARCHAR2(20) REFERENCES Patients,
  medicalConditionId VARCHAR2(2) REFERENCES MedicalConditions,
  perscriptionId VARCHAR2(20) REFERENCES Perscriptions,
  CONSTRAINT visit_id PRIMARY KEY (PATIENT_NAME,DOCTOR,VISIT_DATETIME)
 );




//(i)
//PROMPT Insert surgery-------------------------------------------;
//INSERT INTO Condition VALUES('HighStreet', '0121 799 666', TO_DATE('09:00:00','hh24-mi-ss'),TO_DATE('23:00:00','hh24-mi-ss'));
//INSERT INTO Surgery VALUES('LowerStreet','0121 799 667', TO_DATE('09:00:00','hh24-mi-ss'),TO_DATE('23:00:00','hh24-mi-ss')); 

//PROMPT Insert surgery-------------------------------------------;
//INSERT INTO Surgery VALUES('HighStreet', '0121 799 666', TO_DATE('09:00:00','hh24-mi-ss'),TO_DATE('23:00:00','hh24-mi-ss'));
//INSERT INTO Surgery VALUES('LowerStreet','0121 799 667', TO_DATE('09:00:00','hh24-mi-ss'),TO_DATE('23:00:00','hh24-mi-ss')); 

//PROMPT Insert Patients------------------------------------------;
//INSERT INTO Patients VALUES('Chris'    ,'Address A', 'Phone Number A', TO_DATE('01-01-2017','dd-MM-yyyy'), 'A', 'Existing Condition1');
//INSERT INTO Patients VALUES('Iskander' ,'Address B', 'Phone Number B', TO_DATE('01-01-2017','dd-MM-yyyy'), 'A', 'Existing Condition2');
//INSERT INTO Patients VALUES('Dumbei'   ,'Address C', 'Phone Number C', TO_DATE('01-01-2017','dd-MM-yyyy'), 'B', 'Existing Condition3');
//INSERT INTO Patients VALUES('Kane'     ,'Address D', 'Phone Number D', TO_DATE('01-01-2017','dd-MM-yyyy'), 'C', 'Existing Condition4');

//PROMPT Insert Gp------------------------------------------------;
//INSERT INTO Gp VALUES('DR. S. Patel', 'Eyes', 'Surgery A');
//INSERT INTO Gp VALUES('DR B', 'CardioVascular', 'Surgery A');

//PROMPT Insert visits --------------------------------------------------;
//INSERT INTO Visits VALUES('Chris', 'DR. S. Patel', TO_DATE('01-01-2017','dd-MM-yyyy'), 'High blood pressure', '', '');
//INSERT INTO Visits VALUES('Iskander', 'DR. S. Patel', TO_DATE('02-01-2017','dd-MM-yyyy'), 'High blood pressure', '', '')

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

