package m19com.assignment1;

import java.util.*;

/**
 * This class is used to test Operations methods
 * @author (enter your name here)
 * @version (date)
 */


// Usefull links:
// https://www.webucator.com/how-to/how-use-comparable-comparator-java.cfm
public class AircraftOperationsMain
{
    public static void main(String[] args)
    {    
        // Print start-of-testing timestamp
        System.out.println("\n*** Begin testing on " + new Date());
                
        // Create new concrete class implementing AircraftList interface for testing
        // populate it with at least 25 aircraft objects...
        ArrayList<Aircraft> aircraftList = new ArrayList<Aircraft>();
        
        for(int i =0; i < 25; i++){
            aircraftList.add(AircraftHelper.genAircraft());
        }
        
        Iterator it = aircraftList.iterator();
        
        
        System.out.println("Created: " + aircraftList.size() + " Aircrafts");
        // Test implemented AircraftList methods add(), remove() and get()
        
        AircraftList operationsList = new Operations();
        
        for (Aircraft aircraft : aircraftList) {
            operationsList.add(aircraft);
            }  
        System.out.println("Added " + operationsList.size() + " Aircrafts to operations list");

        System.out.println("\n** Begin testing aircraftlist methods");        
        // testing goes here...
        System.out.println("Current list order:");
        for (Aircraft aircraft : operationsList.toList()) {
            System.out.println("Aircraft: Name = " + aircraft.getName() + ". Reg = " + aircraft.getReg() + ". Flights = " + aircraft.getFlights());
            }        
        operationsList.sort();
        System.out.println("Sorted list order: ");
        for (Aircraft aircraft : operationsList.toList()) {
            System.out.println("Aircraft: Name = " + aircraft.getName() + ". Reg = " + aircraft.getReg() + ". Flights = " + aircraft.getFlights());
            } 
        
        
        
        System.out.println("\n** Finish testing aircraftlist methods");
        
        
        // Test implemented AircraftList method sort()
        System.out.println("\n** Begin testing sort method");
        
        // testing goes here...

        System.out.println("\n*** Finish testing sort method");
        
        
        System.out.println("\n*** Finish testing on " + new Date());
    }
}
