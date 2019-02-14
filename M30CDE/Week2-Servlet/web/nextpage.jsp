<%-- 
    Document   : nextpage
    Created on : 07-Feb-2019, 11:09:22
    Author     : rollingc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello <%= session.getAttribute( "theName" ) %></h1>
    </body>
</html>
