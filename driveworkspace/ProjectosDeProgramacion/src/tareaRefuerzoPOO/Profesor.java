package tareaRefuerzoPOO;

public class Profesor {
	private String nombre;
	private int edad;
	private String especialidad;

	public Profesor(String nombre, int edad, String especialidad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.especialidad = especialidad;
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
	 * @return the especialidad
	 */
	public String getEspecialidad() {
		return especialidad;
	}

	/**
	 * @param especialidad the especialidad to set
	 */
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return "Profesor [nombre=" + nombre + ", edad=" + edad + ", especialidad=" + especialidad + "]";
	}

}
