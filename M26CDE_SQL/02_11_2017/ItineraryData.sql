-- 1. -- is used to make comments. 
-- 2. The 'PROMPT' command is used to display a message to the screen.

PROMPT Populating tables.  Please wait.

--


  CREATE TABLE Itinerary 
      (Ticket_No NUMBER(6) REFERENCES Ticket,
      	Flight_No VARCHAR2(5) REFERENCES Flight,
      	Leg_No NUMBER(2),
      	Flight_Date DATE NOT NULL,
      	Fare_Type CHAR(3) REFERENCES Fares,
	PRIMARY KEY (Ticket_No, Flight_No,Leg_No));

--

INSERT INTO Itinerary  VALUES (100001, 'BD80', 1, '05-AUG-03', 'BUR');
INSERT INTO Itinerary  VALUES (100001, 'BD95', 2, '05-AUG-03', 'BUR');
INSERT INTO Itinerary  VALUES (100002, 'BD80', 1, '05-AUG-03', 'SDR');
INSERT INTO Itinerary  VALUES (100002, 'BD95', 2, '10-AUG-03', 'SDR');
INSERT INTO Itinerary  VALUES (100010, 'BD82', 1, '10-AUG-03', 'SDS');
INSERT INTO Itinerary  VALUES (100011, 'BD54', 1, '12-AUG-03', 'SBS');
INSERT INTO Itinerary  VALUES (100012, 'BD776', 1, '15-AUG-03', 'SDR');
INSERT INTO Itinerary  VALUES (100012, 'BD655', 2, '15-AUG-03', 'APR');
INSERT INTO Itinerary  VALUES (100012, 'BD652', 3, '20-AUG-03', 'APR');
INSERT INTO Itinerary  VALUES (100012, 'BD775', 4, '20-AUG-03', 'SDR');
INSERT INTO Itinerary  VALUES (100020, 'BD772', 1, '20-AUG-03', 'SBS');
INSERT INTO Itinerary  VALUES (100020, 'BD655', 2, '20-AUG-03', 'EUR');
INSERT INTO Itinerary  VALUES (100020, 'BD652', 3, '23-AUG-03', 'EUR');
INSERT INTO Itinerary  VALUES (100021, 'BD412', 1, '02-AUG-03', 'SBS');
INSERT INTO Itinerary  VALUES (100021, 'BD419', 2, '07-AUG-03', 'SBS');
INSERT INTO Itinerary  VALUES (100022, 'BD412', 1, '07-AUG-03', 'BUR');
INSERT INTO Itinerary  VALUES (100022, 'BD419', 2, '08-AUG-03', 'BUR');
INSERT INTO Itinerary  VALUES (100030, 'BD224', 1, '01-SEP-03', 'SBS');
INSERT INTO Itinerary  VALUES (100030, 'BD255', 2, '02-SEP-03', 'EXR');
INSERT INTO Itinerary  VALUES (100030, 'BD256', 3, '06-SEP-03', 'EXR');
INSERT INTO Itinerary  VALUES (100030, 'BD275', 4, '06-SEP-03', 'KFS');
INSERT INTO Itinerary  VALUES (100041, 'BD412', 1, '02-AUG-03', 'KFS');
INSERT INTO Itinerary  VALUES (100051, 'BD582', 1, '07-SEP-03', 'SDR');
INSERT INTO Itinerary  VALUES (100051, 'BD589', 2, '07-SEP-03', 'SDR');
INSERT INTO Itinerary  VALUES (100052, 'BD332', 1, '09-SEP-03', 'SDS');
INSERT INTO Itinerary  VALUES (100100, 'BD51', 1, '24-SEP-03', 'SDR');

INSERT INTO Itinerary  VALUES (100100, 'BD774', 2, '24-SEP-03', 'SDR');
INSERT INTO Itinerary  VALUES (100100, 'BD659', 3, '25-SEP-03', 'PXR');
INSERT INTO Itinerary  VALUES (100100, 'BD658', 4, '01-OCT-03', 'PXR');
INSERT INTO Itinerary  VALUES (100100, 'BD771', 5, '02-OCT-03', 'SDR');
INSERT INTO Itinerary  VALUES (100100, 'BD54', 6, '02-OCT-03', 'SDR');




COMMIT;

PROMPT Population of the table is complete.

