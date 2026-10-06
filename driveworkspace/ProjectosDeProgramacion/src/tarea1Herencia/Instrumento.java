package tarea1Herencia;

import java.util.Arrays;

abstract class Instrumento {
	protected final static int MAXIMONOTAS = 100;
	protected int nNotas = 0;
	protected NotaMusical[] notas = new NotaMusical[MAXIMONOTAS];

	public boolean addNota(NotaMusical notaAnyadir) {
		boolean puedoAnyadir = false;
		if (nNotas < MAXIMONOTAS) {
			notas[nNotas++] = notaAnyadir;
			puedoAnyadir = true;
		}
		return puedoAnyadir;
	}

	public abstract void interpretar();

	@Override
	public String toString() {
		return "Instrumento [nNotas=" + nNotas + ", notas=" + Arrays.toString(notas) + "]";
	}

	/**
	 * @return the nNotas
	 */
	public int getnNotas() {
		return nNotas;
	}

	/**
	 * @param nNotas the nNotas to set
	 */
	public void setnNotas(int nNotas) {
		this.nNotas = nNotas;
	}

	/**
	 * @return the maximonotas
	 */
	public static int getMaximonotas() {
		return MAXIMONOTAS;
	}

	/**
	 * @return the notas
	 */
	public NotaMusical[] getNotas() {
		return notas;
	}
}
