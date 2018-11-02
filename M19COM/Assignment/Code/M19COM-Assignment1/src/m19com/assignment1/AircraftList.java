/**
 * Interface for a class representing a list of aircraft *** DO NOT MODIFY ***
 * @author Hong Guo
 * @version 1.3 - 1/10/18
 */
public interface AircraftList
{
    /**
     * Add a new aircraft to the list, if not already there
     * @param aircraft  the aircraft to add
     * @return  true if successful, else false
     * throws NullPointerException if aircraft is null
     */
    public boolean add(Aircraft aircraft) throws NullPointerException;
    // POST: if aircraft is null the exception is thrown; else
    // the aircraft is added to our list and true is returned,
    // or false if the aircraft was not added for some reason
    
    
    /**
     * Remove an aircraft from the list
     * @param registration  the registration of the aircraft to remove
     * @return  true if successful, else false
     * @throws NullPointerException if registration is null
     */
    public boolean remove(String registration) throws NullPointerException;
    // POST: if string is null the exception is thrown; othewise
    // if the aircraft is not in our list false is returned, else
    // matching instance of the aircraft is removed and true is returned
    
    
    /**
     * Get an aircraft given the aircraft's registration
     * @param registration  the aircraft's registration string
     * @return  the aircraft if found, else null
     * @throws NullPointerException if registration is null
     */
    public Aircraft get(String registration) throws NullPointerException;
    // POST: if string is null the exception is thrown; otherwise
    // if an aircraft is found matching the specified registration 
    // then that aircraft is returned, else null
    
    
    /**
     * Get the size of the list (number of aircraft)
     * @return  the list size
     */
    public int size();
    // POST: the list size (= number of aircraft) is returned
    
    
    /**
     * Convert the list to a single string "S0\nS1\nS2\n..."
     * @return a printable string formatted as above
     */
    public String toString();
    // POST: a string is returned of the form "S0\nS1\nS2\n..."
    // where each Si is the string representation of ith aircraft
    
    
    /**
     * Sort the list of aircraft into ascending order by registration
     */
    public void sort();
    // POST: the list of aircraft are sorted in ascending order by registration
}
