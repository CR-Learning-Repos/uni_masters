
import java.util.Date;
import m19com.assignment1.Aircraft;
import m19com.assignment1.AircraftHelper;
import m19com.assignment1.AircraftList;
import m19com.assignment1.Operations;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rollingc
 */
public class OperationsTest {

    public static void main(String[] args) {
        // Print start-of-testing timestamp
        System.out.println("\n*** Begin testing on " + new Date());
        AircraftList list = new Operations();
        AircraftHelper helper = new AircraftHelper();
        Aircraft aircraft = helper.genAircraft();
        System.out.println("Testing adding aircraft..........");
        list.add(aircraft);
        System.out.println("Aircraft added, size of list: " + list.size());
        System.out.println("Testing get aircraft..........");
        Aircraft sameAircraft = list.get(aircraft.getReg());
        System.out.println("Comparing Regs: Original = " + aircraft.getReg() + " returned = " + sameAircraft.getReg());
        System.out.println("Testing remove aircraft..........");
        boolean removeAircraft = list.remove(aircraft.getReg());
        System.out.println("Aircraft removed: " + removeAircraft);

        // Create new concrete class implementing AircraftList interface for testing
        // populate it with at least 25 aircraft objects...
        // Test implemented AircraftList methods add(), remove() and get()
        System.out.println("\n** Begin testing aircraftlist methods");

        // testing goes here...
        System.out.println("\n** Finish testing aircraftlist methods");

        // Test implemented AircraftList method sort()
        System.out.println("\n** Begin testing sort method");

        // testing goes here...
        System.out.println("\n*** Finish testing sort method");

        System.out.println("\n*** Finish testing on " + new Date());
    }
}
