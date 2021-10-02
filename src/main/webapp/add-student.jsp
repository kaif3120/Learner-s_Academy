<%@page import="com.entity.Classes"%>
<%@page import="java.util.List"%>
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




	<div class="form-page">
		<main class="form-signin">

			<form action="add-student" method="post">
				<h2 style="margin-bottom: 20px">Add Student</h2>


				<div class="form-floating form">
					<label style="text-align: left;" for="fName">First Name</label> <input
						type="text" class="form-control" id="fName" name="fName"
						placeholder="first name">

				</div>

				<div class="form-floating form">
					<label style="text-align: left;" for="lName">Last Name</label> 
					<input type="text" class="form-control middle" name="lName" id="lName"
						placeholder="last Name">
				</div>

				<div class="form-floating form bottom">

					<label for="classes" >Choose Class:</label> 
					<select name="classId" id="classId" style="width: 300px">
					   
						<%
						List<Classes> classes = (List<Classes>) session.getAttribute("classList");
						for (Classes course : classes) {
						%>
						<option value="<%=course.getClassId()%>"><%=course.getClassName()%></option>

						<%
						}
						%>

					</select>

				</div>


				<p style="color: red">${errorMessage}</p>
				<p style="color: lime;">${successMessage}</p>

					<button class="primary form" type="submit">Add Student</button>
			</form>
		</main>

	</div>



	<%@include file="footer.jsp"%>

</body>
</html>