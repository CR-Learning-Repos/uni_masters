/**
 * Write your javadoc comments for each methods
 * and generate your API.
 */
 
 /**  
   * A class represents a simple calculator.  
   * @author Hong Guo  * @version 3/10/2018 
   */
public class Person implements Comparable<Person>
{
	private String name;
	private int age;
 	private static int population = 0;
	
   /**
   Compares this object with the given object for order.
   @param other the object to be compared
   @return a negative, zero, or a positive value as this object is
    less than, equal to, or greater than the other object
    */
   
   public int compareTo(Person p )
   {   
      if(p.name == this.name && p.age ==this.age){return 0;}
      else{return 1;}
   }
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
   
   
   public static void main(String[] args)
   {
   
      Person p1 = new Person();
      p1.setName("Bill");
      Person p2 = new Person();
      p1.setName("Bob");
   
      System.out.println(p1.compareTo(p2));
      System.out.println(p1.compareTo(p1));
   }
   
}