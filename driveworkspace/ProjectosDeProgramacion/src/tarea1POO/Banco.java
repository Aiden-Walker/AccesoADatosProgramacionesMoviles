package tarea1POO;

public class Banco {
	private final String NOMBRE;
	private long capital;
	private String direccionCentral;

	public Banco(String nombre, long capital, String direccionCentral) {
		super();
		NOMBRE = nombre;
		this.capital = capital;
		this.direccionCentral = direccionCentral;
	}

	public Banco(String nombre, String direccionCentral) {
		this(nombre, 5200000, direccionCentral);
	}

	@Override
	public String toString() {
		return "Banco [NOMBRE=" + NOMBRE + ", capital=" + capital + ", direccionCentral=" + direccionCentral + "]";
	}

	/**
	 * @return the capital
	 */
	public float getCapital() {
		return capital;
	}

	/**
	 * @param capital the capital to set
	 */
	public void setCapital(long capital) {
		this.capital = capital;
	}

	/**
	 * @return the direccionCentral
	 */
	public String getDireccionCentral() {
		return direccionCentral;
	}

	/**
	 * @param direccionCentral the direccionCentral to set
	 */
	public void setDireccionCentral(String direccionCentral) {
		this.direccionCentral = direccionCentral;
	}

	/**
	 * @return the nOMBRE
	 */
	public String getNOMBRE() {
		return NOMBRE;
	}

}
