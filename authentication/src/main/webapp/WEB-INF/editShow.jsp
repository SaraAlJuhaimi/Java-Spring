<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>            
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<style>
	.button2{
    width: 115px;
    height: 25px;
    background: grey;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    text-decoration: none;
	}
	</style>
</head>
<body>
	<p>${message}</p>
	<h1>Edit Show</h1>
	<form:form action="/shows/${show.id}/edit" method="post" modelAttribute="show">
	    <p>
	        <form:label path="title">Title</form:label>
	        <form:errors path="title"/>
	        <form:input path="title"/>
	    </p>
	    <p>
	        <form:label path="network">Network</form:label>
	        <form:errors path="network"/>
	        <form:input path="network"/>
	    </p>
	    <input class="button2" type="submit" value="Submit"/>
	</form:form>   
</body>	
</body>
</html>