package boletin1EstructurasIterativas;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el minimo de un rango");
		int minimo = sc.nextInt();
		System.out.println("Ahora introduzca el maximo");
		int maximo = sc.nextInt();
		System.out.println("Introduzca un numero dentro de ese rango");
		int input = sc.nextInt();
		while (input < minimo || input > maximo) {
			System.out.println("El numero esta fuera del rango, introduzcalo otro numero");
			input = sc.nextInt();
		}
		System.out.println("Gracias por su colaboracion");
		sc.close();
	}

}
