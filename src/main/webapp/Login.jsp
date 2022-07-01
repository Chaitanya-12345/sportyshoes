<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:#F08080;">
;">
>
<center> <h1>Admin Login</h1> </center> 
 <table border="1">
 
  <form action="/Login" method="POST">  
    <center><div class="container">     
       <input type="hidden" name="command" value="LOGIN" />
         <label>Username: </label> 
            <br/>
           <input type="text" placeholder="Enter Username" name="username" required> 
            <br/>
           <label>Password : </label>  
            <br/>
            <input type="password" placeholder="Enter Password" name="password" required>
            <br/>
            <br/>
            
           <button type="submit">Login</button> 
           
           <form action="/changepw">
         <button type="submit">change password</button>
      </form>
            
            
            <br/>
            <input type="checkbox" checked="checked">Remember me
            </table>

        </div>
        </center>
        
    </form>     


</body>
</html>