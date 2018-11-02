
// Example_3 for m19com Lab4
// Demonstrate self defined Exceptions
public class NonPositiveException extends Exception 
{
   public NonPositiveException() 
	{ 
		super(); 
	}
	
   public NonPositiveException(String s)
	{
		super(s); 
	}
}



