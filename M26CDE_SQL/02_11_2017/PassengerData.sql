-- 1. -- is used to make comments. 
-- 2. The 'PROMPT' command is used to display a message to the screen.

PROMPT Populating tables.  Please wait.

--


  CREATE TABLE passenger 
       (PID NUMBER(3) primary key,
        Name VARCHAR2(20) NOT NULL,
        Address VARCHAR2(40) NOT NULL,
        Telephone_No VARCHAR2(15));


--

INSERT INTO passenger VALUES (26, 'J Millar', 'Englewood Cliffs', '061 343 881');
INSERT INTO passenger VALUES (28, 'J D Ullman', '1 Microsoft Way', null);
INSERT INTO passenger VALUES (29, 'A Smithson', '16 Bedford St', '071 577 890');
INSERT INTO passenger VALUES (30, 'D Etheridge', '4 Marylands Avenue', null);
INSERT INTO passenger VALUES (34, 'E Simon', '8 Cherry Street', null);
INSERT INTO passenger VALUES (10, 'D N Hamer', '1 St Paul''s Churchyard', null);
INSERT INTO passenger VALUES (20, 'D E Avison', '5 Chancery Lane', null);
INSERT INTO passenger VALUES (21, 'G B Davis', '25 Allenby Road', null);
INSERT INTO passenger VALUES (24, 'C Evans', '63 Kew Green', null);
        
INSERT INTO passenger VALUES (90, 'A N Smith', '81 Digby Crescent', '071 321 456');
INSERT INTO passenger VALUES (91, 'T Pittman', 'The Little House', null);
INSERT INTO passenger VALUES (92, 'J Peters', '31 Lucas Road', null);
INSERT INTO passenger VALUES (93, 'K E Kendall', '11 Rosedale Avenue', null);
INSERT INTO passenger VALUES (94, 'R H Miller', '155 Kingston Road', '0638 4672');



COMMIT;

PROMPT Population of the table is complete.

