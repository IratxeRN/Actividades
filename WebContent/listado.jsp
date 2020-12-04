<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Productos</title>
</head>
<body>
<h1>Haz tu pedido</h1>
<form action="carrito" method="post">
<table>
	<thead>
		<tr>
			<th scope="col">Id</th>
			<th scope="col">Nombre</th>
			<th scope="col">Precio</th>
			<th scope="col">Cantidad</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${productos}" var="producto">
			<tr>
				<th scope="row">${producto.id}</th>
				<td>${producto.nombre}</td>
				<td>${producto.precio}</td>
				<td><input type=number min="0" name="${producto.id}" value="0"></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<button type="submit">Solicitud</button>
</form>
</body>
</html>