
// Example_2 for m19com Lab4
// Demonstrate method contract specification
public class SquareRootTest1 
{

	public double squareRoot(double x) 
	{ 
		// Precondition: x > 0 
   	// Postcondition: Returns an approximation to the squareroot of x

   	double sr = x/2.0; 
   	for(int i = 1; i <= 6; i++) 
			sr = sr-((sr*sr-x)/(2.0*sr));
      
      return sr; 
   }

	public static void main(String args[]) 
	{	
		
      SquareRootTest1 tester = new SquareRootTest1();
		
      // The following should work fine...
      System.out.println("The squareroot of 12.3 is " + tester.squareRoot(12.3));

      // The following breaks the contract...
      System.out.println("The squareroot of -32.1 is " + tester.squareRoot(-32.1));
   }
}
