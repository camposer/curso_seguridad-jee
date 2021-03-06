<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Inicio</title>
	<link type="text/css" rel="stylesheet" href="<%= getServletContext().getContextPath() %>/css/comun.css">
</head>
<body>
	<h1>¡Bienvenido!</h1>
	<div class="errores">
		<c:forEach items="${errores}" var="e">
			${e}<br/>
		</c:forEach>
	</div>
	<a href="<%= getServletContext().getContextPath() %>/usuario/">Registrar usuario</a><br/>
	<a href="<%= getServletContext().getContextPath() %>/articulo/">Gestionar artículos</a>
</body>
</html>