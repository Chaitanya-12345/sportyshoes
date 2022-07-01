<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@page import="com.sportyshoes.model.Product"%>
      <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:pink;">

<form action="/productgetall">
<%List<Product> list=(List<Product>) request.getAttribute("list");%>
<h1>Product Details</h1>
<table border="1">

<tr><th>Id</th><th>Name</th><th>Price</th><th>Category</th><th>Edit Product</th><th>Delete Product</th><th>Add Product</th></tr>
<%for(Product p:list){ %>
<tr><td><%=p.getId() %></td><td><%=p.getName() %></td><td><%=p.getPrice() %></td><td><%=p.getCategory()%>
</td><td><a href="Productupdate.jsp">Edit Product</a></td><td><a href="Productdelete.jsp">Delete Product</a></td><td><a href="Productinsert.jsp">Add Product</a></td></tr>
<%} %>
</br>


<a href="Productinsert.jsp">Insert more Products</a>
</br>
</br>
<a href="Welcome.jsp">Go to back sprotyshoes website</a>
</br>
</br>
</table>
</form>
</body>
</html>