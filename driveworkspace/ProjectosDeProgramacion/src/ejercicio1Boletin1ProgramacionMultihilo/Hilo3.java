package ejercicio1Boletin1ProgramacionMultihilo;

public class Hilo3 extends Thread {
	/**
	 * @return the keyboard
	 */
	public Teclado getKeyboard() {
		return keyboard;
	}

	/**
	 * @param keyboard the keyboard to set
	 */
	public void setKeyboard(Teclado keyboard) {
		this.keyboard = keyboard;
	}

	public Hilo3(Teclado keyboard) {
		super();
		this.keyboard = keyboard;
	}

	Teclado keyboard;

	@Override
	public void run() {
		while (true) {
			if (keyboard.isTecladoPulsado()) {
			}
		}
	}

}
