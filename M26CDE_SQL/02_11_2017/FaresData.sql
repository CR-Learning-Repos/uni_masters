-- 1. -- is used to make comments. 
-- 2. The 'PROMPT' command is used to display a message to the screen.

PROMPT Populating tables.  Please wait.

--

  CREATE TABLE Fares 
      (Fare_Type CHAR(3) PRIMARY KEY,
	Fare_Description VARCHAR2(25) NOT NULL,
      	Conditions VARCHAR2(40));

--

INSERT INTO Fares VALUES
        ('BUR', 'Business Return', 'Business use only');
INSERT INTO Fares VALUES
        ('SDS', 'Standard Single', null);
INSERT INTO Fares VALUES
        ('SDR', 'Standard Return', null);
INSERT INTO Fares VALUES
        ('EUR', 'Eurobudget Return', 'Available Paris Brussels Amsterdam');
INSERT INTO Fares VALUES
        ('KFS', 'Key Fare Single', null);

INSERT INTO Fares VALUES
        ('SBS', 'Standby Single', null);
INSERT INTO Fares VALUES
        ('EXR', 'Excursion Return', 'Same day return');
INSERT INTO Fares VALUES
        ('PXR', 'Super Key Return', null);
INSERT INTO Fares VALUES
        ('APR', 'Advance Purchase Return', '60 days advance booking');
INSERT INTO Fares VALUES
        ('SXR', 'Superpex Return', '90 days advance booking');
        



COMMIT;

PROMPT Population of the table is complete.

