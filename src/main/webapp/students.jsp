<%@page import="java.util.List"%>
<%@page import="com.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%
       List<Student> students = (List) request.getAttribute("stdList");
       for(Student std:students){ %>
    	
    	  <p>  <%= std.getRollNo() %>  <%= std.getfName() %>  </p>    	  
    	   
       <% } %>

</body>
</html>