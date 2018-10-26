// Exercise_1 for m19com Lab4
// Write the implementation according to contract
public class ArrayMaxTest 
{

	public int max(int[] array)throws EmptyArrayException
	{
   // Takes an (unsorted) array of integers and an integer as parameters, and
   // Returns an index at which the integer appears in the array
   
      if(array.length <= 0){throw new EmptyArrayException("Empty array");}
      
      int maxValue = Integer.MIN_VALUE;
      for(int i =0 ; i < array.length; i ++){
      
         if(array[i] > maxValue){
            maxValue = array[i];
         }      
      }
		return maxValue; // Replace by proper implementation!
   }

	public static void main(String args[]) 
	{     
      try{
      	ArrayMaxTest arrayTester = new ArrayMaxTest();          
   		// A first example call
         int[] x = {8, 2, -3, 4, 5, -3, 9};
         System.out.println("Test max: Excpected = 9. Actual = " + arrayTester.max(x));
         int[] y = {};
         System.out.println("Test max: Excpected = 9. Actual = " + arrayTester.max(y));
      }catch(EmptyArrayException e){
            System.out.println("Exception " + e.getMessage());   
         }
	}
}




