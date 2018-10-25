cl scr;
PROMPT Dropping tables -------------------------------------------------------;
DROP TABLE Visits;
DROP TABLE Gp;
DROP TABLE OpeningTimes;
DROP TABLE MedicalConditions;
DROP TABLE Perscriptions;
DROP TABLE Surgery;
DROP TABLE Patients;
DROP TABLE Conditions;
DROP TABLE Medication;

PROMPT Table Creations ------------------------------------------------;
CREATE TABLE Conditions(
 ID NUMBER NOT NULL,
 name char(30),
 description VARCHAR2(100) NOT NULL,
 PRIMARY KEY (ID));

CREATE TABLE Patients(
 ID NUMBER NOT NULL,
 name VARCHAR2(20) NOT NULL,
 address VARCHAR2(100) NOT NULL,
 dateOfBirth DATE NOT NULL,
 bloodGroup VARCHAR2(1) NOT NULL,
 phoneNo VARCHAR2(20),
 PRIMARY KEY(ID));

CREATE TABLE Surgery(
  ID NUMBER NOT NULL,
  surgeryName VARCHAR2(20) NOT NULL,
  surgeryAddress VARCHAR2(100) NOT NULL,
  phoneNo varchar2(10) NOT NULL,
  PRIMARY KEY (ID));

CREATE TABLE OpeningTimes(
  ID NUMBER NOT NULL,
  surgeryFk NUMBER NOT NULL REFERENCES Surgery,
  day VARCHAR2(20),
  closingTime NUMBER NOT NULL,
  openingTime NUMBER NOT NULL,
  PRIMARY KEY (ID));

CREATE TABLE Gp (  
  ID NUMBER NOT NULL,
  name VARCHAR2(20) NOT NULL,
  surgeryFk NUMBER NOT NULL REFERENCES Surgery,
  speciality VARCHAR2(20),
  PRIMARY KEY (ID));

CREATE TABLE Medication(
  ID NUMBER NOT NULL,
  name VARCHAR2(20) NOT NULL,
  PRIMARY KEY (ID));

CREATE TABLE Perscriptions(
  ID NUMBER NOT NULL,
  medicationFk NUMBER NOT NULL REFERENCES Medication,
  quantity NUMBER,
  units VARCHAR2(20),
  instructions VARCHAR2(150),
  PRIMARY KEY (ID));

CREATE TABLE MedicalConditions(
  conditionFk NUMBER NOT NULL REFERENCES Conditions,
  patientFk NUMBER NOT NULL REFERENCES Patients,
  perscriptionFk NUMBER NOT NULL REFERENCES Perscriptions,
  CONSTRAINT ID PRIMARY KEY (conditionFk,patientFk,perscriptionFk));

CREATE TABLE Visits(
  visitDate DATE NOT NULL,
  patientFk NUMBER NOT NULL REFERENCES Patients,
  gpFk NUMBER NOT NULL REFERENCES Gp,
  medicalConditionFk NUMBER NOT NULL REFERENCES MedicalConditions,
  CONSTRAINT visitPk PRIMARY KEY (patientFk,visitDate));

PROMPT Inserting Conditions--------------------------------------------------;
INSERT INTO Conditions VALUES(1,'Type 1 Diabetes','Low blood suger');
INSERT INTO Conditions VALUES(2,'Type 2 Diabetes','Low blodd sugar');

PROMPT Inserting Patients--------------------------------------------------;
INSERT INTO Patients VALUES(1,'tim','1 doverfield cottages',TO_DATE('11-02-1989', 'dd-mm-yy'),'A','0121666');
INSERT INTO Patients VALUES(2,'tom','2 fin lane',TO_DATE('12-08-1980', 'dd-mm-yy'),'C','0121667');
INSERT INTO Patients VALUES(3,'bill','3 charlesvile',TO_DATE('12-08-1990', 'dd-mm-yy'),'B','0121668');
INSERT INTO Patients VALUES(4,'benkane','4 aberdeen cottages',TO_DATE('12-08-1990', 'dd-mm-yy'),'A','0121669');

PROMPT Inserting Surgery--------------------------------------------------;
INSERT INTO Surgery VALUES(1,'Hertford Street' ,'6 camphill road'       ,'0247685867');
INSERT INTO Surgery VALUES(2,'Cov and warwick'  ,'6 binley road coventry','0247686940');

PROMPT Insertig OpeningTimes--------------------------------------------------;
INSERT INTO OpeningTimes VALUES(1,1,'Monday'   ,'21600','79200');
INSERT INTO OpeningTimes VALUES(2,1,'Tuesday'  ,'21600','79200');
INSERT INTO OpeningTimes VALUES(3,1,'Wednesday','21600','79200');
INSERT INTO OpeningTimes VALUES(4,1,'Thrusday' ,'21600','79200');
INSERT INTO OpeningTimes VALUES(5,1,'Friday'   ,'21600','79200');
INSERT INTO OpeningTimes VALUES(6,2,'Monday'   ,'21600','79200');
INSERT INTO OpeningTimes VALUES(7,2,'Tuesday'  ,'21600','79200');
INSERT INTO OpeningTimes VALUES(8,2,'Wednesday','21600','79200');
INSERT INTO OpeningTimes VALUES(9,2,'Thrusday' ,'21600','79200');
INSERT INTO OpeningTimes VALUES(10,2,'Friday'   ,'21600','79200');

PROMPT Insertig Gp--------------------------------------------------;
INSERT INTO Gp VALUES(1,'Dr. S. Patel',1,'Blood');
INSERT INTO Gp VALUES(2,'Dr. P. Jones',2,'Blood');

PROMPT Insertig Medication--------------------------------------------------;
INSERT INTO Medication VALUES(1,'Glipzide');
INSERT INTO Medication VALUES(2,'Insulin');

PROMPT Inserting Perscriptions--------------------------------------------------;
INSERT INTO Perscriptions VALUES(1 ,1,100 ,'mg','Take glipizide 30 minutes before a meal');
INSERT INTO Perscriptions VALUES(2 ,2,50 ,'mg','Two to for a day');

PROMPT Inserting Medical Conditions--------------------------------------------------;
INSERT INTO MedicalConditions VALUES(2,1,1);
INSERT INTO MedicalConditions VALUES(1,2,2);
INSERT INTO MedicalConditions VALUES(2,3,1);
INSERT INTO MedicalConditions VALUES(1,4,2);

PROMPT Insertig Visits--------------------------------------------------;
INSERT INTO Visits VALUES(TO_DATE('01/02/2007','dd/mm/yy'),1,1,2);
INSERT INTO Visits VALUES(TO_DATE('02/03/2007','dd/mm/yy'),1,1,2);
INSERT INTO Visits VALUES(TO_DATE('03/04/2007','dd/mm/yy'),1,1,2);
INSERT INTO Visits VALUES(TO_DATE('04/05/2007','dd/mm/yy'),1,1,2);

INSERT INTO Visits VALUES(TO_DATE('01/02/2007','dd/mm/yy'),2,1,1);
INSERT INTO Visits VALUES(TO_DATE('02/03/2007','dd/mm/yy'),2,2,1);
INSERT INTO Visits VALUES(TO_DATE('03/04/2007','dd/mm/yy'),2,2,1);
INSERT INTO Visits VALUES(TO_DATE('04/05/2007','dd/mm/yy'),2,1,1);

PROMPT Performing Quries--------------------------------------------------;
SELECT name, bloodGroup FROM Patients WHERE ID = 
    (SELECT patientFk FROM Visits WHERE gpFk = 
        (SELECT ID FROM Gp WHERE name = 'Dr. S. Patel'));

COMMIT;

-- //"H:\M26CDE_SQL\Course work\10_12_2017\CompositeForeignKeys.sql"
