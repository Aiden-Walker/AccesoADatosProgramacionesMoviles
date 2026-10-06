package boletin1Tablas;

import java.util.Scanner;

public class Ejercicio3 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Introduce un numero ('n')");
		int n = sc.nextInt();
		int [] numerosATrabajar = introducirNumeros(n);
		calculosNumeros(numerosATrabajar);
		sc.close();
	}

	static int[] introducirNumeros(int cantidadNumeros) {
		int[] numeros = new int[cantidadNumeros];
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Teclea un numero");
			numeros[i] = sc.nextInt();
		}
		return numeros;
	}

	static void calculosNumeros(int[] numerosParaCalc) {
		float mediaPositivos = 0.0f;
		int sumaPositivos = 0;
		int numPositivos = 0;
		float mediaNegativos = 0.0f;
		int sumaNegativos = 0;
		int numNegativos = 0;
		int numCeros = 0;
		for (int contadorLength = 0; contadorLength < numerosParaCalc.length; contadorLength++) {
			int numActual = numerosParaCalc[contadorLength];
			if (numActual == 0) {
				numCeros++;
			} else if (numActual > 0) {
				numPositivos++;
				sumaPositivos += numActual;
			} else if (numActual < 0) {
				numNegativos++;
				sumaNegativos += numActual;
			}
		}
		mediaPositivos = (float)sumaPositivos / numPositivos;
		mediaNegativos = (float)sumaNegativos / numNegativos;
		System.out.println(
				"La media de los numeros positivos es " + mediaPositivos + " La media de los negativos, en cambio, es "
						+ mediaNegativos + " Y el numero de ceros es " + numCeros);
	}
}
