package tarea1Interfaces;

public class Gato extends Mascota {
	private int pelosBigote;

	public Gato(String nombre, int edad, Origen origen, int bigote) {
		super(nombre, edad, origen);
		this.pelosBigote = bigote;
	}

	/**
	 * @return the pelosBigote
	 */
	public int getPelosBigote() {
		return pelosBigote;
	}

	/**
	 * @param pelosBigote the pelosBigote to set
	 */
	public void setPelosBigote(int pelosBigote) {
		this.pelosBigote = pelosBigote;
	}

	@Override
	public String toString() {
		return "Gato [pelosBigote=" + pelosBigote + ", nombre=" + nombre + ", edad=" + edad + ", origen=" + origen
				+ "]";
	}
}
