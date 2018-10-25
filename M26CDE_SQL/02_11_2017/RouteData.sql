-- 1. -- is used to make comments. 
-- 2. The 'PROMPT' command is used to display a message to the screen.

PROMPT Populating tables.  Please wait.

--


  CREATE TABLE Route 
       (Route_No NUMBER(3) PRIMARY KEY,
        Route_Description VARCHAR2(30) NOT NULL);
--

INSERT INTO Route VALUES (3, 'Heathrow-Belfast');
INSERT INTO Route VALUES (4, 'Heathrow-Edinburgh');
INSERT INTO Route VALUES (6, 'Heathrow-Leeds/Bradford');
INSERT INTO Route VALUES (7, 'Heathrow-Liverpool');
INSERT INTO Route VALUES (8, 'Heathrow-Teeside');

INSERT INTO Route VALUES (9, 'Birmingham-Brussels');
INSERT INTO Route VALUES (11, 'East Midlands-Belfast');
INSERT INTO Route VALUES (13, 'East Midlands-Paris CDG');
INSERT INTO Route VALUES (14, 'Heathrow-Birmingham');
INSERT INTO Route VALUES (15, 'Heathrow-East Midlands');



COMMIT;

PROMPT Population of the table is complete.

