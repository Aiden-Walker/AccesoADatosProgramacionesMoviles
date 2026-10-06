package tarea1Interfaces;

import java.util.Objects;

public abstract class Mascota implements Comparable<Mascota> {
	protected String nombre;
	protected int edad;
	protected Origen origen;

	public Mascota(String nombre, int edad, Origen origen) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.origen = origen;
	}

	@Override
	public int compareTo(Mascota m2) {
		int result = this.getEdad() - m2.getEdad();
		if (result == 0) {
			result = this.getNombre().compareTo(m2.getNombre());
		}
		return result;
	}

	@Override
	public int hashCode() {
		return Objects.hash(edad, nombre, origen);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mascota other = (Mascota) obj;
		return edad == other.edad && Objects.equals(nombre, other.nombre) && origen == other.origen;
	}

	@Override
	public String toString() {
		return "Mascota [nombre=" + nombre + ", edad=" + edad + ", origen=" + origen + "]";
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the origen
	 */
	public Origen getOrigen() {
		return origen;
	}

	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(Origen origen) {
		this.origen = origen;
	}

}
