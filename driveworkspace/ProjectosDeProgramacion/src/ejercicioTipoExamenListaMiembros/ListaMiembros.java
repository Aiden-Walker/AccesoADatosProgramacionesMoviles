package ejercicioTipoExamenListaMiembros;

import java.util.Arrays;

public class ListaMiembros {
	private Miembro tabla[];

	public Miembro[] getTabla() {
		return tabla;
	}

	public int getTamanyo() {
		return this.tabla.length;
	}

	public ListaMiembros() {
		this.tabla = new Miembro[0];
	}

	public void anyadeMiembro(Miembro m) {
		Miembro[] tablaNueva = new Miembro[this.getTamanyo() + 1];
		for (int i = 0; i < this.getTamanyo(); i++)
			tablaNueva[i] = this.tabla[i];
		tablaNueva[this.getTamanyo()] = m;
		this.tabla = tablaNueva;
	}

	public void anyadeMiembroSinRepetir(Miembro m) {
		if (!this.contieneMiembro(m)) {
			this.anyadeMiembro(m);
		}
	}

	public String toString() {
		return Arrays.toString(this.tabla);
	}

	public boolean contieneMiembro(Miembro m) {
		for (int i = 0; i < this.tabla.length; i++) {
			if (tabla[i].equals(m)) {
				return true;
			}
		}
		return false;
	}

	public void eliminaMiembro(Miembro m) {
		if (this.contieneMiembro(m)) {
			int memberIndex = getIndexOfMiembro(m, this.tabla);
			for (int i = memberIndex; i < this.tabla.length - 1; i++) {
				this.tabla[i] = this.tabla[i + 1];
			}
			Arrays.copyOf(this.tabla, this.tabla.length - 1);
		}
	}

	public int getIndexOfMiembro(Miembro mSearch, Miembro[] tableToSearch) {
		int indexFound = -1;
		boolean fnd = false;
		for (int counter = 0; counter < tableToSearch.length && !fnd; counter++) {
			if (tableToSearch[counter].equals(mSearch)) {
				indexFound = counter;
				fnd = true;
			}
		}
		return indexFound;
	}
}
