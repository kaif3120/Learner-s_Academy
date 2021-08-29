<%@page import="com.entity.Student"%>
<%@page import="com.entity.Subject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
h1{
 text-align: center;
}
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>

		<% List<Student> students = (List) request.getAttribute("stdList");%>
         <h1><%= students.get(0).getCourse().getClassName() %></h1>

	<h2>Students Details</h2>

	<table>
		<tr>
			<th>Roll-NO.</th>
			<th>First-Name</th>
			<th>Last-Name</th>
		</tr>

		<%
		for (Student std : students) {
		%>

		<tr>
			<td><%= std.getRollNo() %></td>
			<td><%= std.getfName() %></td>
			<td><%= std.getlName() %></td>
		</tr>

		<%
		}
		%>

	</table>


<h2>Subject  Details</h2>

	<table>
		<tr>
			<th>Subject_Id</th>
			<th>Subject</th>
			<th>Teacher</th>
		</tr>

		<%
	List<Subject> subjects = (List) request.getAttribute("subList");
	for (Subject sub : subjects) {
	%>
		<tr>
		    <td><%=sub.getSubjectId()%></td>
			<td><%=sub.getSubjectName()%></td>
			
			<td><%= sub.getTeacher().getfName()%> <%= sub.getTeacher().getlName()%> </td>
		</tr>

		<%
		}
		%>

	</table>
	

	
		

	







</body>
</html>