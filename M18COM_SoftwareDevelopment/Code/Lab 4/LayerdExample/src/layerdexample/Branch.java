/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LayerdExample;

import java.util.ArrayList;

/**
 *
 * @author YL Hedley
 */
public class Branch {
         private String name="";         
         private ArrayList list = new ArrayList();


         public Branch() {};
         
         public Branch(int ref, String name, String spec) {
            
             Dentist dent = new Dentist();
             dent.setRef(ref);
             dent.setName(name);
             dent.setSpeciality(spec);
             list.add(dent);
         }  


         public String getName(){
             return name;
         }
         public void setName(String aName){
             name = aName;
         }
         public ArrayList getStaff(){
             return list;
         }
         public void setStaff(ArrayList aList){
             list = aList;
         }  
         public void addStaff(ArrayList aList, Dentist dent){
             aList.add(dent);
             list = aList;
         }
         public int getNumberOfDentist(){
             return list.size();
         }         
           
}
