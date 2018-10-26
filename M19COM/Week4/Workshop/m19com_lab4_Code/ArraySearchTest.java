// Exercise_1 for m19com Lab4
// Write the implementation according to contract
public class ArraySearchTest 
{

	public int search(int[] array, int item)
	{
   // Takes an (unsorted) array of integers and an integer as parameters, and
   // Returns an index at which the integer appears in the array
   
      for(int i =0 ; i < array.length; i ++){
      
         if(array[i] == item){
            return i;
         }      
      }
		return -1; // Replace by proper implementation!
   }

	public static void main(String args[]) 
	{     
		ArraySearchTest arrayTester = new ArraySearchTest();          
		// A first example call
      int[] x = {8, 2, -3, 4, 5, -3, 9};
      System.out.println("Test index for numer 4 in array: Excpected = 3. Actual = " + arrayTester.search(x,4));
      System.out.println("Test index for numer 9 in array: Excpected = 6. Actual = " + arrayTester.search(x,9));
      System.out.println("Test index for numer 8 in array: Excpected = 0. Actual = " + arrayTester.search(x,8));
      System.out.println("Test index for numer -3 in array: Excpected = 2. Actual = " + arrayTester.search(x,-3));

	}
}
