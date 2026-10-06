package ejSemaforos;

public class Saludo {
	private boolean hallegado;

	public Saludo() {
		this.hallegado = false;
	}

	public synchronized void saludoEmpleado(String nombre) {
		try {
			/* hi guys */
			if (this.hallegado == false) {
				System.out.println("A mimir " + nombre);
				wait();
				System.out.println("\n" + nombre.toUpperCase() + ":= Buenos días JEFE.");
			} else {
				System.out.println("\nSoy " + nombre + " perdón por la tardanza.");
			}
		} catch (InterruptedException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public synchronized void saludoJefe(String nombre) {
		System.out.println("\n****" + nombre.toUpperCase() + ":= Buenos días EMPLEADOS.****");
		this.hallegado = true;
		notifyAll();
	}
}
