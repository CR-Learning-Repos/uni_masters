cl scr;
PROMPT -------------------Creating Course table-------------------.

PROMPT -------------------Dropping Tables-------------------.
DROP TABLE Student;
DROP TABLE Course;

--
PROMPT -------------------Creating Tables-------------------.
  CREATE TABLE Course(	courseId CHAR(5),
			title VARCHAR2(30) NOT NULL,
			CONSTRAINT pk_course PRIMARY KEY(courseId));

  CREATE TABLE Student(	sId CHAR(6) PRIMARY KEY,
			sName VARCHAR2(30) NOT NULL,
			cId CHAR(5),
			CONSTRAINT fk_cid FOREIGN KEY(cId) REFERENCES Course(courseId));
PROMPT -------------------Inserting Into Tables-------------------.		
INSERT INTO Course VALUES ('M26','DataBase System');
INSERT INTO Course VALUES ('310CT','Agents');

INSERT INTO Student VALUES ('S1','Smith','M26');
INSERT INTO Student VALUES ('S2','Wang','310CT');
PROMPT -------------------Viewing all columns in tables-------------------.	
SELECT * FROM Course;
SELeCT * FROM Student;
PROMPT -------------------Attempting to delete row from Course-------------------.	
DELETE FROM Course WHERE courseId = 'M26';
PROMPT -------------------Altering Tables, adding new constraint -------------------.	
ALTER TABLE Student DROP CONSTRAINT fk_cid;
ALTER TABLE Student ADD CONSTRAINT fk_cid FOREIGN KEY(cid) REFERENCES Course(courseId) ON DELETE set NULL;
PROMPT -------------------Attempting second attempt at deleting course, with new constrint-------------------.	
DELETE FROM Course WHERE courseId = 'M26';
PROMPT -------------------Viewing all columns in tables-------------------.	
SELECT * FROM Course;
SELECT * FROM Student;


DROP TABLE Accounts;
DROP TABLE SubAccounts;

PROMPT -------------------Accounts and SubAccounts-------------------.
  CREATE TABLE Accounts(accNo NUMBER,
			accType NUMBER,
			accDescr VARCHAR2(20),
			CONSTRAINT pk_Accounts PRIMARY KEY (accNo,accType));
CREATE TABLE SubAccounts(subRef NUMBER PRIMARY KEY,
			subNo NUMBER,
			subType NUMBER,
			subValue NUMBER,
			subDescr VARCHAR2(20),
			CONSTRAINT fk_acc FOREIGN KEY(subNo,subType) REFERENCES Accounts(accNo,acctype) ON DELETE set NULL);

DROP TABLE SubAccounts;

CREATE TABLE SubAccounts(subRef NUMBER PRIMARY KEY,
			subNo NUMBER,
			subType NUMBER,
			subValue NUMBER,
			subDescr VARCHAR2(20));

ALTER TABLE SubAccounts ADD CONSTRAINT fk_acc FOREIGN KEY(subNo,subType) REFERENCES Accounts(accNo,acctype) ON DELETE set NULL;