<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update password</title>
</head>
<body>
<div align = "center">

        <form:form method="post" action="/update-password" modelAttribute="userInfo">
     	<p>
            <label for"myn">User name: </label>
            <form:input  id="myn" path="uName"/>
            </p>
            <p>
                        <label for"pti">Old Password: </label>
                        <form:input  id="pti" type="password" path="pass"/>
                        </p>
            <p>
                        <label for"npb">New password: </label>
                        <form:input  id="npb" path="newPassword"/>
                        </p>
            <input type="submit" value="submit changes">
            </form:form>

 	</div>
</body>
</html>