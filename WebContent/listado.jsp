<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<h1>Haz tu pedido</h1>
<form action="carrito" method="post">
<table class="table table-bordered">
	<thead>
		<tr class="table-warning">
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
				<td class="text-right"><fmt:formatNumber type="currency" value="${producto.precio}" /></td>
				<td><input type=number min="0" name="${producto.id}" value="0"></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div class="text-center"><button type="submit" class="btn btn-secondary">Enviar Productos al Carrito</button></div>
</form>
</body>
</html>