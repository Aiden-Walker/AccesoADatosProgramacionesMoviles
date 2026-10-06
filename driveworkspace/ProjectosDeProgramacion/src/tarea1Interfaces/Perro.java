package tarea1Interfaces;

public class Perro extends Mascota {
	private boolean hayChip;

	public Perro(String nombre, int edad, Origen origen, boolean chip) {
		super(nombre, edad, origen);
		this.hayChip = chip;
	}

	/**
	 * @return the hayChip
	 */
	public boolean isHayChip() {
		return hayChip;
	}

	/**
	 * @param hayChip the hayChip to set
	 */
	public void setHayChip(boolean hayChip) {
		this.hayChip = hayChip;
	}

	@Override
	public String toString() {
		return "Perro [hayChip=" + hayChip + ", nombre=" + nombre + ", edad=" + edad + ", origen=" + origen + "]";
	}
}
