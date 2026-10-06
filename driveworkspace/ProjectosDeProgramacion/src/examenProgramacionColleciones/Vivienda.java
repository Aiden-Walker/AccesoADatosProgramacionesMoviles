package examenProgramacionColleciones;

import java.util.Objects;

public class Vivienda implements Comparable<Vivienda> {
	private String referenciaCatastral;
	private float precioActual;
	private Ciudad ubicacion;
	private Persona duenyo; // Persona que posee la casa

	public Vivienda(String ref, float precio, Ciudad ubicacion, Persona duenyo) {
		this.referenciaCatastral = ref;
		this.precioActual = precio;
		this.ubicacion = ubicacion;
		this.duenyo = duenyo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(duenyo, referenciaCatastral);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vivienda other = (Vivienda) obj;
		return Objects.equals(duenyo, other.duenyo) && Objects.equals(referenciaCatastral, other.referenciaCatastral);
	}

	public String getReferenciaCatastral() {
		return referenciaCatastral;
	}

	public Persona getDuenyo() {
		return duenyo;
	}

	public Ciudad getUbicacion() {
		return ubicacion;
	}

	public float getPrecioActual() {
		return precioActual;
	}

	public void setPrecioActual(float precioActual) {
		this.precioActual = precioActual;
	}

	public void setReferenciaCatastral(String referenciaCatastral) {
		this.referenciaCatastral = referenciaCatastral;
	}

	public void setUbicacion(Ciudad ubicacion) {
		this.ubicacion = ubicacion;
	}

	public void setDuenyo(Persona duenyo) {
		this.duenyo = duenyo;
	}

	@Override
	public String toString() {
		return "Vivienda [referenciaCatastral=" + referenciaCatastral + ", precioActual=" + precioActual
				+ ", ubicacion=" + ubicacion + ", duenyo=" + duenyo + "]";
	}

	@Override
	public int compareTo(Vivienda o) {
		int res = (int) (this.getPrecioActual() - o.getPrecioActual());
		if (res == 0) {
			res = this.getReferenciaCatastral().compareTo(o.getReferenciaCatastral());
		}
		return res;
	}

}