package tarea1Herencia;

public class Campana extends Instrumento {

	@Override
	public void interpretar() {
		for (int i = 0; i < this.nNotas; i++) {
			System.out.println(notas[i] + " bellring ");// Can you hear it? The ringing of the bells, it's calling.
		}
	}

}
