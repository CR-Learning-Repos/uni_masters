import java.util.Scanner;
public class ScannerClass
{
 public static void main(String[] args)
 {
Scanner in = new Scanner(System.in);
System.out.print("Enter your name ... ");
String name = in.nextLine(); // store input in name
System.out.print("Enter your age ... ");
int age = in.nextInt(); // store input in age
System.out.println(name + ": " + age);
 //etc
 }
}