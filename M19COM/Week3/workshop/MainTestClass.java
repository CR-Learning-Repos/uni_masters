public class MainTestClass
{
 public static void main(String[] args)
 {
// 
//    Person p1 = new Person();
//    p1.setName("Bill");
//    Person p2 = new Person();
//    p1.setName("Bob");
// 
//    System.out.println(p1.compareTo(p2));
//    System.out.println(p1.compareTo(p1));
   
//declare a constant (using keyword 'final')  
         //that we can use throughout our program    
         final int MAX_SIZE = 10;           
         //instantiate object & pass the size of the array to the constructor   
          SafeArray intArray = new SafeArray(MAX_SIZE); 
         //populate the array   
         boolean okay = true;     
         for(int i=0; i<MAX_SIZE; i++)   
         {        
            //calling add to intArray object of class SafeArray     
            //and store the returing-result in okay       
            okay = intArray.add((i+2)*3);         
            if(!okay)       
            {           
               System.out.println("Could not add value ...");  
            }  
          }  
         System.out.println(intArray.toString()); 
   
   
     } }