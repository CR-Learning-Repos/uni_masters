-- 1. -- is used to make comments. 
-- 2. The 'PROMPT' command is used to display a message to the screen.

PROMPT Populating tables.  Please wait.

--


CREATE TABLE Flight
    (Flight_No VARCHAR2(5) PRIMARY KEY,
	From_Airport CHAR(4) REFERENCES Airport,
	To_Airport CHAR(4) REFERENCES Airport,
	Dep_Time DATE NOT NULL,
	Arr_Time DATE NOT NULL,
    	Service VARCHAR2(20) NOT NULL,
	Aircraft_Type CHAR(3) REFERENCES Aircraft,
    	Route_No NUMBER(3) REFERENCES Route);
--

INSERT INTO FLIGHT
	VALUES ('BD80', 'HROW', 'BELF', TO_DATE('2003/01/01:07:25:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:08:40:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Breakfast', '737', 3);
INSERT INTO FLIGHT
	VALUES ('BD82', 'HROW', 'BELF', TO_DATE('2003/01/01:09:30:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:10:45:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Breakfast', '737', 3);
INSERT INTO FLIGHT
	VALUES ('BD91', 'BELF','HROW',  TO_DATE('2003/01/01:17:30:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:18:40:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Dinner', '737', 3);
INSERT INTO FLIGHT
	VALUES ('BD95', 'BELF','HROW',  TO_DATE('2003/01/01:21:20:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:22:30:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Dinner', '737', 3);
INSERT INTO FLIGHT
	VALUES ('BD54', 'HROW', 'EDIN', TO_DATE('2003/01/01:10:40:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:11:55:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Breakfast', '737', 4);
INSERT INTO FLIGHT
	VALUES ('BD51', 'EDIN', 'HROW', TO_DATE('2003/01/01:07:10:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:08:25:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Breakfast', '737', 4);
INSERT INTO FLIGHT
	VALUES ('BD412', 'HROW', 'LBDR', TO_DATE('2003/01/01:08:50:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:09:45:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Breakfast','DC9', 6);
INSERT INTO FLIGHT
	VALUES ('BD414', 'HROW', 'LBDR', TO_DATE('2003/01/01:11:45:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:12:35:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Light Meal', 'DC9', 6);
INSERT INTO FLIGHT
	VALUES ('BD413', 'LBDR', 'HROW', TO_DATE('2003/01/01:10:20:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:11:15:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Light Meal', 'DC9', 6);
INSERT INTO FLIGHT
	VALUES ('BD419', 'LBDR', 'HROW', TO_DATE('2003/01/01:18:45:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:19:40:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Dinner', 'DC9', 6);
INSERT INTO FLIGHT
	VALUES ('BD582', 'HROW', 'LVPL', TO_DATE('2003/01/01:08:10:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:09:00:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Breakfast', 'DC9', 7);
INSERT INTO FLIGHT
	VALUES ('BD589', 'LVPL', 'HROW', TO_DATE('2003/01/01:19:25:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:20:15:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Dinner', 'DC9', 7);
INSERT INTO FLIGHT
	VALUES ('BD332', 'HROW', 'TEES', TO_DATE('2003/01/01:08:35:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:09:35:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Breakfast', 'DC9', 8);
INSERT INTO FLIGHT
	VALUES ('BD651', 'BIRM', 'BRUS', TO_DATE('2003/01/01:07:30:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:09:35:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Breakfast', 'DC9', 9);
INSERT INTO FLIGHT
	VALUES ('BD655', 'BIRM', 'BRUS', TO_DATE('2003/01/01:15:00:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:17:05:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Afternoon Tea', 'DC9', 9);
INSERT INTO FLIGHT
	VALUES ('BD657', 'BIRM', 'BRUS', TO_DATE('2003/01/01:17:30:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:19:35:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Dinner', 'DC9', 9);
INSERT INTO FLIGHT
	VALUES ('BD659', 'BIRM', 'BRUS', TO_DATE('2003/01/01:18:25:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:20:30:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Dinner', 'DC9', 9);
INSERT INTO FLIGHT
	VALUES ('BD652', 'BRUS', 'BIRM', TO_DATE('2003/01/01:10:05:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:10:10:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Breakfast', 'DC9', 9);
INSERT INTO FLIGHT
	VALUES ('BD656', 'BRUS', 'BIRM', TO_DATE('2003/01/01:17:50:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:17:55:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Afternoon Tea', 'DC9', 9);
INSERT INTO FLIGHT
	VALUES ('BD658', 'BRUS', 'BIRM', TO_DATE('2003/01/01:20:05:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:20:10:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Dinner', 'DC9', 9);
INSERT INTO FLIGHT
	VALUES ('BD660', 'BRUS', 'BIRM', TO_DATE('2003/01/01:21:00:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:21:05:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Dinner', 'DC9', 9);
INSERT INTO FLIGHT
	VALUES ('BD275', 'EMID', 'BELF', TO_DATE('2003/01/01:18:00:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:18:55:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Dinner', 'DC9', 11);
INSERT INTO FLIGHT
	VALUES ('BD255', 'EMID', 'PARI', TO_DATE('2003/01/01:12:50:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:14:55:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Lunch', 'DC9', 13);
INSERT INTO FLIGHT
	VALUES ('BD257', 'EMID', 'PARI', TO_DATE('2003/01/01:15:30:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:17:35:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Afternoon Tea', 'DC9', 13);
INSERT INTO FLIGHT
	VALUES ('BD256', 'PARI', 'EMID', TO_DATE('2003/01/01:15:30:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:17:40:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Afternoon Tea', 'DC9', 13);
INSERT INTO FLIGHT
	VALUES ('BD258', 'PARI', 'EMID', TO_DATE('2003/01/01:18:10:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:18:20:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Dinner', 'DC9', 13);
INSERT INTO FLIGHT
	VALUES ('BD772', 'HROW', 'BIRM', TO_DATE('2003/01/01:08:10:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:09:00:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Coffee', 'ATP', 14);
INSERT INTO FLIGHT
	VALUES ('BD774', 'HROW', 'BIRM', TO_DATE('2003/01/01:10:45:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:11:30:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Coffee', 'ATP', 14);
INSERT INTO FLIGHT
	VALUES ('BD776', 'HROW', 'BIRM', TO_DATE('2003/01/01:12:30:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:13:20:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Coffee', 'ATP', 14);
INSERT INTO FLIGHT
	VALUES ('BD778', 'HROW', 'BIRM', TO_DATE('2003/01/01:13:10:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:13:55:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Coffee', 'ATP', 14);
INSERT INTO FLIGHT
	VALUES ('BD780', 'HROW', 'BIRM', TO_DATE('2003/01/01:15:30:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:16:25:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Coffee', 'ATP', 14);
INSERT INTO FLIGHT
	VALUES ('BD782', 'HROW', 'BIRM', TO_DATE('2003/01/01:17:55:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:18:40:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Coffee', 'ATP', 14);
INSERT INTO FLIGHT
	VALUES ('BD771', 'BIRM', 'HROW', TO_DATE('2003/01/01:06:55:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:07:45:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Breakfast', 'ATP', 14);
INSERT INTO FLIGHT
	VALUES ('BD773', 'BIRM', 'HROW', TO_DATE('2003/01/01:09:30:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:10:15:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Coffee', 'ATP', 14);
INSERT INTO FLIGHT
	VALUES ('BD775', 'BIRM', 'HROW', TO_DATE('2003/01/01:12:00:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:12:45:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Coffee', 'ATP', 14);
INSERT INTO FLIGHT
	VALUES ('BD777', 'BIRM', 'HROW', TO_DATE('2003/01/01:14:25:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:15:05:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Coffee', 'ATP', 14);
INSERT INTO FLIGHT
	VALUES ('BD779', 'BIRM', 'HROW', TO_DATE('2003/01/01:16:40:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:17:25:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Coffee', 'ATP', 14);
INSERT INTO FLIGHT
	VALUES ('BD781', 'BIRM', 'HROW', TO_DATE('2003/01/01:20:10:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:21:00:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Coffee', 'ATP', 14);
INSERT INTO FLIGHT
	VALUES ('BD222', 'HROW', 'EMID', TO_DATE('2003/01/01:07:55:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:08:45:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Coffee', 'ATP', 15);
INSERT INTO FLIGHT
	VALUES ('BD224', 'HROW', 'EMID', TO_DATE('2003/01/01:11:00:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:11:50:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Coffee', 'ATP', 15);
INSERT INTO FLIGHT
	VALUES ('BD226', 'HROW', 'EMID', TO_DATE('2003/01/01:14:15:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:15:05:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Coffee', 'ATP', 15);
INSERT INTO FLIGHT
	VALUES ('BD228', 'HROW', 'EMID', TO_DATE('2003/01/01:16:55:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:17:45:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Coffee', 'ATP', 15);
INSERT INTO FLIGHT
	VALUES ('BD230', 'HROW', 'EMID', TO_DATE('2003/01/01:19:45:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:20:35:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Coffee', 'ATP', 15);

INSERT INTO FLIGHT
	VALUES ('BD221', 'EMID', 'HROW', TO_DATE('2003/01/01:06:45:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:07:25:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Breakfast', 'ATP', 15);
INSERT INTO FLIGHT
	VALUES ('BD223', 'EMID', 'HROW', TO_DATE('2003/01/01:12:35:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:13:35:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Coffee', 'ATP', 15);
INSERT INTO FLIGHT
	VALUES ('BD225', 'EMID', 'HROW', TO_DATE('2003/01/01:12:35:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:13:35:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Coffee', 'ATP', 15);
INSERT INTO FLIGHT
	VALUES ('BD227', 'EMID', 'HROW', TO_DATE('2003/01/01:15:35:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:16:25:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Coffee', 'ATP', 15);
INSERT INTO FLIGHT
	VALUES ('BD229', 'EMID', 'HROW', TO_DATE('2003/01/01:18:05:00','yyyy/mm/dd:hh24:mi:ss'), 
	TO_DATE('2003/01/01:18:55:00', 'yyyy/mm/dd:hh24:mi:ss'), 'Coffee', 'ATP', 15);



 
                                                                                            

        

COMMIT;

PROMPT Population of the table is complete.

