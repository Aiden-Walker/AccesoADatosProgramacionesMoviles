package examenFinalProgramacionEV3;

import java.util.Objects;
import java.io.Serializable;
public class Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String dni;

	public Persona(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public String toString() {
		return nombre + " (" + dni + ")";
	}
}
