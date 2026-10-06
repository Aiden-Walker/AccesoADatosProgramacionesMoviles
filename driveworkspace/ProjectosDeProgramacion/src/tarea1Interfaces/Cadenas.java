package tarea1Interfaces;

import java.util.Arrays;

import funcionesImportantes.FuncionesBasicas;

public class Cadenas implements Estadisticas<String> {
	private int nElem;
	private String[] theSillyStrings = new String[nElem];

	public Cadenas(String[] stringsToBuildWith) {
		super();
		this.theSillyStrings = stringsToBuildWith;
		for (int i = 0; i < stringsToBuildWith.length; i++) {
			if (stringsToBuildWith[i] != null) {
				nElem++;
			}
		}
	}

	/**
	 * @return the nElem
	 */
	public int getnElem() {
		return nElem;
	}

	/**
	 * @param nElem the nElem to set
	 */
	public void setnElem(int nElem) {
		this.nElem = nElem;
	}

	/**
	 * @return the theSillyStrings
	 */
	public String[] getTheSillyStrings() {
		return theSillyStrings;
	}

	/**
	 * @param theSillyStrings the theSillyStrings to set
	 */
	public void setTheSillyStrings(String[] theSillyStrings) {
		this.theSillyStrings = theSillyStrings;
	}

	@Override
	public String toString() {
		return "Cadenas [nElem=" + nElem + ", theSillyStrings=" + Arrays.toString(theSillyStrings) + "]";
	}

	@Override
	public String mayor() {
		String bigShot = theSillyStrings[0];
		for (int i = 0; i < nElem; i++) {
			if (theSillyStrings[i].compareTo(bigShot) > 0) {
				bigShot = theSillyStrings[i];
			}
		}
		return bigShot;
	}

	@Override
	public String menor() {
		String smallShot = theSillyStrings[0];
		for (int i = 0; i < nElem; i++) {
			if (theSillyStrings[i].compareTo(smallShot) < 0) {
				smallShot = theSillyStrings[i];
			}
		}
		return smallShot;
	}

	@Override
	public double media() {
		int lengthStrings = 0;
		for (int i = 0; i < nElem; i++) {
			lengthStrings += theSillyStrings[i].length();
		}
		return FuncionesBasicas.calculoDeMedia(lengthStrings, nElem);
	}

	@Override
	public String[] mayoresQue(String obj) {
		String[] bigShots = new String[nElem];
		for (int i = 0; i < nElem; i++) {
			if (theSillyStrings[i].compareTo(obj) > 0) {
				bigShots[i] = theSillyStrings[i];
			}
		}
		return bigShots;
	}

	@Override
	public String[] menoresQue(String obj) {
		String[] smallShots = new String[nElem];
		for (int i = 0; i < nElem; i++) {
			if (theSillyStrings[i].compareTo(obj) < 0) {
				smallShots[i] = theSillyStrings[i];
			}
		}
		return smallShots;
	}
}
