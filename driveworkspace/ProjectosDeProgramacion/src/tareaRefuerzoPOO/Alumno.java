package tareaRefuerzoPOO;

public class Alumno {
	private String nombre;
	private int edad;
	private long expediente;

	public Alumno(String nombre, int edad, long expediente) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.expediente = expediente;
	}

	public Alumno(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
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
	 * @return the expediente
	 */
	public long getExpediente() {
		return expediente;
	}

	/**
	 * @param expediente the expediente to set
	 */
	public void setExpediente(long expediente) {
		this.expediente = expediente;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", edad=" + edad + ", expediente=" + expediente + "]";
	}

}
