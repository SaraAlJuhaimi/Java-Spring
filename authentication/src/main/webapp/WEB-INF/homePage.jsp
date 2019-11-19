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
</style>
</head>
<body>
    <h1>Welcome, <c:out value="${user.name}"/></h1> 
    <h2>TV Shows</h2>
	<table>
    <thead>
        <tr>
            <th>Show</th>
            <th>Network</th>
            <th>Avg Rate</th>     
        </tr>
    </thead>
    <tbody>
        <% int counter = 0; %>
        
      <c:forEach  var = "i" begin = "0" end ="${showsLength}">
        <tr>
            <td><a href="/shows/${shows.get(i).id}"><c:out value="${shows.get(i).title}"/></a></td>
           	<td><c:out value="${shows.get(i).network}"/></td>
           	<td><c:out value="${countries.get(i)}"/></td>  	
        </tr>
       </c:forEach>
    </tbody>
</table>
	<a href="/shows/new" class="button">Create Show</a>
	<a href="/logout"  class="button">Logout</a>
	
</body>
</html>