package boletin5Funciones;

public class Ejercicio8 {

	public static void main(String[] args) {
		int numeroALlegar = 4;
		System.out.println("Este numero tiene " + divisoresPrimos(numeroALlegar) + " Divisores primos");
	}

	static int divisoresPrimos(int numComprobaciones) {
		int numDivisoresPrimos = 0;
		for (int contadorComprobaciones = 1; contadorComprobaciones <= numComprobaciones; contadorComprobaciones++) {
			if (numComprobaciones % contadorComprobaciones == 0 && esNumeroPrimo(contadorComprobaciones)) {
				numDivisoresPrimos++;
			}
		}
		return numDivisoresPrimos;
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
