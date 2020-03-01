<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de usuario</title>
</head>
<body>
	<form action="cargarListado" method="post">
		<input type="submit" value="ver listado">
	</form>

	<table border="1">
		<thead>
			<tr>
				<td>Codigo</td>
				<td>Nombre</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="poke" items="${pokes}">
				<tr>
					<td><c:out value="${poke.codigo}" /></td>
					<td><c:out value="${poke.nombre}" /></td>
					<td><a href="/delete?dni=${poke.codigo}">borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<select>
		<c:forEach var="poke" items="${pokes}">
			<option value="${poke.nombre}">${poke.nombre}</option>
		</c:forEach>
	</select>

</body>
</html>