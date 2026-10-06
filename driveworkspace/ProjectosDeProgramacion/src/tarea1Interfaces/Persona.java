package tarea1Interfaces;

public class Persona implements Comparable<Object> {
	private int edad;

	public Persona(int edad) {
		super();
		this.edad = edad;
	}

	@Override
	public int compareTo(Object o) {
		Persona p = (Persona) o;
		int res = 0;
		if (this.edad < p.edad) {
			res = -1;
		} else if (this.edad > p.edad) {
			res = 1;
		} else {
			res = 0;
		}
		return res;
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
}
