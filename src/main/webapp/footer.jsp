<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    footer{
    padding: 20px;
    text-align: center;
    
  }
  .copyright{
    color: rgb(109, 109, 109);
    font-size: 18px;
    display: inline-block;
    padding: 20px;
    border-top: 1px solid rgb(100, 100, 100);
  }
</style>
</head>
<body>

<%
  int year =  Calendar.getInstance().get(Calendar.YEAR);
%>
<footer>
    <div class="copyright"> &copy; <%=year%> Mohd Kaif. </div> 
</footer>

</body>
</html>