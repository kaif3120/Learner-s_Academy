<%@page import="java.util.List"%>
<%@page import="com.entity.Classes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <%@include file="Header.jsp"%>
 <%@include file="loginverifier.jsp" %>
    
	<h2>Class Master List</h2>

	


     	<div class="class-list">
		<%
		List<Classes> classes = (List) request.getAttribute("classesList");
		for (Classes course : classes) {
		%>
			<form action="show-classes" class="card ">
				<h2><%= course.getClassName() %> </h2>
				<input type="hidden" name="id" id="id" value="<%= course.getClassId()%>" >
				<button class="primary"  type="submit">Details</button>
			</form>        
      <% }%>
	</div>

	<%@include file="footer.jsp"%>

</body>
</html>