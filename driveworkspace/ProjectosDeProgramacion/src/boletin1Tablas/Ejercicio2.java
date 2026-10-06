package boletin1Tablas;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime cuantos numeros quieres introducir");
		int numerosSolicitados = sc.nextInt();
		int[] numeros = new int[numerosSolicitados];
		for (int contador = 0; contador < numeros.length; contador++) {
			System.out.println("Introduce un numero");
			numeros[contador] = sc.nextInt();
		}
		for (int contMost = numeros.length - 1; contMost >= 0; contMost--) {
			System.out.println(numeros[contMost]);
		}
		sc.close();
	}

}
