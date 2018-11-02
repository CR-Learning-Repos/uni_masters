import java.util.Arrays;
import java.util.Random;
import java.lang.Math;



public class TestClass{

public static void main(String[] args){
int[] myArray = {1, 4, 9};
int v = 10;
int pos = Arrays.binarySearch(myArray, v); 

System.out.println(pos);
int givenSize = 9;
 int[] a = new int[givenSize];
 //Construct random number generator (an object of Random)
 Random generator = new Random();
 // Populate an array with random numbers in range [0, n)
 for (int i = 0; i < a.length; i++){
 a[i] = generator.nextInt(200);
 }
 // Display all elements in an array
 for (int i = 0; i < a.length; i++){
System.out.print(a[i] + " ");
 }

}
}