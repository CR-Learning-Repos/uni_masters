//A Client class demonstrate creating and using objects of Person 
public class TestPerson
{
   public static void main(String args[])
   {	
		//Declare reference variable of type Person
	 	Person p1; 
      int ARRAYLENGTH = 4;
      Person[] array = new Person[ARRAYLENGTH];
		//Create object & store it in reference p1
		p1 = new Person("David Backham", 	32); 
		array[0] = p1;
		//Invock static method
		System.out.println("Population is 1: " + Person.getPopulation());
		//Declare & create object in a signal step
		Person p2 = new Person("Emma Thompson", 24);
      array[1] = p2;

      Person p3 = new Person("Big Jo", 21);
      array[2] = p3;

      Person p4 = new Person("Smml Bill Thompson", 34);
      array[3] = p4;

		//Access object’s data and methods
		int myAge = p1.getAge();
		System.out.println(p2.toString());
		System.out.println("P1 is older: " + p1.isOlder(p2));
		
		//Check population using class name
		System.out.println("Population is 2: " + Person.getPopulation());
		
		//Create object using the default constructor
		Person p = new Person();
		
		//Check population using object
		System.out.println("Population is 3: " + p.getPopulation());
		
		//Display the 3rd instance
		System.out.println("The 3rd person details:\n " + p);	
      
      int totalAge = 0;
      for(int a = 0; a < ARRAYLENGTH; a++){
         totalAge += array[a].getAge();      
      }
      
      	
         System.out.println("Total Age : " + totalAge);
         System.out.println("Avg : " + (totalAge/ ARRAYLENGTH));

         
	}
}