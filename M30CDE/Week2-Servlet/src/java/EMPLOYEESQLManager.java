/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rollingc
 */
import java.util.*;
import javax.sql.*;
import java.sql.*;

public class EMPLOYEESQLManager {

    private String URL;
    private String USERNAME;
    private String PASSWORD;
    private String TABLENAME;

    EMPLOYEESQLManager(String url, String username, String password) {
        this.URL = url;
        this.USERNAME = username;
        this.PASSWORD = password;
        this.TABLENAME = "EMPLOYEE";
    }

    public boolean INSERTROW(int id, String name, String lastName, int salary, String date) throws SQLException {

        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection(this.URL, this.USERNAME, this.PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No Con==============");
        }
        String sql = "INSERT INTO "+ this.TABLENAME + " VALUES (?,?,?,?,?)" ;
        try {
            st = con.prepareStatement(sql);
            st.setInt(1,id);
            st.setString(2,name);
            st.setString(3,lastName);
            st.setInt(4,salary);
            st.setString(5,date);
            rs = st.executeQuery(sql);
            return true;
        } catch (Exception e) {
            System.out.println("Query Exception ==============");
            rs.close();
            st.close();
            con.close();
            return false;
        }
    }
}
