<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@page import="com.sportyshoes.model.Purchase"%>
      <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:pink;">
<%List<Purchase> list=(List<Purchase>) request.getAttribute("list");%>
<h1>Purchase Details</h1>
<table border="1">

<tr><th>Id</th><th>User</th><th>ProductName</th><th>ProductPrice</th><th>ProductCategory</th><th>Edit Purchase</th><th>Delete Purchase</th><th>Add Purchase</th></tr>
<%for(Purchase p1:list){ %>
<tr><td><%=p1.getId() %></td><td><%=p1.getUser()%></td><td><%=p1.getProductname() %></td><td><%=p1.getProductprice() %></td><td><%=p1.getProductcategory()%>
</td><td><a href="Purchaseupdate.jsp">Edit Purchase</a></td><td><a href="Purchasedelete.jsp">Delete Purchase</a></td><td><a href="Purchaseinsert.jsp">Add Purchase</a></td></tr>
<%} %>

<a href="Purchaseinsert.jsp">Insert more Purchase</a>
</br>
</br>
<a href="Welcome.jsp">Go to back sprotyshoes website</a>
</br>
</br>
</table>
</form>

</body>
</html>