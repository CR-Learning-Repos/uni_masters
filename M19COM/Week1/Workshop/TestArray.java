class TestArray
{
//Main method testing the Box class
public static void main(String[] args)
{

final int LIMIT = 5;
final int MULTIPLE = 10 ;
int[] array = new int[LIMIT];
for (int i =0; i < array.length; i++){
   array[i] = i*MULTIPLE;
   System.out.println(array[i]);
}

// Our arr contains 8 elements 
        int[] arr = {13, 7, 6, 45, 21, 9, 101, 102}; 
  
        java.util.Arrays.sort(arr); 
  
        System.out.printf("Modified arr[] : %s", 
        java.util.Arrays.toString(arr)); 

 }
}