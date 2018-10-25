/**
* A class demonstrates use of variables, arithmetic operations, string concatenation.
* @author Hong Guo
*/
public class MyFirstJarveProgram
{
    //main method
   public static void main(String args[])
   {
   System.out.println("Hello world!");
    /*integers can be manipulated using standard arithmetic operations:
    + addition, - subtraction, * multiplication, / division */
    //add two integers together and print out the result directly
    System.out.println(5+8);
    //alternatively we can use local variables
    //declare three variables and assign values
    int num1 = 5;
    int num2 = 8;
    int intResult = num1 + num2;
    System.out.print("Result of 5+8 = ");
    System.out.println(intResult);
    num1 += 7; // num1 = num1 + 7;
    intResult = num1 + num2;
    //alternatively we can use string concatenation to better layout
    //the output result, and better flexibility
    System.out.println("Result of " + num1 + " + " + num2 + " = " + intResult);
    }
 }