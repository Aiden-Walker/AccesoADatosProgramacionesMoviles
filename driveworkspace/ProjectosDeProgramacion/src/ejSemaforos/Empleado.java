package ejSemaforos;

public class Empleado extends Thread {
	String nombre;
	Saludo saludo;
	boolean es_Jefe;

	public Empleado(String nombre, Saludo salu, boolean esJefe) {
		this.nombre = nombre;
		this.saludo = salu;
		this.es_Jefe = esJefe;
	}

	public void run() {
		System.out.println(nombre + " llegó.");
		if (es_Jefe) {
			saludo.saludoJefe(nombre);
		} else {
			saludo.saludoEmpleado(nombre);
		}
	}
}
