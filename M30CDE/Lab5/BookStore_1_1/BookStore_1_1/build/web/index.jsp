<%-- 
    Document   : index
    Created on : Feb 25, 2013, 11:10:08 AM
    Author     : nazaraf
--%>

<%@ page session="true" %>
<html>
<head>
 <title>Book Store  </title>
</head>
<body bgcolor="Blue">
 
 <hr><p>
 <center>
 <form name="shoppingForm"  action="BookServlet"  method="POST">
 <b>Book:</b> 
 <select name=book>
  <option value="0"> Java | David Bell | 5.50</option>
  <option value="1"> Visual Basic | Tony Butcher  | 10.15</option>
  <option value="2"> C Programming | Simon Locus | 6.95</option>
  
 </select>
 <b>Quantity: </b><input type="text" name="qty" SIZE="3" value=1>
 <input type="hidden" name="action" value="ADD">
 <input type="submit" name="Submit" value="Add to Cart">
 </form>
 </center>
 <p>
 <jsp:include page="Cart.jsp" flush="true" />
</body>
</html>