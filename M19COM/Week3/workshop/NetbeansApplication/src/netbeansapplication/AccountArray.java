package netbeansapplication;

/** A class manipulates various BankAccount stored to       demonstrate polymorphism and dynamic binding.    @author Hong Guo    @version ExamppleCode for M19COM lecture 3.2 */
public class AccountArray {

    private BankAccount[] accounts;
    private int numOfElements;
//number of elements currently stored        
// Constructor taking one parameter      

    public AccountArray(int maxSize) {
// Creat a new array of maxSize
        accounts = new BankAccount[maxSize];
        numOfElements = 0;
    }        // Add acc into next available position in the array 
    // return true if successful else false    

    public boolean add(BankAccount acc) {
        boolean added = false;
        if (numOfElements < accounts.length) {
            accounts[numOfElements] = acc;
            numOfElements++;
            //next position 
            added = true;
        }

        return added;
    }
    // Deposit amount into every bankAccounts held in the array    

    public void depositToAll(double amount) {
        for (int i = 0; i < numOfElements; i++) {
            accounts[i].deposit(amount);
        }
    }
    // Withdraw amount from every bankAccounts held in the array  

    public void withdrawFromAll(double amount) {
        for (int i = 0; i < numOfElements; i++) {
            accounts[i].deposit(amount);
        }
    }
    // Return balance of the bankAccout at pos in the array  

    public double getBalance(int pos) {
        return accounts[pos].getBalance();
    }
    // Transfer a from the bankAccount at posFrom to the bankAccount at posTo  

    public void transfer(double a, int posFrom, int posTo) {
        accounts[posFrom].transfer(a, accounts[posTo]);
    }
    // Return a string describing current state of accounts held in the array   

    public String toString() {
        String stateAll = "\n\nType and state of the objects held  \n----------------------------------";

        for (int i = 0; i < numOfElements; i++) {
            stateAll = stateAll + accounts[i];
        }
        return stateAll;
    }
}
