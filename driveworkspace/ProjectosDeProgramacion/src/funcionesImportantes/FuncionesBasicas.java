package funcionesImportantes;

import java.util.Scanner;

public class FuncionesBasicas {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
	}

	public static int peticionDeEnteros() {
		System.out.println("Porfavor introduce un entero");
		int intADevolver = sc.nextInt();
		return intADevolver;
	}

	public static float calculoDeMedia(int total, int instancias) {
		float mediaResultado = (float) total / instancias;
		return mediaResultado;
	}

	public static float calculoDePorcentaje(int parte, int entero) {
		float porcentaje = (float) 100 * parte / entero;
		return porcentaje;
	}

	public static int calculoFactorial(int productoInicial) {
		int productoFinal = productoInicial;
		if (productoFinal == 0) {
			productoFinal = 1;
		} else {
			productoFinal = productoFinal * calculoFactorial(productoFinal - 1);
		}
		return productoFinal;
	}
}
