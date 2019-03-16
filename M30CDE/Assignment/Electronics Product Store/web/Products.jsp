<%-- 
    Document   : Products
    Created on : 16-Mar-2019, 20:27:04
    Author     : ChrisRollings
--%>
<%@ page import="java.sql.*, ElectronicProductsSQL.ProductsSQLManager" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ProductsSQLManager manger = new ProductsSQLManager();
    
    ResultSet rs = manger.GETALLROWS();

%>
        <button>Hello2</button>
        <TABLE BORDER="1">
        <TR>
            <TH>ID</TH>
            <TH>Price</TH>
            <TH>Description</TH>
        </TR>
    <% while (rs.next()) {%>
            <TR>
                <TD> <%= rs.getInt(1)%></td>
            <TD> <%= rs.getInt(2)%></td>
            <TD> <%= rs.getString(3)%></TD>
            </TR>
    <% }%>
    </TABLE>

