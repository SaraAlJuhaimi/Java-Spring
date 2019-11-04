<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.HashMap" import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/checkerboard.css" />
</head>
<body>
<%
	int width = 0;
	int height = 0;
	if(request.getParameter("width") != null && request.getParameter("height") != null){
		width = Integer.parseInt(request.getParameter("width"));
		height = Integer.parseInt(request.getParameter("height"));
	}
	String [] color = {"one","two"};
%>
    <% for(int i = 0; i<height ; i++){ %>
    	<% for(int j = 0; j <width ; j++){ %>
	         <%if(j%2 == 0){%>
					<div class=<%= color[0]%>></div>
				<%} else {%>
					<div class=<%= color[1]%>></div>
				<%}%>    
    	<% } %>
				<br>  
				<%
					if(color[0].equals("one")){
						color[0]="two";
						color[1]="one";
					}
					else{
						color[0]="one";
						color[1]="two";
					}
				%>

    <% } %>
</body>

</html>