<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>                
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<h1>New Person</h1>
	<form:form action="/licenses/new" method="post" modelAttribute="license">
	 	<p>
		    <form:select path="person">
	    	<form:option value="-" label="--Please Select--"/>
	    	<form:options items="${pers}" />
			</form:select>
		</p>
	    <p>
	        <form:label path="state">state</form:label>
	        <form:errors path="state"/>
	        <form:input path="state"/>
	    </p>
	    <p>
	        <form:label path="expirationDate">date</form:label>
	        <form:errors path="expirationDate"/>
	    	<form:input type="date" path="expirationDate" />
	    </p>   
	    <input type="submit" value="Submit"/>
	</form:form> 
</body>
</html>