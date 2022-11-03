<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
	<th>
		<td>Id</td>
		<td>Nombre</td>
		<td>Precio</td>
		<td></td>
	</th>
	<c:forEach items="${productos}" var="p">
		<tr>
			<td>${p.id}</td>
			<td>${p.nombre}</td>
			<td>${p.precio}</td>
			<td><a href="/productos/${p.id}">Ver</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>