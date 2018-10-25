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

import java.util.ArrayList;
import java.sql.*;

public class DentistRepoImpl implements Repo { 
    
    private ArrayList<Dentist> dentists;
        
    public ArrayList read(Connection conn){
        System.out.println("Reading from the database... ");
        ArrayList list = new ArrayList();
        try {   
                Statement st = conn.createStatement();
                
                ResultSet rs=null;
                String sql = "SELECT * FROM DENTIST";
                rs=st.executeQuery(sql);

                while(rs.next()){ 
                    Dentist dent = new Dentist();
                    dent.setRef(rs.getInt("REF"));
                    dent.setName(rs.getString("NAME"));
                    dent.setSpeciality(rs.getString("SPECIALITY"));
                    list.add(dent);
                    System.out.println(rs.getInt("REF")+"\t"+rs.getString("NAME")+
                            "\t"+rs.getString("SPECIALITY"));
                }
                rs.close();
                st.close();

        } catch (SQLException ex) {
            System.out.println("SQLException failed ! ");
        } 
        
        dentists = list;
        
        return dentists;
    }
    

    public void write(Connection conn, ArrayList dentists){
        System.out.println("Writing to the database... ");
        
        Statement st;
        
        try {
            st = conn.createStatement();
            String sql = "DELETE FROM DENTIST";
            st.executeUpdate(sql);

            st.close();
        }
        catch (SQLException ex) {
                    System.out.println("SQLException error " + ex.getMessage());
            }
        
        for (int i = 0; i<dentists.size(); i++) {
            Dentist dentist = (Dentist)dentists.get(i);
            try {   
                st = conn.createStatement();
              
                String sql = "INSERT INTO DENTIST VALUES (" + dentist.getRef() + ", '" + dentist.getName() + "' , '" + dentist.getSpeciality() + "')";
                st.executeUpdate(sql);

                st.close();
            }
            catch (SQLException ex) {
                    System.out.println("SQLException error ");
            }         
        }//end for
    }        
}  
