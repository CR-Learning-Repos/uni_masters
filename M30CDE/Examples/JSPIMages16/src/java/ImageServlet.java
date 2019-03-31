/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aa0699
 */
@WebServlet(urlPatterns = {"/ImageServlet"})
public class ImageServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/gif");
        String dbURL = "jdbc:derby://localhost:1527/Images2";
       int id = Integer.parseInt(request.getParameter("id"));
       //id =2;
       System.out.print(" ......................."  + id);
       String query = "SELECT IMAGE from IMG where ID =" +id ;
       System.out.print(" QUERY  ============================"+ query);
        try {
            OutputStream out = response.getOutputStream() ;
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
            Connection conn = DriverManager.getConnection(dbURL); 
        
           
            Statement statement = conn.createStatement() ;
            ResultSet rs= statement.executeQuery(query) ; 
         
            Blob img = null ;
            byte[] imgData = null ;
    
       
       
  if (rs.next()) 
  {
     img = rs.getBlob(1);
    
  } 
 
     
      imgData = img.getBytes(1,(int)img.length());
      out.write(imgData);
  
      // o.write(imgData);
       System.out.println("Image has been written ....................");
       out.flush();
       out.close();
       
    
        }
        
        
        catch(Exception e)
        {
            System.out.println(" Exception ---------------------"+ e.toString());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
