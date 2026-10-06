package tarea1Herencia;

public class Hora12 extends Hora {
	private boolean meridianoAMPM;

	public Hora12(int hora, int minuto, boolean meridianoAMPM) {
		super(hora, minuto);
		this.meridianoAMPM = meridianoAMPM;
	}

	@Override
	public void setHora(int hora) {
		// TODO Auto-generated method stub
		if (hora >= 0 && hora < 12) {
			this.hora = hora;
		}
	}

	@Override
	public void inc() {
		// TODO Auto-generated method stub
		if ((++this.minuto) == 60) {
			this.minuto = 0;
			if ((++this.hora) == 12) {
				this.hora = 0;
				this.meridianoAMPM = !this.meridianoAMPM;
			}
		}
	}

	@Override
	public String toString() {
		return super.toString() + " " + (meridianoAMPM ? "am" : "pm");
	}
}
