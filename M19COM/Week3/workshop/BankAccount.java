/**    A bank account has a balance that can be changed by deposits and withdrawals.    @version ExamppleCode for M19COM lecture 3.2 */ 
public abstract class BankAccount
 {    
// Instance attributes    
protected double balance;        
// Default constructor    
protected BankAccount()    
{       balance = 0;    }        
// Parameterised constructor   
 protected BankAccount(double bIn)    
 {       balance = bIn;    }       
  // Accessor method    
  protected double getBalance()    
  {       return balance;}        
  // Mutator methods    
  protected void deposit(double amount)    
  {       balance = balance + amount;    }
 protected void withdraw(double amount)
     {       balance = balance - amount;    }
  // Transfer amount from this account to acc
      protected void transfer(double amount, BankAccount acc)
          {  withdraw(amount);       acc.deposit(amount);    }    
 
   public String toString()   
    {       String state = "\n" + getClass().getName() +  
                        ", Balance(" + getBalance() + "), ";  
     
     return state;   
      } 
}