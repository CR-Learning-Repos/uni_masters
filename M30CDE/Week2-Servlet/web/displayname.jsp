<%-- 
    Document   : displayname
    Created on : 07-Feb-2019, 11:04:47
    Author     : rollingc
--%>

<%   
    String name = request.getParameter("username");
    session.setAttribute( "theName", name );
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <A HREF="nextpage.jsp">Continue</A>
    </body>
</html>
