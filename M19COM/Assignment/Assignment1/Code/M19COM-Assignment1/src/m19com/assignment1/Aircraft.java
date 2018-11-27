/*
 * Class to represent individual aircraft *** DO NOT MODIFY ***
 * @author Hong Guo
 * @version 1.3 - 1/10/18
 */
package m19com.assignment1;

/**
 *
 * @author rollingc
 */
public class Aircraft implements Comparable<Aircraft>
{
    
    private String name;
    private String type;
    private int flightsNo;
    private String registration;  // unique Registration
    
    /**
     * Constructor
     * @param name
     * @param flights
     * @param reg
     */
    public Aircraft(String name, int flights, String reg)
    {
      this.name = name;
      type = "unknow";
      flightsNo = flights;
      registration = reg;
    }
    
    
    /**
     * Get the aircrafts name
     * @return  the name string
     */
    public String getName()
    {
        return name;
    }
    
    
    /**
     * Get the aircraft's type
     * @return  the type string
     */
    public String getType()
    {
        return type;
    }
    
    
    /**
     * Get the aircraft's registration
     * @return  the aircraft's registration string
     */
    public String getReg()
    {
        return registration;
    }
    
    
    /**
     * Get the aircraft's flights
     * @return  the number of flights
     */
    public int getFlights()
    {
        return flightsNo;
    }

    
    /**
     * Set the aircrafts number flights
     * @param flights
     */
    public void setFlights(int flights)
    {
        flightsNo = flights;
    }

    
    /**
     * Implement Comparable based on registration comparisons
     * @param other the other aircraft
     * @return  the result of the registration comparison
     */
    public int compareTo(Aircraft other)
    {
        return getReg().compareTo(other.getReg());
    }
    
    
    /**
     * Override the default equals(), based on registrations
     * @param obj  the other Object
     * @return  true if obj has same registration, else false
     */
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Aircraft)) return false;
        return getReg().equals(((Aircraft)obj).getReg());
    }
    
    
    /**
     * Create a string with the aircrafts registration, type and number of flights
     * concatenated in that order, separated by colons ':'
     * @return  a printable string as above 
     */
    public String toString()
    {
        return registration + " : " + name + " : " + type + " : " + flightsNo;
    }
}
