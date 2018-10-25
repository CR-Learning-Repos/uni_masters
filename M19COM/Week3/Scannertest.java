import java.util.Scanner;
class Scannertest
{
//Main method testing the Box class
public static void main(String[] args)
{
       Scanner sc = new Scanner(System.in);
     int i = sc.nextInt();
     boolean bool = sc.nextBoolean();
     System.out.println(i);
     System.out.println(bool);
     
     TestClass obj = new TestClass();
     System.out.println(obj);
}


}

class TestClass{
TestClass(){}


}