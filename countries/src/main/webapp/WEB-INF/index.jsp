<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>                    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<table>
    <thead>
        <th>Country</th>
        <th>Language</th>
        <th>Language Percentage</th>
    </thead>
    <tbody>
        <c:forEach var="row" items="${countries}">                
        <tr>
            <td>${row[0]}</td>
            <td>${row[1]}</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>