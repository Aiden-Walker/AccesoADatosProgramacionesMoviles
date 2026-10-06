package tarea1Herencia;

public class HoraExacta extends Hora {
	private int segundo;

	public HoraExacta(int hora, int minuto, int segundo) {
		super(hora, minuto);
		setSegundo(segundo);
	}

	/**
	 * @return the segundo
	 */
	public int getSegundo() {
		return segundo;
	}

	/**
	 * @param segundo the segundo to set
	 */
	public void setSegundo(int segundo) {
		if (segundo >= 0 && segundo < 60) {
			this.segundo = segundo;
		}
	}

	@Override
	public void inc() {
		// TODO Auto-generated method stub
		if (++this.segundo == 60) {
			this.segundo = 0;
			if ((++this.minuto) == 60) {
				this.minuto = 0;
				if ((++this.hora) == 24) {
					this.hora = 0;
				}
			}
		}
	}

	public boolean comprobaHoras(HoraExacta primeraHora, HoraExacta segundaHora) {
		boolean sonExactas = false;
		if (primeraHora.equals(segundaHora)) {
			sonExactas = true;
		}
		return sonExactas;
	}

	@Override
	public String toString() {
		return "HoraExacta [segundo=" + segundo + ", hora=" + hora + ", minuto=" + minuto + "]";
	}
}
