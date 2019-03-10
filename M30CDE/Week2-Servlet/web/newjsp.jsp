<%-- 
    Document   : newjsp
    Created on : 07-Feb-2019, 10:45:21
    Author     : rollingc
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/sql" %>


<%
    String x = request.getParameter("x");
    String y = request.getParameter("y");
%>

<%! String Add(String a, String b) {
        Integer aVal = Integer.parseInt(a);
        Integer bVal = Integer.parseInt(b);
        Integer result = (aVal + bVal);
        return result.toString();
    } %>
<%! String Subtract(String a, String b) {
        Integer aVal = Integer.parseInt(a);
        Integer bVal = Integer.parseInt(b);
        Integer result = (aVal - bVal);
        return result.toString();
    } %>
<%! String Multiply(String a, String b) {
        Integer aVal = Integer.parseInt(a);
        Integer bVal = Integer.parseInt(b);
        Integer result = (aVal * bVal);
        return result.toString();
    }%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add</h1>
        <h4><%= Add(x, y)%></h1>
        <h1>Subtract</h1>
        <h4><%= Subtract(x, y)%></h4> 
        <h1>Multiply</h1>
        <h4><%= Multiply(x, y)%></h>
            </body>
            </html>
