package ejercicio2InterfacesGraficas;

import java.util.Objects;

public class Pokemon implements Comparable<Pokemon>{
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
		Pokemon other = (Pokemon) obj;
		return Objects.equals(nombre, other.nombre);
	}

	private String nombre;
	private String tipo;
	private int generación;
	private String estadoEvolutivo;
	private int puntos;

	public Pokemon(String nombre, String tipo, int generación, String estadoEvolutivo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.generación = generación;
		this.estadoEvolutivo = estadoEvolutivo;
		this.puntos = 0;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getGeneración() {
		return generación;
	}

	public void setGeneración(int generación) {
		this.generación = generación;
	}

	public String getEstadoEvolutivo() {
		return estadoEvolutivo;
	}

	public void setEstadoEvolutivo(String estadoEvolutivo) {
		this.estadoEvolutivo = estadoEvolutivo;
	}

	@Override
	public String toString() {
		return nombre + " (" + tipo + ") " + generación + "º Generación, " + estadoEvolutivo + " Puntos: " + puntos;
	}

	@Override
	public int compareTo(Pokemon o) {
		return this.getNombre().compareTo(o.getNombre());
	}

}
