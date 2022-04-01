<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
crossorigin="anonymous">
<meta charset="UTF-8">
<title>Update username</title>
</head>
<body>
<div align = "center">

 	<form:form method="post" action="/update-username" modelAttribute="userInfo">
     	<p>
            <label for"zn">Old User name: </label>
            <form:input  id="zn" path="uName"/>
            </p>
            <p>
                        <label for"nu">New User name: </label>
                        <form:input  id="nu" path="newUsername"/>
                        </p>
            <p>
            <label for"pn">Password: </label>
            <form:input  id="pn" type="password" path="pass"/>
            </p>
            <input type="submit" value="submit changes">
            </form:form>

 	</div>
</body>
</html>