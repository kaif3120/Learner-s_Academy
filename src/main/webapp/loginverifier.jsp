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

String username = (String) session.getAttribute("username");
if (username == null){
	   request.getSession().setAttribute("loginMessage", "Please sign in first");
	   response.sendRedirect("index.jsp");
}

%>
<div style= "text-align:center; margin:20px auto">
<a class="add primary" href="masterlist.jsp"> Menu  </a>
<a class="add primary" href="logout">Logout</a>
</div>

</body>
</html>