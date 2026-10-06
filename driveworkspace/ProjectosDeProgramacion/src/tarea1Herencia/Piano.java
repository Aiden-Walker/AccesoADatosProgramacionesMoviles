package tarea1Herencia;

public class Piano extends Instrumento {

	Piano() {
		super();
	}

	@Override
	public void interpretar() {
		for (int i = 0; i < this.nNotas; i++) {
			System.out.println(notas[i] + " Plin Plin Plon ");// Esto es una terrible referencia a Dark souls
		}
	}

}
