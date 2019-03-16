<%-- 
    Document   : session
    Created on : 07-Feb-2019, 11:04:27
    Author     : rollingc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.sql.*;" %>
<%@ page import="java.sql.*" %>


<%
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String url = "jdbc:derby://localhost:1527/ElectronicProduct";
    String user = "chris";
    String pswd = "1234";
    try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection(url, user, pswd);
    } catch (Exception e) {
        e.printStackTrace();

        System.out.println("No Con==============");

    }
    String sql = "SELECT * from EMPLOYEE";
    try {
        st = con.createStatement();

        rs = st.executeQuery(sql);
        System.out.println("After SQL ==============" + st + "......RS .......... " + rs);

    } catch (Exception e) {
        System.out.println("Query Exception ==============");
        rs.close();
        st.close();
        con.close();
    }


%>
<%!
    void AddROW() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String url = "jdbc:derby://localhost:1527/ElectronicProduct";
        String user = "chris";
        String pswd = "1234";
        EMPLOYEESQLManager sql = new EMPLOYEESQLManager(url, user, pswd);

        //sql.INSERTROW(1,"","","","")
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*, EMPLOYEESQLManager%>
        <!DOCTYPE html>
        <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
</head>
<body>        
    <TABLE BORDER="1">
        <TR>
            <TH>ID</TH>
            <TH>Name</TH>
            <TH>LASTNAME</TH>
            <TH>SALARY</TH>
            <TH>STARTDATE</TH>
        </TR>
    <% while (rs.next()) {%>
            <TR>
                <TD> <%= rs.getString(1)%></td>
            <TD> <%= rs.getString(2)%></td>
            <TD> <%= rs.getString(3)%></TD>
            <TD> <%= rs.getString(4)%></TD>
            <TD> <%= rs.getString(5)%></TD>
            </TR>
    <% }%>
    </TABLE>

    <FORM METHOD=POST ACTION="SQLJsp.jsp" onsubmit="<%= AddROW()%>">
            <INPUT TYPE=TEXT NAME=id SIZE=20>
            <INPUT TYPE=TEXT NAME=name SIZE=20>
            <INPUT TYPE=TEXT NAME=lastName SIZE=20>
            <INPUT TYPE=TEXT NAME=salary SIZE=20>
            <INPUT TYPE=TEXT NAME=date SIZE=20>
            <INPUT TYPE=SUBMIT>
            </body>
            </html>
