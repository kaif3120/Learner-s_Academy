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

       <div class="class-list">
       <div class="card">
			<form action="classes">
				<h2>Classes master list</h2>
				<button class="primary"  type="submit">Details</button>
				<a href="add-class" class="add primary">Add</a>
			</form>
		</div>
		

		<div class="card ">
			<form action="students">
				<h2>Students master list</h2>
				<button class="primary"  type="submit">Details</button>
				<a href="add-student" class="add primary">Add</a>
			</form>
		</div>
		
		<div class="card ">
			<form action="teachers">
				<h2>Teacher master list</h2>
				<button class="primary"  type="submit">Details</button>
				<a href="add-teacher" class="add primary" >Add</a>
			</form>
		</div>
		
		<div class="card">
			<form action="subjects">
				<h2>Subjects master list</h2>
				<button class="primary"  type="submit">Details</button>
				<a href="add-subject" class="add primary">Add</a>
			</form>
		</div>
	</div>

	<%@include file="footer.jsp"%>

</body>
</html>