package ejercicio1Boletin1ProgramacionMultihilo;

public class Hilo2 extends Thread {
	Teclado teclado;

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

	public Hilo2(Teclado teclado) {
		super();
		this.teclado = teclado;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("Procesos");
			Thread.yield();
		}
	}
}
