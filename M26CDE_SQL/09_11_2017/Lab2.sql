
cl scr;
PROMPT Creating Flight table.

DROP TABLE Flight;
DROP TABLE FromLondon;

--

  CREATE TABLE Flight
       (flightId VARCHAR2(20) PRIMARY KEY,
	departure VARCHAR2(20),
        destination VARCHAR2(20), 
	dateOfFlight DATE,
	timeOfFlight DATE);
--

  CREATE TABLE FromLondon
       (flightId VARCHAR2(20) PRIMARY KEY,
	destination VARCHAR2(20));

PROMPT Creation Of Flight table is complete.


INSERT INTO flight VALUES ('SA123','London','Bonn', TO_DATE('12-01-15', 'dd-mm-yy'),TO_DATE('06:45','hh24:mi'));
INSERT INTO flight VALUES ('CA123','Beijing','New York', TO_DATE('21-01-15', 'dd-mm-yy'),TO_DATE('06:30','hh24:mi'));
INSERT INTO flight VALUES ('BA555','London','Accra', TO_DATE('23-01-15', 'dd-mm-yy'),TO_DATE('14:45','hh24:mi'));
INSERT INTO flight VALUES ('JA345','Tokyo','Moscow', TO_DATE('21-01-15', 'dd-mm-yy'),TO_DATE('16:30','hh24:mi'));

SELECT * FROM Flight WHERE dateOfFlight = TO_DATE('21:01:15', 'dd:mm:yy');

UPDATE Flight SET destination = 'Mexico' WHERE flightId = 'CA123';

ALTER TABLE FromLondon ADD ddate DATE;

INSERT INTO FromLondon SELECT flightId,destination,dateOfFlight FROM Flight WHERE departure = 'London';

SELECT * FROM Flight;
SELECT * FROM FromLondon;