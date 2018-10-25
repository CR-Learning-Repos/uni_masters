-- 1. -- is used to make comments. 
-- 2. The 'PROMPT' command is used to display a message to the screen.

PROMPT Populating tables.  Please wait.

--

  CREATE TABLE Ticket
       (Ticket_No NUMBER(6) PRIMARY KEY,
        Ticket_Date DATE NOT NULL, 
	PID NUMBER(3)  REFERENCES passenger);
--

INSERT INTO Ticket VALUES (100001, '01-AUG-03', 26);
INSERT INTO Ticket VALUES (100002, '25-JULY-03', 28);
INSERT INTO Ticket VALUES (100010, '09-AUG-03', 29);
INSERT INTO Ticket VALUES (100011, '11-AUG-03', 24);
INSERT INTO Ticket VALUES (100012, '01-JUNE-03', 21);
INSERT INTO Ticket VALUES (100020, '15-AUG-03', 30);
INSERT INTO Ticket VALUES (100021, '28-JULY-03', 34);
INSERT INTO Ticket VALUES (100022, '05-JULY-03', 20);

INSERT INTO Ticket VALUES (100030, '30-AUG-03', 94);
INSERT INTO Ticket VALUES (100041, '01-AUG-03', 91);
INSERT INTO Ticket VALUES (100051, '01-SEP-03', 92);
INSERT INTO Ticket VALUES (100052, '01-SEP-03', 93);
INSERT INTO Ticket VALUES (100100, '15-SEP-03', 94);

COMMIT;

PROMPT Population of the table is complete.

