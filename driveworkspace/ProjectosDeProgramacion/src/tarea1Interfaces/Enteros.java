package tarea1Interfaces;

import java.util.Arrays;

import funcionesImportantes.FuncionesBasicas;

public class Enteros implements Estadisticas<Integer> {
	private int nElem;
	private Integer[] integers = new Integer[nElem];

	public Enteros(Integer[] integers) {
		super();
		this.integers = integers;
		for (int i = 0; i < integers.length; i++) {
			if (integers[i] != null) {
				nElem++;
			}
		}
	}

	@Override
	public String toString() {
		return "Enteros [integers=" + Arrays.toString(integers) + "]";
	}

	/**
	 * @return the integers
	 */
	public Integer[] getIntegers() {
		return integers;
	}

	/**
	 * @param integers the integers to set
	 */
	public void setIntegers(Integer[] integers) {
		this.integers = integers;
	}

	@Override
	public Integer mayor() {
		Integer bigger = Integer.MIN_VALUE;
		for (int i = 0; i < integers.length; i++) {
			if (integers[i] > bigger) {
				bigger = integers[i];
			}
		}
		return bigger;
	}

	@Override
	public Integer menor() {
		Integer lesser = Integer.MAX_VALUE;
		for (int i = 0; i < integers.length; i++) {
			if (integers[i] < lesser) {
				lesser = integers[i];
			}
		}
		return lesser;
	}

	@Override
	public double media() {
		int total = 0;
		for (int i = 0; i < nElem; i++) {
			total += integers[i];
		}
		return FuncionesBasicas.calculoDeMedia(total, nElem);
	}

	@Override
	public Integer[] mayoresQue(Integer obj) {
		Integer[] theSkibidi = new Integer[nElem];
		for(int i = 0; i<nElem;i++) {
			if(integers[i]>obj) {
				theSkibidi[i]=integers[i];
			}
		}
		return theSkibidi;
	}

	@Override
	public Integer[] menoresQue(Integer obj) {
		Integer[] theSkibidi = new Integer[nElem];
		for(int i = 0; i<nElem;i++) {
			if(integers[i]<obj) {
				theSkibidi[i]=integers[i];
			}
		}
		return theSkibidi;
	}

}
