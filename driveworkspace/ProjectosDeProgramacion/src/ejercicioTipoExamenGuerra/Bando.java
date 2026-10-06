package ejercicioTipoExamenGuerra;

import java.util.Objects;

public class Bando {

	private String nombre; // nombre del bando
	private Pais tablaPaises[]; // países que formaron este bando
	private int nPaises; // número de países en la tabla
	public static final int MAX_PAISES = 10; // máximo.

	public Bando(String nombre) {
		this.nombre = nombre;
		this.tablaPaises = new Pais[Bando.MAX_PAISES];
		this.nPaises = 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nPaises);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bando other = (Bando) obj;
		boolean iguales = true;
		if (other.nPaises != this.nPaises) {
			iguales = false;
		}
		for (int i = 0; i < this.getnPaises(); i++) {
			if (!other.estaPais(this.tablaPaises[i])) {
				iguales = false;
			}
		}
		return iguales;
	}

	public void anyadePais(Pais pais) {
		this.tablaPaises[nPaises++] = pais;
	}

	public Pais getPais(int indiceAGettear) {
		Pais paisGetteado = this.tablaPaises[indiceAGettear];
		return paisGetteado;
	}

	public String toString() {
		String cad = nombre + "\n";
		for (int i = 0; i < this.nPaises; i++)
			cad += "                      - " + this.tablaPaises[i] + "\n";
		return cad;
	}

	public int getnPaises() {
		return nPaises;
	}

	public boolean estaPais(Pais pAComprobar) {
		boolean estaPais = false;
		int counter = 0;
		while (counter < nPaises && !estaPais) {
			if (this.tablaPaises[counter].equals(pAComprobar)) {
				estaPais = true;
			}
			counter++;
		}
		return estaPais;
	}
}
