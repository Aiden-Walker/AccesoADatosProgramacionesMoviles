package boletin1EstructurasIterativas;

import java.util.Scanner;

public class Ejercicio8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int factorial = 1;
		int input;
		System.out.println("Introduce un numero y te dire su factorial");
		input = sc.nextInt();
		for (int counter = input; counter > 0; counter--) {
			factorial = factorial * counter;
		}
		System.out.println("El factorial es " + factorial);
		sc.close();
	}
}
