<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align = "center">
Successfully logged in.
<p>  </p>

<li><a href="/edit-profile">Edit Profile</a></li>

<li><a href="/">Log out</a></li>
<br>

<form method="post" action="/delete-account">
  <button type="submit" >Delete account</button> </form>
<br>
<li><a href="/update-username">Change username</a></li> 
<li><a href="/update-password">Change password</a></li> 

</div>
</body>
</html>