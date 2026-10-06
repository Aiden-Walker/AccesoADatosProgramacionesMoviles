package tarea1Herencia;

public class Hora {
	protected int hora;
	protected int minuto;

	public Hora(int hora, int minuto) {
		super();
		setHora(hora);
		setMinuto(minuto);
	}

	/**
	 * @return the hora
	 */
	public int getHora() {
		return hora;
	}

	/**
	 * @param hora the hora to set
	 */
	public void setHora(int hora) {
		if (hora >= 0 && hora < 24) {
			this.hora = hora;
		}
	}

	/**
	 * @return the minuto
	 */
	public int getMinuto() {
		return minuto;
	}

	/**
	 * @param minuto the minuto to set
	 */
	public void setMinuto(int minuto) {
		if (minuto >= 0 && minuto < 60) {
			this.minuto = minuto;
		}
	}

	public void inc() {
		if ((++this.minuto) == 60) {
			this.minuto = 0;
			if ((++this.hora) == 24) {
				this.hora = 0;
			}
		}
	}

	@Override
	public String toString() {
		return "Hora [hora=" + hora + ", minuto=" + minuto + "]";
	}

}
