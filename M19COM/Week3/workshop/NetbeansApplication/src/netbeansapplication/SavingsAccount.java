package netbeansapplication;
/**    An account that earns interest at a fixed rate at end of month.     @version ExamppleCode for M19COM lecture 3.2 */
 public class SavingsAccount extends BankAccount 
 {    private double interestRate; 
 //percent        
 /**       Constructs a bank account with a given interest rate.       @param rate the interest rate    */ 
    public SavingsAccount(double rate)    
    {       interestRate = rate;    } 
    /**       Constructs a bank account with a given balance and interest rate.       @param bIn the initial balance       @param rate the interest rate    */
        public SavingsAccount(double bIn, double rate)  
          {       // Constructs superclass instance      
           super(bIn);       
           interestRate = rate;   
            }          
            /**       Adds the earned interest to the account balance.    */ 
                public void addInterest() 
                   {      double interest = getBalance() * interestRate / 100;       deposit(interest);   
                    }      
                      /**       Overriding method to include interestRate.       @return current state of the object as a string    */ 
                         public String toString()  
                           {       String state = super.toString() +                       "Interest Rate(" + interestRate + ")";              return state;           
                               }
                            } 