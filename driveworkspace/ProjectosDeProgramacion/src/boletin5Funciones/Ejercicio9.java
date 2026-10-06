package boletin5Funciones;

public class Ejercicio9 {

	public static void main(String[] args) {
		int numeroALlegar = 10;
		divisoresPrimos(numeroALlegar);
	}

	static void divisoresPrimos(int numComprobaciones) {
		for (int contadorComprobaciones = 1; contadorComprobaciones <= numComprobaciones; contadorComprobaciones++) {
			if (numComprobaciones % contadorComprobaciones == 0 && esNumeroPrimo(contadorComprobaciones)) {
				System.out.println(contadorComprobaciones + " Es primo");
			}
		}
	}

	static boolean esNumeroPrimo(int numeroAEvaluar) {
		boolean esPrimo = false;
		int contadorDivisibles = 0;
		for (int divisor = 1; divisor <= numeroAEvaluar; divisor++) {
			if (numeroAEvaluar % divisor == 0) {
				contadorDivisibles++;
			}
		}
		if (contadorDivisibles <= 2) {
			esPrimo = true;
		}
		return esPrimo;
	}
}
