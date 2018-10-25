-- 1. -- is used to make comments. 
-- 2. The 'PROMPT' command is used to display a message to the screen.

PROMPT Populating tables.  Please wait.

--

  CREATE TABLE tariff 
       	(Route_No NUMBER(3) REFERENCES Route,
       	Fare_Type CHAR(3) REFERENCES Fares,
        Price NUMBER(5,2) NOT NULL,
	PRIMARY KEY (Route_No, Fare_Type));
--


INSERT INTO tariff VALUES (3, 'BUR', 117.00);
INSERT INTO tariff VALUES (3, 'SDR', 158.00);
INSERT INTO tariff VALUES (3, 'SDS', 79.00);
INSERT INTO tariff VALUES (4, 'SDR', 162.00);
INSERT INTO tariff VALUES (4, 'SBS', 49.00);
INSERT INTO tariff VALUES (6, 'BUR', 117.00);
INSERT INTO tariff VALUES (6, 'SBS', 42.00);
INSERT INTO tariff VALUES (6, 'KFS', 53.00);
INSERT INTO tariff VALUES (7, 'SDR', 128.00);
INSERT INTO tariff VALUES (8, 'SDS', 74.00);
INSERT INTO tariff VALUES (9, 'PXR', 153.00);
INSERT INTO tariff VALUES (9, 'EUR', 181.00);
INSERT INTO tariff VALUES (9, 'APR', 95.00);

INSERT INTO tariff VALUES (11, 'KFS', 59.00);
INSERT INTO tariff VALUES (13, 'EXR', 121.00);
INSERT INTO tariff VALUES (14, 'SDR', 110.00);
INSERT INTO tariff VALUES (14, 'SBS', 33.00);
INSERT INTO tariff VALUES (15, 'SBS', 33.00);


COMMIT;

PROMPT Population of the table is complete.

