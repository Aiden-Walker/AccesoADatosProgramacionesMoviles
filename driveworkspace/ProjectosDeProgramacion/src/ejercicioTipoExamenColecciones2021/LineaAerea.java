package ejercicioTipoExamenColecciones2021;

import java.util.Objects;

public class LineaAerea implements Comparable<LineaAerea> {

	private String nombre;
	private int numAviones;

	public LineaAerea(String nombre, int numAviones) {
		this.nombre = nombre;
		this.numAviones = numAviones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumAviones() {
		return numAviones;
	}

	public void setNumAviones(int numAviones) {
		this.numAviones = numAviones;
	}

	@Override
	public String toString() {
		return nombre;
	}

	@Override
	public int compareTo(LineaAerea o) {
		return this.nombre.compareTo(o.getNombre());
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineaAerea other = (LineaAerea) obj;
		return Objects.equals(nombre, other.nombre);
	}
}
