package ejTipoExamenAnimales;

import java.util.*;

public class Animal implements Comparable<Animal> {
	private String nombre;
	private HashSet<Animal> presas;

	public Animal(String nombre, HashSet<Animal> presas) {
		super();
		this.nombre = nombre;
		this.presas = presas;
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
	 * @return the presas
	 */
	public HashSet<Animal> getPresas() {
		return presas;
	}

	/**
	 * @param presas the presas to set
	 */
	public void setPresas(HashSet<Animal> presas) {
		this.presas = presas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, presas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(presas, other.presas);
	}

	@Override
	public int compareTo(Animal o) {
		return this.getNombre().compareTo(o.getNombre());
	}

}
