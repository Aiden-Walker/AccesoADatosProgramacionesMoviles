package tarea1POO;

public class Bombilla {
	private static boolean interruptorPlomos;
	private boolean interruptorIndividual;

	public Bombilla(boolean estaEncendido) {
		super();
		this.interruptorIndividual = estaEncendido;
	}

	/**
	 * @return the estanPlomosEnc
	 */
	public static boolean isEstanPlomosEnc() {
		return interruptorPlomos;
	}

	/**
	 * @param estanPlomosEnc the estanPlomosEnc to set
	 */
	public static void setEstanPlomosEnc(boolean estanPlomosEnc) {
		Bombilla.interruptorPlomos = estanPlomosEnc;
	}

	/**
	 * @return the estaEncendido
	 */
	public boolean isEstaEncendido() {
		return interruptorIndividual;
	}

	/**
	 * @param estaEncendido the estaEncendido to set
	 */
	public void setEstaEncendido(boolean estaEncendido) {
		this.interruptorIndividual = estaEncendido;
	}

	public static boolean isInterruptorPEnc() {
		return interruptorPlomos;
	}

	public void estaLaBombillaEncendida() {
		if (Bombilla.interruptorPlomos && this.interruptorIndividual) {
			System.out.println("La bombilla esta encendida");
		} else {
			System.out.println("La bombilla esta apagada");
		}
	}

	public static void estanLosFusiblesRotos() {
		if (!Bombilla.interruptorPlomos) {
			System.out.println("Los fusibles han sido saboteados por el impostor");
		} else {
			System.out.println("Los fusibles estan en pleno funcionamiento");
		}
	}

	public void clickInterruptor() {
		this.interruptorIndividual = !this.interruptorIndividual;
	}

	public static void sabotearRepararFusibles() { // AMONG US / UN-AMONG US
		Bombilla.interruptorPlomos = !Bombilla.interruptorPlomos;
	}

	@Override
	public String toString() {
		return "Bombilla [estaEncendido=" + interruptorIndividual + "]";
	}
}
