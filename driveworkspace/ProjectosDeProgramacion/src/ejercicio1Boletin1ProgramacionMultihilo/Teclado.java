package ejercicio1Boletin1ProgramacionMultihilo;

import java.util.Scanner;

public class Teclado {
	Scanner sc = new Scanner(System.in);
	private boolean tecladoPulsado = false;

	/**
	 * @return the tecladoPulsado
	 */
	public boolean isTecladoPulsado() {
		tecladoPulsado = sc.hasNext();
		return tecladoPulsado;
	}

	/**
	 * @param tecladoPulsado the tecladoPulsado to set
	 */
	public void setTecladoPulsado(boolean tecladoPulsado) {
		this.tecladoPulsado = tecladoPulsado;
	}

}
