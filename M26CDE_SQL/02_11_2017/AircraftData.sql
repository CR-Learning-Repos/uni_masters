-- 1. -- is used to make comments. 
-- 2. The 'PROMPT' command is used to display a message to the screen.

PROMPT Populating tables.  Please wait.

--

  CREATE TABLE Aircraft 
      (Aircraft_Type CHAR(3) PRIMARY KEY,
	Aircraft_Description VARCHAR2(40) NOT NULL,
      	Number_Of_Seats NUMBER(4) NOT NULL);

--

INSERT INTO Aircraft VALUES
        ('ATP', 'Advanced Turbo Prop', 48);
INSERT INTO Aircraft VALUES
        ('DC9', 'McDonnel Douglas Jet', 120);
INSERT INTO Aircraft VALUES
        ('737', 'Boeing 737-300 Jet', 300);
        
COMMIT;

PROMPT Population of the table is complete.

