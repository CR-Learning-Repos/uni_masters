<%-- 
    Document   : index
    Created on : 17-Jun-2016, 12:25:19
    Author     : aa0699
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <img src="imgs/1465762629.svg" width="100" height="200" alt="No image found"/>
        <p/>
        <img src="imgs/1466143979.svg" width="100" height="200" alt="1466143979"/>
        
        <%
            
            
            ResultSet rs = null;
            Statement statement = null;
            
            try{
          String dbURL = "jdbc:derby://localhost:1527/Images2";
          String query = "select ID from APP.IMG";
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
            Connection conn = DriverManager.getConnection(dbURL); 
        
           
           statement = conn.createStatement() ;
             rs= statement.executeQuery(query) ; 
             System.out.println(" Connection OK ==================================");
            }
            catch(Exception e)
            {
              System.out.print(e.toString()) ;
            }
                
            %>
            <table  border =  > <thead>
                            <tr> <th> ID </th> 
                            <th> image </th>
                            </tr> </thead>
                             
                            
                             <tbody>
                             <% while(rs.next())
                              { 
        
                            String key = rs.getString(1);
                            
                            %>  
             
                            <tr> 
                               
                             <td><%=key%></td> 
                             <td><img src="ImageServlet?id=<%=key%>" width="300" height="300"/>

                                     </td> 
                              </tr> 
                              <%  }
                           %>    
                                 
                          </tbody> 
                          </table >
           
       
    </body>
</html>
