package ejercicioTipoExamenGuerra;

import java.util.Arrays;

public class Pais {
	private String nombre; // nombre del país
	private Guerra tablaGuerras[]; // guerras en las que ha participado este país.
	private int nGuerras; // número de elementos en la tabla.
	public static final int MAX_GUERRAS = 10; // constante con el máximo de guerras permitido en un país.

	public boolean equals(Pais paisAEcualizar) {
		boolean sonIguales = false;
		if (this.nombre.equals(paisAEcualizar.nombre)) {
			sonIguales = true;
		}
		return sonIguales;
	}

	public Pais(String nombre) {
		this.nombre = nombre;
		this.tablaGuerras = new Guerra[Pais.MAX_GUERRAS];
		this.nGuerras = 0;
	}

	@Override
	public String toString() {
		return nombre;
	}

	public void participóEn(Guerra guerra) {
		this.tablaGuerras[this.nGuerras++] = guerra;

	}

	public Pais[] posiblesEnemigos() {
		Pais[] enemies = new Pais[Bando.MAX_PAISES * 10];
		int nEnemies = 0;
		for (int i = 0; i < nGuerras; i++) {
			if (this.tablaGuerras[i].getBandoA().estaPais(this)) {
				for (int j = nEnemies; j < this.tablaGuerras[i].getBandoB().getnPaises(); j++) {
					if (Gestion.anyadePaisSinRepetir(this.tablaGuerras[i].getBandoB().getPais(j), enemies, nEnemies)) {
						nEnemies++;
					}
				}
			} else {
				for (int j = nEnemies; j < this.tablaGuerras[i].getBandoA().getnPaises(); j++) {
					if (Gestion.anyadePaisSinRepetir(this.tablaGuerras[i].getBandoA().getPais(j), enemies, nEnemies)) {
						nEnemies++;
					}

				}
			}
		}
		enemies = Arrays.copyOf(enemies, nEnemies);
		return enemies;
	}

	public boolean haSidoAliadoDe(Pais pais) {
		boolean thisTrue = false;
		for (int i = 0; i < nGuerras; i++) {
			if (this.tablaGuerras[i].getBandoA().estaPais(this) && this.tablaGuerras[i].getBandoA().estaPais(pais)
					|| this.tablaGuerras[i].getBandoB().estaPais(this)
							&& this.tablaGuerras[i].getBandoB().estaPais(pais)) {
				thisTrue = true;
			}
		}
		return thisTrue;
	}

	public int getNBatallas() {
		int numBatallas = 0;
		for (int i = 0; i < nGuerras; i++) {
			for (int j = 0; j < tablaGuerras[i].getnBatallas(); j++) {
				if (tablaGuerras[i].getTablaBatallas()[j].getPais1().equals(this)
						|| tablaGuerras[i].getTablaBatallas()[j].getPais2().equals(this)) {
					numBatallas++;
				}
			}
		}
		return numBatallas;
	}

}