package netbeansapplication;
/**	 A	checking	account that charges	transaction	fees at end	of	month.	 @version ExamppleCode for	M19COM lecture	3.2 */ 
public class CheckingAccount extends BankAccount 
{	 
   private int transactionCount;	  
   private static	final	int FREE_TRANSACTIONS =	3;	
	private	static final double TRANSACTION_FEE	= 2.0;	  
		  /**			Constructs a checking account	with a given balance. 
				  @param	bIn the initial balance		*/	  
	public CheckingAccount(double	bIn)	  
	{	// Construct superclass instance 
	   super(bIn);					
		// Initialize	transaction	count		
		transactionCount	= 0;	  
   }		 
	 /**			Deposit a given amount.			
	@param	amount the given amount		*/	
	public	void deposit(double amount)	
	{		transactionCount++;		 
			//	Now add amount	to	balance		  
			super.deposit(amount);
   }		
			/**		  Withdraw a given amount.			
         @param amount the	given	amount	 */	
			public	void withdraw(double	amount)
			{		  transactionCount++;	 
			//	Now subtract amount from balance	  
					super.withdraw(amount);	  }		
			 /**		  Deducts the accumulated fees and		
			resets the	transaction	count	for next	month.	 */ 
			public void deductFees()	  
		   {			
               if(transactionCount > FREE_TRANSACTIONS)		 
					 {			 
                  double fees =	TRANSACTION_FEE *	(transactionCount	- FREE_TRANSACTIONS); 
					   super.withdraw(fees);			
                }	
					 transactionCount	= 0;	  
																						
          }			 
			 /**		  Overriding the method	to	include transaction|Count.			
          @return current state of the object	as	a string		*/
			
         public	String toString()		
			{		 String state = super.toString()	+ "TransactionCount(" + transactionCount	+ ")";	
					 return state;	
                					  
			
         }
}