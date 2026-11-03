package examenU1_26_10_2026;

import java.io.Serializable;

public class Evaluacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigoModelo;
	private String nombreBenchmark;
	private double puntuacion;

	public Evaluacion(String codigoModelo, String nombreBenchmark, double puntuacion) {
		this.codigoModelo = codigoModelo;
		this.nombreBenchmark = nombreBenchmark;
		this.puntuacion = puntuacion;
	}

	public String getCodigoModelo() {
		return codigoModelo;
	}

	public void setCodigoModelo(String codigoModelo) {
		this.codigoModelo = codigoModelo;
	}

	public String getNombreBenchmark() {
		return nombreBenchmark;
	}

	public void setNombreBenchmark(String nombreBenchmark) {
		this.nombreBenchmark = nombreBenchmark;
	}

	public double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}

	@Override
	public String toString() {
		return "[" + codigoModelo + "] " + nombreBenchmark + ": " + puntuacion + "%";
	}

}
