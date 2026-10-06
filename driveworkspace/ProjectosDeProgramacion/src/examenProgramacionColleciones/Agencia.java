package examenProgramacionColleciones;

import java.util.Objects;

public class Agencia {
	private String nombre;
	private String cif;

	public Agencia(String nombre, String cif) {
		this.nombre = nombre;
		this.cif = cif;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cif);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agencia other = (Agencia) obj;
		return Objects.equals(cif, other.cif);
	}

	public String getNombre() {
		return nombre;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Agencia [nombre=" + nombre + ", cif=" + cif + "]";
	}

}
