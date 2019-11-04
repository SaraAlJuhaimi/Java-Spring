<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<h1>Create a Cat!</h1>
	<form action="${pageContext.request.contextPath}/Cats">
		Name: <input type="text" name="name"><br>
		Breed: <input type="text" name="breed"><br>
		Weight <input type="number" name="weight"><br>
		<input type="submit">
	</form>
	<h1>Create a Dog!</h1>
	<form action="${pageContext.request.contextPath}/Dogs">
		Name: <input type="text" name="name"><br>
		Breed: <input type="text" name="breed"><br>
		Weight <input type="number" name="weight"><br>
		<input type="submit">
	</form>
</body>
</html>