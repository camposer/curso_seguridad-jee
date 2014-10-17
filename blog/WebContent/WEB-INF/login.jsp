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
	<form name="formUsuario" action="j_security_check" method="post">
		<table class="tablaFormulario"> 
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="j_username"/></td>
			</tr>		
			<tr>
				<td>Clave:</td>
				<td>
					<input type="password" name="j_password"/>
				</td>
			</tr>		
			<tr>
				<td colspan="2">
					<input type="submit" value="Entrar"/>
					<input type="button" onclick="window.location.href='../'"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>