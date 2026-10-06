package ejSemaforos;

public class ComienzoTrabajo {
	public static void main(String[] args) {

		Saludo s = new Saludo();

		Empleado empleado1 = new Empleado("Lucas", s, false);
		Empleado empleado2 = new Empleado("María", s, false);
		Empleado empleado3 = new Empleado("Sara", s, false);
		Empleado jefe = new Empleado("JEFE", s, true);
		empleado1.start();
		empleado2.start();
		empleado3.start();
		jefe.start();
	}
}
