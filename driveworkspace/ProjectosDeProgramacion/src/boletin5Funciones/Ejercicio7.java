package boletin5Funciones;

public class Ejercicio7 {

	public static void main(String[] args) {
		int numeroAComprobar = 11;
		System.out.println("¿Es el numero primo? " + comprobadorPrimos(numeroAComprobar));
	}

	static boolean comprobadorPrimos(int numeroAEvaluar) {
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
