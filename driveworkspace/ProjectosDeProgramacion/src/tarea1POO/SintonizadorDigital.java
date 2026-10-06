package tarea1POO;

public class SintonizadorDigital {
	private float frecuencia;
	private static final float SALTO = 0.5f;
	private static final float BAJADA = 0.5f;

	public SintonizadorDigital(float frecuencia) {
		super();
		this.setFrecuencia(frecuencia);
	}

	/**
	 * @return the frecuencia
	 */
	public float getFrecuencia() {
		return frecuencia;
	}

	/**
	 * @param frecuencia the frecuencia to set
	 */
	public void setFrecuencia(float frecuencia) {
		if (frecuencia > 80 && frecuencia < 108) {
			this.frecuencia = frecuencia;
		}
	}

	public void up() {
		if ((this.frecuencia += SintonizadorDigital.SALTO) > 108) {
			this.frecuencia = 80;
		} else {
			this.frecuencia += SintonizadorDigital.SALTO;
		}
	}

	public void down() {
		if ((this.frecuencia -= SintonizadorDigital.BAJADA) < 80) {
			this.frecuencia = 108;
		} else {
			this.frecuencia -= SintonizadorDigital.BAJADA;
		}
	}

	@Override
	public String toString() {
		return "SintonizadorDigital [frecuencia=" + frecuencia + "]";
	}
}
