package m19com.assignment1;

import java.util.*;

/**
 * This class is used to test Operations methods
 *
 * @author (enter your name here)
 * @version (date)
 */
// Usefull links:
// https://www.webucator.com/how-to/how-use-comparable-comparator-java.cfm
public class AircraftOperationsMain {

    public static void main(String[] args) {

        // Print start-of-testing timestamp
        System.out.println("\n*** Begin testing on " + new Date());

        // Create new concrete class implementing AircraftList interface for testing
        // populate it with at least 25 aircraft objects...
        ArrayList<Aircraft> aircraftList = new ArrayList();

        for (int i = 0; i < 25; i++) {
            aircraftList.add(AircraftHelper.genAircraft());
        }
        System.out.println("Created: " + aircraftList.size() + " Aircrafts");

        // Test implemented AircraftList methods add(), remove() and get()
        System.out.println("** Begin testing aircraftlist methods");
        // testing goes here...
        AircraftList operationsList = new Operations();
        Aircraft aircraft = aircraftList.get(0);
        //Testing add()
        System.out.println("\n** Testing add method");
        boolean result = operationsList.add(aircraft);
        PrintTestResultBool("Add aircraft without existing", true, result);
        result = operationsList.add(aircraft);
        PrintTestResultBool("Add aircraft with existing", false, result);
        try {
            operationsList.add(null);
            PrintTestResultException("Add null, throws exception Failed", null);
        } catch (Exception e) {
            PrintTestResultException("Add null, throws exception Passed", e);
        }
        //Testing get
        System.out.println("\n** Testing get method");
        Aircraft testAircraft = operationsList.get(aircraft.getReg());
        PrintTestResultBool("Get aircraft with existing", true, testAircraft != null);
        Aircraft newAircraft = AircraftHelper.genAircraft();
        testAircraft = operationsList.get(newAircraft.getReg());
        PrintTestResultBool("Get aircraft without existing", true, testAircraft == null);
        try {
            operationsList.get(null);
            PrintTestResultException("Get aircraft, throws exception Failed", null);
        } catch (Exception e) {
            PrintTestResultException("Get aircraft, throws exception Passed", e);
        }
        //Testing remove()
        System.out.println("\n** Testing remove method");
        result = operationsList.remove(aircraft.getReg());
        PrintTestResultBool("Remove aircraft, with existing", true, result);
        result = operationsList.remove(aircraft.getReg());
        PrintTestResultBool("Remove aircraft, without existing", false, result);
        try {
            operationsList.remove(null);
            PrintTestResultException("Remove aircraft, throws exception Failed", null);
        } catch (Exception e) {
            PrintTestResultException("Remove aircraft, throws exception Passed", e);
        }
        System.out.println("\n** Finish testing aircraftlist methods");
        // Test implemented AircraftList method sort()               
        System.out.print("\n** Begin testing sort method");
        // testing goes here...
        System.out.println("** Filling list");
        Iterator it = aircraftList.iterator();
        System.out.println("** operations list is empty = " + (operationsList.size() == 0));
        System.out.println("** populating operations list with 25 Aircraft");
        while (it.hasNext()) {
            Object aircraftToAdd = it.next();
            if (aircraftToAdd instanceof Aircraft) {
                operationsList.add((Aircraft) aircraftToAdd);
            }
        }
        System.out.println("** operations list size = " + operationsList.size());
        System.out.println("\n** List before sort: Excpected result - Unsorted");
        System.out.println(operationsList.toString());
        System.out.println("** List after sort: Excpected result - sorted by alphabetical order on flight reg");
        operationsList.sort();
        System.out.println(operationsList.toString());
        System.out.println("\n*** Finish testing sort method");
        System.out.println("\n*** Finish testing on " + new Date());
    }

    public static void PrintTestResultBool(String operation, boolean excpected, boolean actual) {

        System.out.println(String.format("Operation: %s - Excpected: %s - Actual: %s", operation, excpected, actual));
    }

    public static void PrintTestResultException(String operation, Exception e) {
        String message = "No exception thrown";
        if (e != null) {
            message = e.getClass().toString();
        }
        System.out.println(String.format("Operation: %s - Exception: %s ", operation, message));
    }
}
