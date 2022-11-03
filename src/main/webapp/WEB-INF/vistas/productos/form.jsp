<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="productoForm" action="guardar.html" method="post">
		<table>
			<tr>
				<td>Id</td>
				<td><form:input path="id"/></td>
			</tr>
			<tr>
				<td>Nombre</td>
				<td><form:input path="nombre"/></td>
			</tr>
			<tr>
				<td>Precio</td>
				<td><form:input path="precio"/></td>
			</tr>
		</table>
		<button type="submit">Enviar datos</button>
	</form:form>
</body>
</html>