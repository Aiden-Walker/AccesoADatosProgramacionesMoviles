package boletin1condicional;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un numero");
		int numero = sc.nextInt();
		if (numero >= 0) {
			System.out.println("Tu numero es positivo");
		} else {
			System.out.println("Tu numero es negativo");
		}
		sc.close();
	}
	
}
