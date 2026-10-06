package ejercicio1Boletin1ProgramacionMultihilo;

public class Hilo1 extends Thread {
	public Hilo1(Teclado teclado) {
		super();
		this.teclado = teclado;
	}

	/**
	 * @return the teclado
	 */
	public Teclado getTeclado() {
		return teclado;
	}

	/**
	 * @param teclado the teclado to set
	 */
	public void setTeclado(Teclado teclado) {
		this.teclado = teclado;
	}

	private Teclado teclado;

	@Override
	public void run() {
		while (teclado.isTecladoPulsado()) {
			System.out.println("Servicios");
			Thread.yield();
		}
	}
}
