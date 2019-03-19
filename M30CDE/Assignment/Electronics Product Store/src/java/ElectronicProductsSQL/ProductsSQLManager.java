/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElectronicProductsSQL;

import java.util.*;
import javax.sql.*;
import java.sql.*;

/**
 *
 * @author ChrisRollings
 */
public class ProductsSQLManager extends BaseSQLManager {
    private String TABLENAME;

    public ProductsSQLManager() {
                this.TABLENAME = "PRODUCTS";

    }

    public ResultSet GETALLROWS() throws SQLException {

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection(this.URL, this.USERNAME, this.PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No Con==============");
        }
        String sql = "SELECT * FROM " + this.TABLENAME;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            System.out.println("Query Exception ==============");
            rs.close();
            st.close();
            con.close();
            return null;
        }
    }

    public boolean INSERTROW(int id, int price, String desc) throws SQLException {

        Connection con = null;
        PreparedStatement  st = null;
        ResultSet rs = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection(this.URL, this.USERNAME, this.PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No Con==============");
        }
        String sql = "INSERT INTO " + this.TABLENAME + " VALUES (?,?,?)";
        try {
            st = con.prepareStatement(sql);
            st.setInt(1, id);
            st.setInt(2, price);
            st.setString(3, desc);
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
