<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Inicio</title>
	<link type="text/css" rel="stylesheet" href="<%= getServletContext().getContextPath() %>/css/comun.css">
	<script src="<%= getServletContext().getContextPath() %>/js/crypto-js/rollups/sha1.js"></script>
	<script>
		var entrar = function() {
			var form = document.forms['formUsuario'];
			var clave = document.getElementById('clave');
			var clave1 = document.getElementById('clave1').value;
			
		    if (clave1) {
			    clave.value = CryptoJS.SHA1(clave1);
		    	form.submit();
		    } else {
		    	alert('Verifique los datos');
		    }
		};
	</script>
</head>
<body>
	<h1>¡Bienvenido!</h1>
	<div class="errores">
		<c:forEach items="${errores}" var="e">
			${e}<br/>
		</c:forEach>
	</div>
	<form name="formUsuario" action="usuario/autenticar" method="post">
		<table class="tablaFormulario">
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre" id="nombre"/></td>
			</tr>		
			<tr>
				<td>Clave:</td>
				<td>
					<input type="hidden" name="clave" id="clave"/>
					<input type="password" id="clave1"/>
				</td>
			</tr>		
			<tr>
				<td colspan="2">
					<input type="button" value="Entrar" onclick="entrar()"/>
				</td>
			</tr>
		</table>
	</form>
	<a href="<%= getServletContext().getContextPath() %>/usuario/">Registrar usuario</a>
</body>
</html>