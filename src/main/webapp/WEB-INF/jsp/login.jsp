<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://www.springframework.org/tags/form" 
prefix = "form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulario de datos</title>
</head>
<body>
	<span>ATROZ</span>
	<form:form action="welcome" method="post">
		<span>codigo:</span> 
		<form:input  type="text" path="codigo"/><br/>
		<span>nombre:</span> 
		<form:input type="text" path="nombre"/> <br/>
		<input type="submit"/>
	</form:form>
	</body>
</html>