<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
     <meta charset="UTF-8">
     <title>CRUD Application</title>
  </head>
 
  <body>
  <p>The application is up and running</p>
	<p>Test how the user management system works</p>
  
 	<form method="post" action="/">
 	<table> <tr><td>Username</td> <td><input type="text" name="username" required></td></tr>
 	  <tr><td>Password</td> <td><input type="password" name="password" required></td></tr>
 	 	 	 <tr><td>Login</td> <td><input type="submit" value="submit details"></td></tr>
 	</table>
 	</form>  
     <ul>
		<li><a href="/create-account">Sign Up</a></li>
		<li><a href="/list-of-users">List of users</a></li>
  	</ul>
  </body>
</html>