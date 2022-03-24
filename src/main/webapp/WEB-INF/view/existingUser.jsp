<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Successfully logged in.
<p>  </p>
<ul>
<li><a href="/">Log out</a></li>
<br>
<li>
<form method="post" action="/delete-account">
  <button type="submit" >Delete account</button> </form> </li>
<br>
<li><a href="/update-username">Change username</a></li> 
<li><a href="/update-password">Change password</a></li> 
</ul>
</body>
</html>