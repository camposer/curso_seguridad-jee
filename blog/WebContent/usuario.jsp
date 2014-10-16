<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Registro de usuario</title>
	<style>
		.tablaFormulario {
			margin-left: auto;
			margin-right: auto; 
		}
		.errores {
			background-color: red;
		}
		h1 {
			text-align: center;
		}
	</style>
	<script src="../js/crypto-js/rollups/sha1.js"></script>
	<script>
		var registrar = function() {
			var form = document.forms['formUsuario'];
			var nombre = document.getElementById('nombre').value;
			var clave = document.getElementById('clave');
			var clave1 = document.getElementById('clave1').value;
			var clave2 = document.getElementById('clave2').value;
			
		    if (nombre && clave1 == clave2) {
			    clave.value = CryptoJS.SHA1(clave1);
		    	form.submit();
		    } else {
		    	alert('Verifique los datos');
		    }
		};
	</script>
</head>
<body>
	<h1>Registro de Usuarios</h1>
	<div class="errores">
		<c:forEach items="${errores}" var="e">
			${e}<br/>
		</c:forEach>
	</div>
	<form name="formUsuario" action="registrar" method="post">
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
				<td>Repetir clave:</td>
				<td><input type="password" id="clave2"/></td>
			</tr>		
			<tr>
				<td>Roles:</td>
				<td>
					<select name="rol">
						<c:forEach items="${roles}" var="rol">
							<option value="${rol}">${rol}</option>
						</c:forEach>				
					</select>
				</td>
			</tr>		
			<tr>
				<td colspan="2">
					<input type="button" onclick="registrar()" value="Agregar"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>