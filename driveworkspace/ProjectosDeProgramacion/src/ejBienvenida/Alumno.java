package ejBienvenida;

public class Alumno extends Thread {
	Bienvenida saludo;

	public Alumno(Bienvenida bienvenida, int num_alumno) {
		super(String.valueOf(num_alumno));
		this.saludo = bienvenida;
	}

	public void run() {
		saludo.saludarProfesor();
	}
}
