-- 1. -- is used to make comments. 
-- 2. The 'PROMPT' command is used to display a message to the screen.

PROMPT Removing tables from the database.  Please wait.

--
-- The tables must be removed in the following order.

Drop table Itinerary;
Drop table Flight;
Drop table tariff;
Drop table Route;
Drop table Fares;
Drop table Ticket;
Drop table passenger;
Drop table Airport;
Drop table Aircraft;

--


PROMPT Removal of the tables is complete.