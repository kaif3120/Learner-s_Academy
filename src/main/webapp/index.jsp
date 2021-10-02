<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learner's Academy</title>
</head>
<body>

	<%@include file="Header.jsp"%>





	<div class="form-page">
		<main class="form-signin">

			<form action="login" method="post">
			<p style="color: red">${loginMessage}	</p>
				<h1>Welcome!</h1>
				<p class="form">sign in as admin</p>

				<div class="form-floating form">
					<label style="margin-left: 55px" for="floatingInput">Email address</label> <input type="email" 
						id="floatingInput" name="email" placeholder="name@example.com">

				</div>

				<div class="form-floating form bottom">
					<label style="margin-left: 55px"  for="password">Password</label> <input
						type="password" class=" middle" name="password"
						id="password" placeholder="password">
				</div>


				<p style="color: red">${errorMessage}	</p>

					<button class="primary form" type="submit">Login</button>
			</form>
		</main>

	</div>
	<%@include file="footer.jsp"%>

	
</body>
</html>