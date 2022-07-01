
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.sportyshoes.model.User"%>
    
    
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:pink;">

<%List<User> list=(List<User>) request.getAttribute("list");%>
<h1>User Details</h1>
<table border="1">

<tr><th>Id</th><th>Firstname</th><th>Lastname</th><th>Email</th><th>Password</th><th>Edit User</th><th>Delete User</th><th>Add User</th></tr>
<%for(User u:list){ %>
<tr><td><%=u.getId() %></td><td><%=u.getFirstname() %></td><td><%=u.getLastname() %></td><td><%=u.getEmail()%></td><td><%=u.getPassword()%>
</td><td><a href="Userupdate.jsp">Edit Name</a></td><td><a href="Userdelete.jsp">Delete User</a></td><td><a href="Userinsert.jsp">Add User</a></td></tr>
<%} %>

<a href="Userinsert.jsp">Insert more users</a>
</br>
</br>
<a href="Welcome.jsp">Go to back sprotyshoes website</a>
</br>
</br>

</table>
<br>
<br>

</body>
</html>