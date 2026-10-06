package ejercicioTipoExamenInventario;

import java.util.LinkedHashSet;
import java.util.Set;

public class Inventario {
	private Set<Producto> productos;

	public Inventario() {
		this.productos = new LinkedHashSet<>();
	}

	// devuelve true si el producto se añade, y false si no se añade porque ya
	// exista un producto igual en el Set.
	public boolean addProducto(Producto producto) {
		return productos.add(producto);
	}

	public Set<Producto> getProductos() {
		return productos;
	}
}
