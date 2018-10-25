/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LayerdExample;

/**
 *
 * @author YL Hedley
 */
import java.io.*;
import java.util.ArrayList;

public class ManagerUI {
    /**
     * @param args the command line arguments
     */   
        
    //Run the menu interface ---------
    String demoOptions[] = {"Add a new dentist", "Display the total number of dentists", "Exit the System"};  
    char demoChoice;          
    Menu demoMenu= new Menu("Menu ", demoOptions, "Enter the menu option: ");          
    ManagerController con; 

    public ManagerUI(ManagerController control) {
        con = control;
    }    

    public void displayMenu() {
        boolean exit = true;
        while (exit){
            System.out.println("----------------------------------------------");
            demoChoice = demoMenu.offerMenu();
            String bName = "";
            String name = "";
            String spec = "";
            int ref = 0;

            BufferedReader keyboard;
            switch (demoChoice){
            case 'A': //to add a new dentist
                try {
                    keyboard = new  BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter the brach name:"); 
                    bName = keyboard.readLine();
                    System.out.println("Enter a dentist refence number:"); 
                    String fromKeyboard = keyboard.readLine();
                    ref = Integer.parseInt(fromKeyboard);
                    System.out.println("Enter dentist name:"); 
                    name = keyboard.readLine();        
                    System.out.println("Enter the dentist spciality:"); 
                    spec = keyboard.readLine();
                    
                    ArrayList bList = con.getBranchList();
                    con.register(bList, bName, ref, name, spec);
                }
                catch (java.io.IOException exception){} 
                //-------------------------------------------                
            break;

            case 'B': //to display the total number of dentists 
                    con.displayTotalDentistNumber();
                //-------------------------------------------
            break;       
          
            case 'C': //to exist the system
	        System.out.println("You have exited the system."); 
                exit = false;
            }
        }//end while
      }//end 
}     
