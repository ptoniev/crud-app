<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
crossorigin="anonymous">
<style>
     .errors {
             color:red;
             font-size: 15px;
         }

         </style>
</head>
  <body>
  <div align = "center">

  <p>The application is up and running</p>
	<p>Test how the user management system works</p>

 	<form:form action="/" method="post" modelAttribute="userInfo">
    <p>
    <label for"yn">User name: </label>
    <form:input  id="yn" path="uName"/>
    <br>
    <form:errors path="uName" cssClass="errors"/><br>

    <label for"cn">Password: </label>
    <form:input  id="cn" type="password" path="pass"/>
    <br>
    <form:errors path="pass" cssClass="errors"/><br>
    <input name="login" type="submit" value="submit">
    </form:form>


		<li><a href="/create-account" >Sign Up</a></li>
		<li><a href="/list-of-users" >List of users</a></li>

  	</div>
  </body>
</html>