<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>                    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
		<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
  margin-bottom: 30px;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
.button {
    display: inline block;
    width: 115px;
    height: 25px;
    background: grey;
    padding: 10px;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    text-decoration: none;
}
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
    <p>${rateMessage}</p>	
    
    <h1><c:out value="${show.title}"/></h1>
    <h3>Network: <c:out value="${show.network}"/></h3>
	<table>
    <thead>
        <tr>
            <th>User</th>
            <th>Rate</th>
        </tr>
    </thead>
    <tbody>
      <c:forEach items="${ratings}" var="rate">
        <tr>
            <td><c:out value="${rate.user.name}"/></td>
            <td><c:out value="${rate.value}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>

	<form action="/new/rate" method="POST" >
	    <h4>Leave a rating:</h4>
	    <input type="number" name="rate">
	     <input type="hidden" name="showId" value="${show.id}">
	     <input class="button2" type="submit" name="submit" value="Rate!">
	</form> <br> <br> 
	     
	<a class="button" href="/shows/${show.id}/edit">Edit Show</a>
	<a class="button" href="/deleteShow/${show.id}">Delete Show</a>
	
</body>
</html>