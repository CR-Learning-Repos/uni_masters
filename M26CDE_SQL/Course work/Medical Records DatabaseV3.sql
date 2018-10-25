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
PROMPT Table Creations ------------------------------------------------;

CREATE TABLE Conditions(
 conditionPk char(10) PRIMARY KEY,
 name VARCHAR2(20) NOT NULL,
 description VARCHAR2(20) NOT NULL
);

CREATE TABLE Patients
(
 patientPk CHAR(10) NOT NULL PRIMARY KEY,
 name VARCHAR2(20) NOT NULL,
 address VARCHAR2(100) NOT NULL,
 dateOfBirth DATE NOT NULL,
 bloodGroup VARCHAR2(1) NOT NULL,
 phoneNo VARCHAR2(20)
 );

CREATE TABLE Surgery
 (
  SurgeryPk CHAR(10) NOT NULL PRIMARY KEY,
  surgeryName VARCHAR2(20) NOT NULL,
  surgeryAddress VARCHAR2(100) NOT NULL,
  phoneNo varchar2(10) NOT NULL
);

CREATE TABLE OpeningTimes
 (
  surgeryFk CHAR(10) REFERENCES Surgery,
  day VARCHAR2(20),
  closingTime NUMBER NOT NULL,
  openingTime NUMBER NOT NULL,
  CONSTRAINT openingTimePk PRIMARY KEY (surgeryFk ,day)
 );



CREATE TABLE Perscriptions(
 perscriptionPk CHAR(10) NOT NULL PRIMARY KEY,
 name VARCHAR2(20),
 conditionFk CHAR(10) REFERENCES Conditions,
 quantity NUMBER,
 untis VARCHAR2(20),
 instructions VARCHAR2(150)
);

CREATE TABLE MedicalConditions(
 conditionFk CHAR(10) REFERENCES Conditions NOT NULL,
 patientFk CHAR(10) REFERENCES  Patients NOT NULL,
 perscriptionFk CHAR(10) REFERENCES Perscriptions NOT NULL,
 CONSTRAINT medicalConditionPk PRIMARY KEY (conditionFk,patientFk)
);

CREATE TABLE Gp
 (
  gpPk CHAR(10) PRIMARY  KEY NOT NULL,
  name VARCHAR2(20) NOT NULL,
  surgeryFK CHAR(10) REFERENCES Surgery,
  speciality VARCHAR2(20)
 );

CREATE TABLE Visits
 (
  gpFk CHAR(10) REFERENCES Gp, 
  conditionFk CHAR(10) REFERENCES Conditions NOT NULL,
  patientFk CHAR(10) REFERENCES  Patients NOT NULL,
  perscriptionFk CHAR(10) REFERENCES Perscriptions,
  visitDate DATE NOT NULL,
  CONSTRAINT visitPk PRIMARY KEY (gpFk,patientFk,visitDate)
 );



PROMPT Inserting Conditions--------------------------------------------------;
INSERT INTO Conditions VALUES('1','High Blood Pressure','above 140/90');
INSERT INTO Conditions VALUES('2','Low Blood Pressure','under 140/90');

PROMPT Inserting Patients--------------------------------------------------;
INSERT INTO Patients VALUES('1','chris','1 Cloverfield cottages',TO_DATE('11-02-1989', 'dd-mm-yy'),'A','0121666');
INSERT INTO Patients VALUES('2','dumebi','2 fin lane',TO_DATE('12-08-1980', 'dd-mm-yy'),'C','0121667');
INSERT INTO Patients VALUES('3','iskander','3 charlesvile',TO_DATE('12-08-1990', 'dd-mm-yy'),'B','0121668');
INSERT INTO Patients VALUES('4','kane','4 aberdeen cottages',TO_DATE('12-08-1990', 'dd-mm-yy'),'A','0121669');

PROMPT Inserting Surgery--------------------------------------------------;
INSERT INTO Surgery VALUES('1','Camphill surgery' ,'6 camphill road'       ,'0247685867');
INSERT INTO Surgery VALUES('2','Cov and warwick'  ,'6 binley road coventry','0247686940');

PROMPT Inserting Perscriptions--------------------------------------------------;
INSERT INTO Perscriptions VALUES('1' ,'Bumetanide','1' ,'5' ,'ml' ,'take once a day for 2 weeks');
INSERT INTO Perscriptions VALUES('2' ,'midodrine' ,'2' ,'5' ,'ml' ,'take once a day for 2 weeks');

PROMPT Inserting Medical Conditions--------------------------------------------------;
INSERT INTO MedicalConditions VALUES('1','1','2');
INSERT INTO MedicalConditions VALUES('2','2','1');

PROMPT Insertig OpeningTimes--------------------------------------------------;
INSERT INTO OpeningTimes VALUES('1','Monday'   ,'21600','79200');
INSERT INTO OpeningTimes VALUES('1','Tuesday'  ,'21600','79200');
INSERT INTO OpeningTimes VALUES('1','Wednesday','21600','79200');
INSERT INTO OpeningTimes VALUES('1','Thrusday' ,'21600','79200');
INSERT INTO OpeningTimes VALUES('1','Friday'   ,'21600','79200');

PROMPT Insertig Gp--------------------------------------------------;

COMMIT;

//"H:\M26CDE_SQL\Course work\Medical Records DatabaseV3.sql"