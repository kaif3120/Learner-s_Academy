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

			<form action="add-class" method="post">
				<h2 style="margin-bottom: 20px">Add Class</h2>


				<div class="form-floating form">
					<label style="text-align: left;" for="className">Class Name</label> <input
						type="text" class="form-control" id="className" name="className"
						placeholder="class name">

				</div>


				<p style="color: red">${errorMessage}</p>
				<p style="color: lime;">${successMessage}</p>

					<button class="primary form" type="submit">Add Class</button>
			</form>
		</main>

	</div>
<%@include file="footer.jsp"%>


</body>
</html>