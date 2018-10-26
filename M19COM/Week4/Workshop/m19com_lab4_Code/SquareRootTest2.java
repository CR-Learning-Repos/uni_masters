
// Example_3 for m19com Lab4
// Demonstrate method declaration that throws a checked exception 
public class SquareRootTest2 
{

	public double squareRoot(double x) throws NonPositiveException 
	{ 
   	// Postcondition: If x <= 0, throws NonPositiveException, else 
   	// returns an approximation to the square root of x

      if(x <= 0) 
      	throw new NonPositiveException("Invalid input: value <= 0");
         // Notice here that we called the second constructor of 
         // NonPositiveException. We include the class and method name
        	// in the message so that we can see from where the exception
         // is thrown.

      double sr = x/2.0; 
      for(int i = 1; i <= 6; i++) 
      	sr = sr-((sr*sr-x)/(2.0*sr));
      
      return sr; 
	}

	public static void main(String args[]) 
	{      
		SquareRootTest2 tester2 = new SquareRootTest2();
		
		// The trace statements here are used to help show the behaviour of 
      // exception handling code
      System.out.print("One\n");
      try {
			System.out.print("Two\n");
         System.out.println("The squareroot of 12.3 is " + tester2.squareRoot(12.3));
         System.out.print("Three\n");
      }
      catch (NonPositiveException e) {
         System.out.print("Four\n");
         System.out.println(e);
         System.out.print("Five\n");
      }
		
      System.out.print("Six\n");    
      try {
			System.out.print("Seven\n");    
         System.out.println("The squareroot of -32.1 is " + tester2.squareRoot(-32.1));
         System.out.print("Eight\n");    
      }
      catch (NonPositiveException e) {
         System.out.print("Nine\n");    
         System.out.println(e);
         System.out.print("Ten\n");    
      }
      
		System.out.print("Eleven\n");    
    }
}

