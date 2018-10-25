-- 1. -- is used to make comments. 
-- 2. The 'PROMPT' command is used to display a message to the screen.

PROMPT Populating tables.  Please wait.

--


  CREATE TABLE Airport
      	(Airport_Code CHAR(4) PRIMARY KEY,
	Airport_Name VARCHAR2(15) NOT NULL,
	Check_In VARCHAR2(50) NOT NULL,
	Reservations VARCHAR2(15),
      	Flight_Info VARCHAR2(15));

--

INSERT INTO Airport VALUES
	('AMST', 'Amsterdam', 'South Hall Departures 20 mins before flight', '06 022 2426', '20 178299');
INSERT INTO Airport VALUES
	('BELF', 'Belfast', 'Desks 18 and 19, 15 mins before flight', '023 2325151', '08494');
INSERT INTO Airport VALUES
	('BIRM', 'Birmingham', 'Check-in desks', null, null);
INSERT INTO Airport VALUES
	('BRUS', 'Brussels', 'Sabena check-in desks 30 mins before flight', '2 511 9030', '2 7207167');
INSERT INTO Airport VALUES
	('EMID', 'East Midlands', 'Check-in 15 mins before flight for heavy bags', '0332 810552', '0332');
INSERT INTO Airport VALUES
	('DUBL', 'Dublin', 'Check-in 20 mins prior to departure', '01 423 555', null);
INSERT INTO Airport VALUES
	('EDIN', 'Edinburgh', 'Gate 1 at least 10 mins before departure', '031 447 1000', null);
INSERT INTO Airport VALUES
	('GLAS', 'Glasgow', 'Desks 60-64/Gate 8 20 mins before departure', '041 204 2436', null);

INSERT INTO Airport VALUES
	('HROW', 'Heathrow', 'Island A/B Terminal-1 20 mins before flight', '081 5895599', '081 745321');
INSERT INTO Airport VALUES
	('LBDR', 'Leeds/Bradford', 'Check-in 15 mins before flight for baggage', '0532 451991', null);
INSERT INTO Airport VALUES
	('LVPL', 'Liverpool', '15 mins heavy baggage, 10 mins hand', '051 494 0200', null);
INSERT INTO Airport VALUES
	('PARI', 'Paris CDG', 'Hall 22 terminal 1 30 mins before flight', '14742 14444', '14862 2280');
INSERT INTO Airport VALUES
	('TEES', 'Teeside', '15 mins heavy baggage, 10 mins hand', '0642 219444', null);

 
                                                                                            

        

COMMIT;

PROMPT Population of the table is complete.

