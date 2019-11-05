<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/game.css" />
</head>
<body>
	<h1>Welcome to the great number game!</h1>
	<p>I am thinking of a number between 1 and 100</p>
	<p>Take a guess!</p>
	<form action="${pageContext.request.contextPath}/Guess" method="POST">
		<input type="number" name="number">
		<input type="submit" value="Submit">		
	</form>
	<c:out value="${random} times"/>
	<% boolean result = (boolean) (session.getAttribute("result"));
		if(result == true){%>
					<h1>success</h1>
		<%}else{%>
					<h2>error</h2>
		<%}%>
</body>
</html>