package ejTipoExamenFeria;

import java.util.Objects;

public class Consumicion {
	private Articulo Articulo;
	private int cantidad;

	public Consumicion(Articulo Articulo, int cantidad) {
		this.Articulo = Articulo;
		this.cantidad = cantidad;
	}

	public Articulo getArticulo() {
		return Articulo;
	}

	public void setArticulo(Articulo Articulo) {
		this.Articulo = Articulo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "    " + Articulo + "\t" + cantidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Articulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consumicion other = (Consumicion) obj;
		return Objects.equals(Articulo, other.Articulo);
	}

}
