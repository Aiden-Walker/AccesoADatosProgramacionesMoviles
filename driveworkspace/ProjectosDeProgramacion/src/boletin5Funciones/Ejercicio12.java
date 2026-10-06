package boletin5Funciones;

public class Ejercicio12 {

	public static void main(String[] args) {
		int numeroAFactorizar = 4;
		System.out.println(calculoFactorial(numeroAFactorizar));
	}

	static int calculoFactorial(int productoInicial) {
		int productoFinal = productoInicial;
		if (productoFinal == 0) {
			productoFinal = 1;
		} else {
			productoFinal = productoFinal * calculoFactorial(productoFinal - 1);
		}
		return productoFinal;
	}
}
