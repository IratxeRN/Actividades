package iratxe.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iratxe.accesodatos.ProductoDao;
import iratxe.modelo.Producto;

/**
 * Servlet implementation class CarritoServlet
 */
@WebServlet("/carrito")
public class CarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductoDao dao = ProductoDao.getInstancia();

		Iterable<Producto> productos = dao.obtenerTodos();

		request.setAttribute("productos", productos);
		// response.getWriter().println(productos);
		request.getRequestDispatcher("listado.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Enumeration<String> nameId = request.getParameterNames();

		ProductoDao dao = ProductoDao.getInstancia();

		TreeMap<Integer, Producto> carrito = new TreeMap<>();

		Integer id, cantidad;
		String sId;
		Producto producto;
		BigDecimal totalProducto;
		BigDecimal total = new BigDecimal(0);

		while (nameId.hasMoreElements()) {

			sId = nameId.nextElement();
			id = Integer.parseInt(sId);
			cantidad = Integer.parseInt(request.getParameter(sId));

			if (cantidad > 0) {

				producto = dao.buscarPorId(id);
				producto.setCantidad(cantidad);
				producto.getPrecio();
				/*
				 * totalProducto = producto.getPrecio().multiply(new
				 * BigDecimal(producto.getCantidad()));
				 */
				totalProducto = producto.totalPorProducto();
				total = total.add(totalProducto);
				carrito.put(id, producto);
			}
		}

		request.getSession().setAttribute("carrito", carrito);
		request.getSession().setAttribute("total", total);
		request.getRequestDispatcher("/carrito.jsp").forward(request, response);
	}

}
