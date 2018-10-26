// Example_1 for m19com Lab4
// Demonstrate postcondition specification and testing
public class Max3Test 
{
	public int max3(int x, int y, int z) 
	{
		// Postcondition: Returns the maximum of x, y and z

		if(x > y)
		{
			if(z > x) return z;
         else return x;
		}
		else 
			if(z > y) return z;
         else return y;
    }


    public static void main(String args[]) 
	 {
	 		// Construct object using default constructor 
	 		Max3Test maxTester = new Max3Test();
      
        // Some example method calls ...
        System.out.println("The maximum of -5, 7, 3 is " + maxTester.max3(-5,7,3));
        System.out.println("The maximum of 5, 2, 18 is " + maxTester.max3(5,2,18));
        System.out.println("The maximum of 5, -2, 5 is " + maxTester.max3(5,-2,5));
    }
}
