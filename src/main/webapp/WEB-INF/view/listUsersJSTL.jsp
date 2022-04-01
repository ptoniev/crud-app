<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
crossorigin="anonymous">
<meta charset="UTF-8">
<title>List of users</title>
</head>
<body>
<div align = "center">
<c:choose>
<c:when test="${userMap!=null}">
<c:forEach var="entry" items="${userMap}">
User name: <c:out value="${entry.key}"/>,
 Password: <c:out value="${entry.value}"/>
<br>
</c:forEach>
</c:when>
<c:otherwise>
<c:out value="There are no registered users.">
</c:out>
</c:otherwise>
</c:choose>
</div>
</body>
</html>