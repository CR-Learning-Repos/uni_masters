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
import java.sql.*;
import java.util.ArrayList;

public interface Repo {

    public ArrayList read(Connection conn);
    void write(Connection conn, ArrayList list);
    
}
