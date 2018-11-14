/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m19com.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 *
 * @author rollingc
 */
public class Operations implements AircraftList {

    private ArrayList<Aircraft> _airCraftList = new ArrayList<Aircraft>();

    public ArrayList<Aircraft> toList() {
        return _airCraftList;
    }

    /**
     * Add a new aircraft to the list, if not already there
     *
     * @param aircraft the aircraft to add
     * @return true if successful, else false
     * @throws NullPointerException if aircraft is null
     */
    public boolean add(Aircraft aircraft) throws NullPointerException {
        if (aircraft == null) {
            throw new NullPointerException();
        }
        if (!this.Excisits(aircraft)) {
            _airCraftList.add(aircraft);
            return true;
        } else {
            return false;
        }
    }
    // POST: if aircraft is null the exception is thrown; else
    // the aircraft is added to our list and true is returned,
    // or false if the aircraft was not added for some reason

    /**
     * Remove an aircraft from the list
     *
     * @param registration the registration of the aircraft to remove
     * @return true if successful, else false
     * @throws NullPointerException if registration is null
     */
    public boolean remove(String registration) throws NullPointerException {
        if (registration == null) {
            throw new NullPointerException();
        }
        Aircraft aircraft = this.get(registration);
        if (aircraft != null) {
            _airCraftList.remove(aircraft);
            return true;
        }
        return false;
    }
    // POST: if string is null the exception is thrown; othewise
    // if the aircraft is not in our list false is returned, else
    // matching instance of the aircraft is removed and true is returned

    /**
     * Get an aircraft given the aircraft's registration
     *
     * @param registration the aircraft's registration string
     * @return the aircraft if found, else null
     * @throws NullPointerException if registration is null
     */
    public Aircraft get(String registration) throws NullPointerException {

        if (registration == null) {
            throw new NullPointerException("Aircraft cannot be found");
        }

        for (Aircraft aircraft : this._airCraftList) {
            if (aircraft.getReg() == registration) {
                return aircraft;
            }
        }
        return null;
    }
    // POST: if string is null the exception is thrown; otherwise
    // if an aircraft is found matching the specified registration 
    // then that aircraft is returned, else null

    /**
     * Get the size of the list (number of aircraft)
     *
     * @return the list size
     */
    public int size() {
        return this._airCraftList.size();
    }
    // POST: the list size (= number of aircraft) is returned

    /**
     * Convert the list to a single string "S0\nS1\nS2\n..."
     *
     * @return a printable string formatted as above
     */
    public String toString() {
        String returnString = "";

        for (Aircraft aircraft : this._airCraftList) {
            returnString += aircraft.toString() + "/\n";
        }

        return returnString;
    }
    // POST: a string is returned of the form "S0\nS1\nS2\n..."
    // where each Si is the string representation of ith aircraft

    /**
     * Sort the list of aircraft into ascending order by registration
     */
    public void sort() {
        this._airCraftList.sort(Comparator.comparing((item) -> item.getReg()));
    }
    // POST: the list of aircraft are sorted in ascending order by registration

        /**
     * Check aircraft excisits
     *
     * @param registration the registration of the aircraft to remove
     * @return true if successful, else false
     * @throws NullPointerException if registration is null
     */
    private boolean Excisits(Aircraft aircraft) {
        for (Aircraft item : this._airCraftList) {
            if (item.getReg() == aircraft.getReg()) {
                return true;
            }
        }
        return false;
    }
}
