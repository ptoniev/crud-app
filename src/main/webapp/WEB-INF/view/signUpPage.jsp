<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
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
        </p>
        <form:errors path="uName" cssClass="error"/><br>
        <label path="pw">Password: </label>
        <form:input  id="pw" type="password" path="pass"/>
        </p>
        <form:errors path="pass" cssClass="error"/><br>

 	 	 	<input type="submit" value="create account">

 	</form:form>
     <ul>
		<li><a href="/">Go back</a></li>
		</ul>
		</div>
</body>
</html>