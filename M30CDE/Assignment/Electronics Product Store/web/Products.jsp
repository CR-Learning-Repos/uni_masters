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
<div class="row">
    <div class="col-md-1">
        ID
    </div>
    <div class="col-md-1">
        Category
    </div>
    <div class="col-md-7">
        Description
    </div>
    <div class="col-md-1">
        Price
    </div>
    <div class="col-md-1">
        Action
    </div>
</div>


<% while (rs.next()) {%>
<div class="row top-buffer" data-category="<%= rs.getInt(2)%>"   >
    <div class="col-md-1">
        <%= rs.getInt(1)%>
    </div>
    <div class="col-md-1">
        <%= rs.getInt(2)%>
    </div>
    <div class="col-md-7">
        <%= rs.getString(4)%>
    </div>
    <div class="col-md-1">
        <%= rs.getInt(3)%>
    </div>
    <div class="col-md-2">
        <button class="btn btn-primary" data-id="<%= rs.getInt(1)%>">
            Add to cart
        </button>
    </div>
</div>
      <hr size=2>
<% }%>


