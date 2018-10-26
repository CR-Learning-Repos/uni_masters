// Exercise_1 for m19com Lab4
// Write the implementation according to contract
public class ArraySumTest 
{

	public int sum(int[] a)  throws IllegalArgumentException, NullPointerException
	{
    	// Precondition: a is not null
    	// Postcondition: Returns the sum of the elements of a
   
      if(a == null){throw new NullPointerException("Value cannot be null");}

      if(a.length <= 0){
         throw new IllegalArgumentException("Array cannot be empty. Length = " + a.length);
      }

      int total = 0;
      for(int i =0 ; i < a.length; i ++){
         total += a[i];
      }
		return total; // Replace by proper implementation!
   }

	public static void main(String args[]) 
	{     
		ArraySumTest arrayTester = new ArraySumTest();
		
      try{
      
            
		// A first example call
      int[] x = {8, 2, -3, 4, 5, -3, 9};
      System.out.println("The sum of elements of x is " + arrayTester.sum(x));

      // Your implementation has to deal with empty arrays, so this
      // should work fine
      int[] y = {};
      System.out.println("The sum of elements of y is " + arrayTester.sum(y));
      
      }catch(IllegalArgumentException e){
         System.out.println(e.getMessage());
      }
      

	}
}
