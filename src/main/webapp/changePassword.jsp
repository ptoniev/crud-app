<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update password</title>
</head>
<body>
<li>
<form method="post" action="/update-password">
  		<table> <tr><td>Enter username</td> <td><input type="text" name="username" required></td></tr>
  		<tr><td>Enter old password</td> <td><input type="password" name="oldPassword" required></td></tr>
 	 	<tr><td>Enter new password</td> <td><input type="password" name="newPassword" required></td></tr>
 	 	 <tr><td></td> <td><button type="submit" >Confirm changes</button></td></tr> </table> </form>
 	</li>
</body>
</html>