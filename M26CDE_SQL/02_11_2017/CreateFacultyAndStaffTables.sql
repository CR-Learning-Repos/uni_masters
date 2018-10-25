

PROMPT Creating Faculty table.

  CREATE TABLE Faculty
       (facultyid VARCHAR2(6) PRIMARY KEY,
	facultyname VARCHAR2(15),
        NoOfStaff NUMBER check(NoOfStaff  >= 1));

PROMPT Creating Staff table.
--
  CREATE TABLE Staff
       (staffid VARCHAR2(6) PRIMARY KEY,
	staffname VARCHAR2(15),
        staffAGE DATE, 
	staffFaculty VARCHAR2(6),
	CONSTRAINT fk_id FOREIGN KEY (staffFaculty) REFERENCES Faculty(facultyid));
--
-- INSERT INTO Staff VALUES (100001, 'Chris Rolls', 26, 'testing123');


COMMIT;

PROMPT Population of the table is complete.

