package ejBienvenida;

public class ComienzoClase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bienvenida b = new Bienvenida();
		int n_alumnos = Integer.parseInt(args[0]);

		for (int i = 0; i < n_alumnos; i++) {
			new Alumno(b, i).start();
		}
		Profesor profesor = new Profesor("María Molina", b);
		profesor.start();
	}

}
