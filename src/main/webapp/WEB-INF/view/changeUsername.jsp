<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update username</title>
</head>
<body>
<div align = "center">
<li>
<form method="post" action="/update-username">
  		<table> <tr><td>Enter old username</td> <td><input type="text" name="username" required></td></tr>
  		<tr><td>Enter new username</td> <td><input type="text" name="newUsername" required></td></tr>
 	 	<tr><td>Password</td> <td><input type="password" name="password" required></td></tr>
 	 	 <tr><td></td> <td><button type="submit" >Confirm changes</button></td></tr> </table> </form>
 	</li>
 	</div>
</body>
</html>