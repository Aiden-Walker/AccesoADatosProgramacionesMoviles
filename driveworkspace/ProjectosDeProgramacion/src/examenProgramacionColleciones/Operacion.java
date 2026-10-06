package examenProgramacionColleciones;

public class Operacion {
	private Vivienda vivienda;
	private float precioFinal;
	private String fecha; // Formato AAAA-MM-DD
	private boolean esAlquiler;

	public Operacion(Vivienda vivienda, float precioFinal, String fecha, boolean esAlquiler) {
		this.vivienda = vivienda;
		this.precioFinal = precioFinal;
		this.fecha = fecha;
		this.esAlquiler = esAlquiler;
	}

	public Vivienda getVivienda() {
		return vivienda;
	}

	public float getPrecioFinal() {
		return precioFinal;
	}

	public boolean isEsAlquiler() {
		return esAlquiler;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}

	public void setPrecioFinal(float precioFinal) {
		this.precioFinal = precioFinal;
	}

	public void setEsAlquiler(boolean esAlquiler) {
		this.esAlquiler = esAlquiler;
	}

	@Override
	public String toString() {
		return "Operacion [vivienda=" + vivienda + ", precioFinal=" + precioFinal + ", fecha=" + fecha + ", esAlquiler="
				+ esAlquiler + "]";
	}

}
