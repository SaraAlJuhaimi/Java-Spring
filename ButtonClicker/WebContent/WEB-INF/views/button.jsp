<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>	
<body>
	<form action="${pageContext.request.contextPath}/buttonClick">
		<input type="submit" value="Click Me!">		
	</form>
	<h1>You have clicked this button <c:out value="${counter} times"/></h1>
</body>
</html>