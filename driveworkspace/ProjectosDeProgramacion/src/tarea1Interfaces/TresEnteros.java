package tarea1Interfaces;

import funcionesImportantes.FuncionesBasicas;

public class TresEnteros implements Estadisticas<Integer> {
	Integer i1;
	Integer i2;
	Integer i3;

	public TresEnteros(Integer i1, Integer i2, Integer i3) {
		super();
		this.i1 = i1;
		this.i2 = i2;
		this.i3 = i3;
	}

	/**
	 * @return the i1
	 */
	public Integer getI1() {
		return i1;
	}

	/**
	 * @param i1 the i1 to set
	 */
	public void setI1(Integer i1) {
		this.i1 = i1;
	}

	/**
	 * @return the i2
	 */
	public Integer getI2() {
		return i2;
	}

	/**
	 * @param i2 the i2 to set
	 */
	public void setI2(Integer i2) {
		this.i2 = i2;
	}

	/**
	 * @return the i3
	 */
	public Integer getI3() {
		return i3;
	}

	/**
	 * @param i3 the i3 to set
	 */
	public void setI3(Integer i3) {
		this.i3 = i3;
	}

	@Override
	public Integer mayor() {
		if (i1 > i2 && i1 > i3) {
			return i1;
		} else if (i2 > i1 && i2 > i3) {
			return i2;
		} else {
			return i3;
		}
	}

	@Override
	public Integer menor() {
		if (i1 < i2 && i1 < i3) {
			return i1;
		} else if (i2 < i1 && i2 < i3) {
			return i2;
		} else {
			return i3;
		}
	}

	@Override
	public double media() {
		return FuncionesBasicas.calculoDeMedia(i1 + i2 + i3, 3);
	}

	@Override
	public Integer[] mayoresQue(Integer obj) {
		Integer[] theSilly = new Integer[3];
		int nElem = 0;
		if (i1 > obj) {
			theSilly[nElem++] = i1;
		}
		if (i2 > obj) {
			theSilly[nElem++] = i2;
		}
		if (i3 > obj) {
			theSilly[nElem++] = i3;
		}
		return theSilly;
	}

	@Override
	public Integer[] menoresQue(Integer obj) {
		Integer[] theSilly = new Integer[3];
		int nElem = 0;
		if (i1 < obj) {
			theSilly[nElem++] = i1;
		}
		if (i2 < obj) {
			theSilly[nElem++] = i2;
		}
		if (i3 < obj) {
			theSilly[nElem++] = i3;
		}
		return theSilly;
	}

}
