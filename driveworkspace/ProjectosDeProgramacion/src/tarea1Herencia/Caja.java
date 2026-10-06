package tarea1Herencia;

public class Caja {
	protected final int alto;
	protected final int ancho;
	protected final int fondo;
	protected String destinatario;
	protected Unidades u;

	public Caja(int alto, int ancho, int fondo, Unidades u) {
		super();
		this.alto = alto;
		this.ancho = ancho;
		this.fondo = fondo;
		this.u = u;
	}

	/**
	 * @return the alto
	 */
	public int getAlto() {
		return alto;
	}

	/**
	 * @return the fondo
	 */
	public int getFondo() {
		return fondo;
	}

	public double getVolumen() {
		return alto * ancho * fondo;
	}

	@Override
	public String toString() {
		return "Caja [alto=" + alto + ", ancho=" + ancho + ", fondo=" + fondo + ", getVolumen()=" + getVolumen() + "]";
	}
}
