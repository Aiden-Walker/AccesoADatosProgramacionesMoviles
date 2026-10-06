package ejercicioTipoExamenGuerra;

public class Guerra implements Comparable<Guerra> {
	private String denominacion; // nombre de la guerra
	private Bando bandoA; // uno de los dos bandos que lucharon en esta guerra
	private Bando bandoB; // el otro bando que lucho en esta guerra.
	private Batalla tablaBatallas[]; // batallas que tuvieron lugar en esta guerra
	private int nBatallas; // número de batallas en la tabla
	public static final int MAX_BATALLAS = 10; // máximo

	public Guerra(String denominacion, Bando BandoA, Bando BandoB) {
		this.denominacion = denominacion;
		this.bandoA = BandoA;
		this.bandoB = BandoB;
		this.tablaBatallas = new Batalla[Guerra.MAX_BATALLAS];
		this.nBatallas = 0;
	}

	/**
	 * @return the denominacion
	 */
	public String getDenominacion() {
		return denominacion;
	}

	/**
	 * @param denominacion the denominacion to set
	 */
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	/**
	 * @return the bandoA
	 */
	public Bando getBandoA() {
		return bandoA;
	}

	/**
	 * @param bandoA the bandoA to set
	 */
	public void setBandoA(Bando bandoA) {
		this.bandoA = bandoA;
	}

	/**
	 * @return the bandoB
	 */
	public Bando getBandoB() {
		return bandoB;
	}

	/**
	 * @param bandoB the bandoB to set
	 */
	public void setBandoB(Bando bandoB) {
		this.bandoB = bandoB;
	}

	/**
	 * @return the tablaBatallas
	 */
	public Batalla[] getTablaBatallas() {
		return tablaBatallas;
	}

	/**
	 * @param tablaBatallas the tablaBatallas to set
	 */
	public void setTablaBatallas(Batalla[] tablaBatallas) {
		this.tablaBatallas = tablaBatallas;
	}

	/**
	 * @return the nBatallas
	 */
	public int getnBatallas() {
		return nBatallas;
	}

	/**
	 * @param nBatallas the nBatallas to set
	 */
	public void setnBatallas(int nBatallas) {
		this.nBatallas = nBatallas;
	}

	/**
	 * @return the maxBatallas
	 */
	public static int getMaxBatallas() {
		return MAX_BATALLAS;
	}

	public void añadeBatalla(Batalla batalla) {
		this.tablaBatallas[nBatallas++] = batalla;
	}

	@Override
	public String toString() {
		String cad = "Guerra: " + denominacion + "\n\n" + "    Bando:   " + bandoA // + "\n"
				+ "    Bando:   " + bandoB // + "\n"
				+ "    Batallas:\n";
		for (int i = 0; i < this.nBatallas; i++)
			cad += "             " + this.tablaBatallas[i] + "\n";

		return cad;
	}

	public int getNPaises() {
		return this.bandoA.getnPaises() + this.bandoB.getnPaises();
	}

	public int compareTo(Guerra otra) {
		return this.getNPaises() - otra.getNPaises();
	}
}
