<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
     <meta charset="UTF-8">
     <title>CRUD Application</title>
  </head>

  <body>
  <div align = "center">

  <p>The application is up and running</p>
	<p>Test how the user management system works</p>

 	<form:form action="/" method="post" modelAttribute="userInfo">
    <p>
    <label for"yn">User name: </label>
    <form:input  id="yn" path="uName"/>
    </p>
    <p>
    <label for"cn">Password: </label>
    <form:input  id="cn" type="password" path="pass"/>
    </p>
    <input type="submit" value="submit">
    </form:form>
     <ul>
		<li><a href="/create-account">Sign Up</a></li>
		<li><a href="/list-of-users">List of users</a></li>
  	</ul>
  	</div>
  </body>
</html>