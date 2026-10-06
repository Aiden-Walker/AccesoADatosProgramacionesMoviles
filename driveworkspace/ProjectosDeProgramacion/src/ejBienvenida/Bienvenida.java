package ejBienvenida;

public class Bienvenida {

	boolean clase_comenzada;

	public Bienvenida() {
		this.clase_comenzada = false;
	}

	public synchronized void saludarProfesor() {
		try {
			if (!clase_comenzada) {
				wait();
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	public synchronized void llegadaProfesor(String nombre) {
		// ¿Sería necesaria la siguiente instrucción?
		// this.clase_comenzada = true;
		notifyAll();
	}
}