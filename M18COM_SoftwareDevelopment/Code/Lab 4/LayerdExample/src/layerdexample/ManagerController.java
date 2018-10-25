/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LayerdExample;

import java.sql.*;
import java.util.*;



/**
 *
 * @author YL Hedley
 */
public class ManagerController{
    
        ArrayList list = new ArrayList(); 

        public ManagerController() {
         }

        public ArrayList getBranchList(){

            return list;
         }  
        
         public void setBranchList(ArrayList aList){

             list = aList;
         }  
       
        public ArrayList getBranchDentList(){
            ArrayList dList = new ArrayList();
            for (int i = 0; i<list.size(); i++) {
                Branch br = (Branch)list.get(i);
                ArrayList sList = br.getStaff();
                for (int j = 0; j<sList.size(); j++) {
                    dList.add(sList.get(j));
                }                      
            }
            return dList;
         }  
         
         
        public void displayTotalDentistNumber(){
            int total = 0;
            for (int i = 0; i<list.size(); i++) {
                Branch br = (Branch)list.get(i);
                total = total + br.getNumberOfDentist();
            }
            System.out.println("The total number of dentists: " + total);  

         }  
        
        public void register(ArrayList bList, String bName, int ref, 
                String name, String spec){
            ArrayList temp = bList; 
            boolean found  = false;
            int i = 0;
            while (i<bList.size() && !found){
                Branch br = (Branch)bList.get(i);
                
                 if (bName.equalsIgnoreCase(br.getName())){
                     ArrayList dList = br.getStaff();
                     Branch tempBr = new Branch(ref, name, spec);
                     ArrayList dentists = tempBr.getStaff();
                     for (int j = 0; j<dentists.size(); j++){
                         dList.add(dentists.get(j));
                     }                   
                     br.setStaff(dList);
                     found = true;
                 }
                 i++;
            }
             if (found == false){
                Branch br = new Branch(ref, name, spec);
                br.setName(bName);
                temp.add(br);
                list = temp;
             }
             else {
                 list = bList;
             }
         } 
}
