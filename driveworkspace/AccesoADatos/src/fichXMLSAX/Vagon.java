package fichXMLSAX;

import java.io.Serializable;

class Vagon implements Serializable {
	private int capacidadMax;
	private int capacidadActual;
	private String tipoMercancia;

	public Vagon(int capacidadMax, int capacidadActual, String tipoMercancia) {
		super();
		this.capacidadMax = capacidadMax;
		this.capacidadActual = capacidadActual;
		this.tipoMercancia = tipoMercancia;
	}

	public Vagon() {
		super();
	}

	public int getCapacidadMax() {
		return capacidadMax;
	}

	public void setCapacidadMax(int capacidadMax) {
		this.capacidadMax = capacidadMax;
	}

	public int getCapacidadActual() {
		return capacidadActual;
	}

	public void setCapacidadActual(int capacidadActual) {
		this.capacidadActual = capacidadActual;
	}

	public String getTipoMercancia() {
		return tipoMercancia;
	}

	public void setTipoMercancia(String tipoMercancia) {
		this.tipoMercancia = tipoMercancia;
	}

	@Override
	public String toString() {
		return "Vagon [capacidadMax=" + capacidadMax + ", capacidadActual=" + capacidadActual + ", tipoMercancia="
				+ tipoMercancia + "]";
	}

}
