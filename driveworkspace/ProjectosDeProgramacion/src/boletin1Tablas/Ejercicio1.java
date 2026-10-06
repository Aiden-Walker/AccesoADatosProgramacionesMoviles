package boletin1Tablas;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] numeros = new int[5];
		for (int contador = 0; contador < 5; contador++) {
			System.out.println("Introduzca un numero");
			numeros[contador] = sc.nextInt();
		}
		for (int contMostrador = 0; contMostrador < numeros.length; contMostrador++) {
			System.out.println(numeros[contMostrador]);
		}
		sc.close();
	}

}
