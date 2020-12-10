package iratxe.accesodatos;

import java.math.BigDecimal;
import java.util.TreeMap;

import iratxe.modelo.Producto;

public class ProductoDao {

	private static TreeMap<Integer, Producto> productos = new TreeMap<>();

	static {
		productos.put(111, new Producto(111, "Motores", new BigDecimal(34347), 0));
		productos.put(222, new Producto(222, "Escoba", new BigDecimal(760), 0));
		productos.put(333, new Producto(333, "Lapiz", new BigDecimal(123), 0));
		productos.put(444, new Producto(444, "Goma", new BigDecimal(224d), 0));
		productos.put(555, new Producto(555, "Papel", new BigDecimal(322), 0));
	}

	private ProductoDao() {
	}

	private static ProductoDao INSTANCIA = new ProductoDao();

	public static ProductoDao getInstancia() {
		return INSTANCIA;
	}

	public Iterable<Producto> obtenerTodos() {
		return productos.values();
	}

	public Producto buscarPorId(int id) {
		return productos.get(id);
	}

}
