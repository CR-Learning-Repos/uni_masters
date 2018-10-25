/**    A demonstration program tests BankAccount class and its subclasses.    @author Hong Guo    @version ExampleCode for M19COM lecture3-2 */ 
 
public class BankAccountDemo 
{   
 public static void main(String[] args)   
 {   
   System.out.println( "\n\t --- BankAccount demonstration ---");    
     System.out.println("\nConstructing an instance using default constructor");    
        BankAccount bankAcc1 = new CheckingAccount(0);          
            System.out.println("\nDemonstrating toString and also getBalance"); 
                    System.out.println("Expect: BankAccount, Balance(0)");      
                     System.out.println(bankAcc1.toString());           
                         System.out.println("\nDemonstrating deposit(3500) then toString()  ... ");  
                                System.out.println("Expect: BankAccount, Balance(3500)");     
                                  bankAcc1.deposit(3500);     
                                    System.out.println(bankAcc1); 
                                     System.out.println("\nConstructing a new instance with initial balance 1000");
                                                  BankAccount bankAcc2 = new SavingsAccount(1000); 
                                                  
 
      System.out.println("\nDemonstrating getBalance... \nExpect: 1000");    
            System.out.println(bankAcc2.getBalance());                        
              System.out.println("\nDemonstrating transfer(1000, bankAcc2) then toString()   ... "); 
 
      System.out.println("Expect: BankAccount, Balance(2500) and Balance(2000)");       
            bankAcc1.transfer(1000, bankAcc2);      
             System.out.println(bankAcc1);    
               System.out.println(bankAcc2);    
                               System.out.println("\n<---------------------   End of BankAccount Demonstration.\n\n");     
                                                 System.out.println( "\n\t === CheckingAccount Demonstration ===");     
                                                      System.out.println("\nConstructing an instance of CheckingAccount");
                                                             CheckingAccount checkingAcc = new CheckingAccount(300);            
                                                               System.out.println("\nDemonstrating deposit(2000), getBalance");    
                                                                  System.out.println("Expect: 2300");               
                                                                    checkingAcc.deposit(2000);      
                                                                     System.out.println(checkingAcc.getBalance());    
                                                                                     System.out.println("\nDemonstrating withdraw 200 and 500, 300, deductFees(),   toString()");      
                                                                                      
 
      System.out.println("Expect: CheckingAccount, Balance("+   ((2300-200-500-300)-(4-3)*2.0) +") TransactionCount(0)");  
      
 
      checkingAcc.withdraw(200);      
               checkingAcc.withdraw(500);      
                checkingAcc.withdraw(300);           
                       // Simulate end of month      
                        checkingAcc.deductFees(); 
                              System.out.println(checkingAcc.toString());        
                                            System.out.println("\n<=======================   End of CheckingAccount Demonstration.>\n\n");    
 
             System.out.println( "\n\t >>> SavingsAccount Demonstration <<<");         
                   System.out.println("\nConstructing an instance of SavingsAccount   with 0 balance"); 
 
      SavingsAccount savingsAcc1 = new SavingsAccount(1.9);             
           System.out.println("\nPrint the initial state of savingsAcc1");  
                System.out.println("Expect: SavingsAccount, Balance(0), InterestRate(1.9)");      
                      System.out.println(savingsAcc1.toString());      
 
      System.out.println("\nConstructing an new instance of SavingsAccount   with 9000 balance");
      
           SavingsAccount savingsAcc2 = new SavingsAccount(9000, 2.75);              System.out.println("\nDemonstrating transfer(1000, savingsAcc1),   addInterest(), toString()  ... ");       
 
      savingsAcc2.transfer(1000, savingsAcc1);            
        // Simulate end of month
        savingsAcc1.addInterest();    
           savingsAcc2.addInterest();  
                       System.out.println("\nPrint the current state of savingsAcc1 and savingsAcc2");  
                             System.out.print("Expect: SavingsAccount, Balance("+        (1000+1000*1.9/100) +"), InterestRate(1.9)");           
 
      System.out.println("\n\tSavingsAccount, Balance(" +  (8000+8000*2.75/100) + "), InterestRate(2.75)");   
 
      System.out.print(savingsAcc1);        
        System.out.println(savingsAcc2);    
                                           System.out.println("\n<<<=========================    End of SavingsAccount Demonstration.\n\n");   
 
   } }