package boletin1EstructurasIterativas;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Introduce un numero por teclado, te dire si es par, si es positivo, y el cuadrado de dicho numero (introduce 0 para terminar el programa)");
		int input = sc.nextInt();
		while (input != 0) {
			if (input % 2 == 0) {
				System.out.println("El numero introducido es par");
			} else {
				System.out.println("El numero introducido es impar");
			}
			if (input > 0) {
				System.out.println("El numero es positivo");
			} else {
				System.out.println("El numero es negativo");
			}
			System.out.println("El cuadrado de su numero es" + Math.pow(input, 2));
			System.out.println("Introduzca otro numero (recuerde que 0 termina el programa)");
			sc.nextInt();
		}
		sc.close();
	}

}
