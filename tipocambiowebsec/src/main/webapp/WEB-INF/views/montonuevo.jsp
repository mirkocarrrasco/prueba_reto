<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Monto Calculado</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
	<h1>Monto Calculado:</h1>
	<br/>
	
	<% if (request.getAttribute("montodest") != null) {	%>	
	<h1 style="color:red;"><%= (double) request.getAttribute("montodest")	%></h1>	
	<%}%>	


</body>
</html>