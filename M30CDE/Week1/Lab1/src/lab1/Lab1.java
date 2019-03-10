/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class Lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList array = CreateArray(0,10);
        PrintArray(array);
       
        String s1 = "abc = 10" ;
        String s2 = "abc = " + 10;
        String s3 = "abc = 6+4";
        String s4 = "abc = (6+4)";
        String s5 = "abc = " + (6+4);
        
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);

       
    }
    
    public static void PrintArray(ArrayList array){
         for(int i =0; i < array.size(); i++){
        
            System.out.println(array.get(i));
        }
    }
    
    public static ArrayList CreateArray(int start, int end){
    
        ArrayList returnArray;
        returnArray = new ArrayList();
        
        for(int i=start; i<=end; i++){
            
            returnArray.add(i);
        }
        
        return returnArray;
    
    }
    
}
