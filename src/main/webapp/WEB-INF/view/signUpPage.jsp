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
<style>
    .error {
        color: red;
        font-size: 15px;
    }
</style>
</head>
<body>
<div align = "center">
	<p>Lets create your new account!</p>
  
 	<form:form method="post" action="/create-account" modelAttribute="userInfo">
 	<label for"un">User name: </label>
        <form:input  id="un" path="uName"/>
        <br>
        <form:errors path="uName" cssClass="error"/><br>
        <label path="pw">Password: </label>
        <form:input  id="pw" type="password" path="pass"/>
        <br>
        <form:errors path="pass" cssClass="error"/><br>

 	 	 	<input name="create" type="submit" value="create account">

 	</form:form>
 	<br>

		<li><a href="/">Go back</a></li>

		</div>
</body>
</html>