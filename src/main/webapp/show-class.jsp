<%@page import="com.entity.Student"%>
<%@page import="com.entity.Subject"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class details</title>

<style>

</style>
</head>


<body>
	<%@include file="Header.jsp"%>
	<%@include file="loginverifier.jsp" %>

	<%
	String className = (String)request.getAttribute("className");
	List<Student> students = (List) request.getAttribute("std1List");
	List<Subject> subjects = (List) request.getAttribute("sub1List");
	System.out.println(students.size() + " " + subjects.size());
	%>
	
	<h1  style="margin-bottom: 15px"><%=className%></h1>

	<h2>Students Details</h2>

      <% if(students.size() == 0){%>	
			<h3 style="margin:50px auto; text-align: center;"> No students record to show </h3>
	     <%}else{ %>		
			
	<table class="table">
		<tr>
			<th>Roll-NO.</th>
			<th>First-Name</th>
			<th>Last-Name</th>
		</tr>

		
		<% 
		for (Student std : students) {
		%>

		<tr>
			<td><%=std.getRollNo()%></td>
			<td><%=std.getfName()%></td>
			<td><%=std.getlName()%></td>
		</tr>

		<%}%>
    </table>
     <%} %>

     <h2>Subject Details</h2>

  <% if(subjects.size() == 0){%>	
			<h3 style="margin:50px auto; text-align: center"> No subjects record to show </h3>
	     <%}else{ %>	

	

	<table class="table">
		<tr>
			<th>Subject_Id</th>
			<th>Subject</th>
			<th>Teacher</th>
		</tr>

		<%
		
		for (Subject sub : subjects) {
		%>
		<tr>
			<td><%=sub.getSubjectId()%></td>
			<td><%=sub.getSubjectName()%></td>

			<td><%=sub.getTeacher().getfName()%> <%=sub.getTeacher().getlName()%>
			</td>
		</tr>

		<%
		}
		%>
    </table>
 <%} %>


	<%@include file="footer.jsp"%>

</body>
</html>