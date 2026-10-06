package ejercicioTipoExamenVistaComercial;

import java.util.Objects;

public class Empresa implements Comparable<Empresa> {
	private String nombre;
	private float compras;

	public Empresa(String nombre, float compras) {
		super();
		this.nombre = nombre;
		this.compras = compras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getCompras() {
		return compras;
	}

	public void setCompras(float compras) {
		this.compras = compras;
	}

	@Override
	public String toString() {
		return nombre;
	}

	@Override
	public int compareTo(Empresa o) {
		int res;
		if (this.getCompras() > o.getCompras()) {
			res = 1;
		} else if (o.getCompras() > this.getCompras()) {
			res = -1;
		} else {
			res = 0;
		}
		return res;
	}

	@Override
	public int hashCode() {
		return Objects.hash(compras, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Float.floatToIntBits(compras) == Float.floatToIntBits(other.compras)
				&& Objects.equals(nombre, other.nombre);
	}

}
