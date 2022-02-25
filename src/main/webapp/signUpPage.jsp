<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Creation</title>
</head>
<body>
	<p>Lets create your new account!</p>
  
 	<form method="post" action="/create-account">
 	<table> <tr><td>Username</td> <td><input type="text" name="username" required></td></tr>
 	  <tr><td>Password</td> <td><input type="password" name="password" required></td></tr>
 	 	 	 <tr><td></td> <td><input type="submit" value="create account"></td></tr>
 	</table>
 	</form>  
     <ul>
		<li><a href="/">Go back</a></li>
		</ul>
</body>
</html>