/**
 * Write your javadoc comments for each methods
 * and generate your API.
 */
 
 /**  
   * A class represents a simple calculator.  
   * @author Hong Guo  * @version 3/10/2018 
   */
public class Person
{
	private String name;
	private int age;
 	private static int population = 0;
	
	//Declare a static method 
	public static int getPopulation()
	{
		return population;
	}
	
	//Default constructor
	public Person()
	{
		name = " ";
		age = 0;
		population++;
	}
	
	//Constructor taking two parameters
	public Person(String nameIn, int ageIn)
	{
		name = nameIn;
		age = ageIn;
		population++;
	}
	  /**
          * sets person name.
          * @param nameIn input name
          * @return void
           */ 
	public void setName(String nameIn)
	{
		name = nameIn;
	}
		  /**
          * get person name
          * @param nameIn input name
          * @return void
           */ 
	public String getName()
	{
		return name;
	}
	 	  /**
          * get persons age
          * @return string 
           */ 
	public int getAge()
	{
		return age;
	}
	 	  /**
          * Computes if person is older
          * @param other input Person
          * @return void
           */ 
	public boolean isOlder(Person other)
	{
		return getAge() > other.getAge();
	}
	 	  /**
          * Returns string rep of person
          * @return string
           */ 
	public String toString()
	{
		String state = "Name: " + getName() + "\n"
				   	 + "Age : " + getAge();
		return state;
	}
}