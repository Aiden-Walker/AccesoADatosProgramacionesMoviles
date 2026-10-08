package ficherosXML;

public class Ingrediente {
	String nombre;

	public Ingrediente(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Ingrediente [nombre=" + nombre + "]";
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
}
