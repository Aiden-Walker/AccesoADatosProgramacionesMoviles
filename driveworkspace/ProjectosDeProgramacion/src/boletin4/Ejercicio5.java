package boletin4;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca una temperatura (Grados Centigrados)");
		int centigrados = sc.nextInt();
		float fahrenheit = ((float) 9 * centigrados / 5 + 32);
		System.out.println("La temperatura introducida en grados Fahrenheit seria de " + fahrenheit + " grados");
		sc.close();
	}

}
