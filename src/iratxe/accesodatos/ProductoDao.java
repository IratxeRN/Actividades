package iratxe.accesodatos;

import java.util.TreeMap;

import iratxe.modelo.Producto;

public class ProductoDao {

	private static TreeMap<Integer, Producto> productos = new TreeMap<>();

	static {
		productos.put(111, new Producto(111, "Motores", 34347d, 0));
		productos.put(222, new Producto(222, "Escoba", 760d, 0));
		productos.put(333, new Producto(333, "Lapiz", 123d, 0));
		productos.put(444, new Producto(444, "Goma", 224d, 0));
		productos.put(555, new Producto(444, "Papel", 322d, 0));
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

}
