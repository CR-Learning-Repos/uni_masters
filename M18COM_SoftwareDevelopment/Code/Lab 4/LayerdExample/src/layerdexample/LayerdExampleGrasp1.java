/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LayerdExample;

import java.sql.* ;  // for standard JDBC programsimport java.sql.Connection;
import java.util.*;

/**
 *
 * @author YL Hedley
 */

public class LayerdExampleGrasp1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DentistRepoImpl dentRepo = new DentistRepoImpl();
        ManagerController control = new ManagerController();
        ArrayList bList = new ArrayList();

        //sample code to demo the databaase connection and sql statements            
        String connectionURL = "jdbc:derby://localhost:1527/LayerdExample";
        String uName = "cr";
        String uPass= "pas";
        
        //ConnectionURL, username and password should be specified in getConnection()       
        try {             
                Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
                System.out.println("Connect to database..."); 

                if (conn != null){ 
                    ArrayList list = dentRepo.read(conn);

                    //set the initial branches  
                    Branch br = new Branch();
                    br.setName("cov");
                    br.setStaff(list); 
                    bList.add(br);
                    control.setBranchList(bList);
                  
                    ManagerUI ui = new ManagerUI(control);
                    ui.displayMenu();     
                        
                    dentRepo.write(conn, control.getBranchDentList());
                    conn.close();
                    System.out.println("Connection is closed.");
                        
                    System.exit(1);
                    
                } else {
                    System.out.println("null");  
                }
            } catch (SQLException ex) {             
                System.out.println("Connection failed.");         
        }          
    }
}
