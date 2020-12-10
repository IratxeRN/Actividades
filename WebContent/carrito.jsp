<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<h1>Carrito de la compra</h1>

<table class="table table-bordered">
	<thead>
		<tr class="table-warning">
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Cantidad</th>
			<th>Total Producto</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${carrito}" var="producto">
			<tr>
				<td>${producto.value.id}</td>
				<td>${producto.value.nombre}</td>
				<td class="text-right"><fmt:formatNumber type="currency" value="${producto.value.precio}" /></td>
				<td class="text-right">${producto.value.cantidad}</td>
				<td class="text-right"><fmt:formatNumber type="currency" value="${producto.value.totalPorProducto()}" /></td>
			</tr>
		</c:forEach>
		<tr>
				<td></td>
				<td></td>
				<td></td>
				<td class="text-right font-weight-bold">TOTAL</td>
				<td class="text-right font-weight-bold"><fmt:formatNumber type="currency" value="${total}" /></td>
			</tr>
	</tbody>
</table>
<div class="text-center"><button type="button" class="btn btn-secondary">Pagar</button></div>
</body>
</html>