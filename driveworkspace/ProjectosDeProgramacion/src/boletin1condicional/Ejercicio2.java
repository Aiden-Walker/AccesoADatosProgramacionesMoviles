package boletin1condicional;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el numero 12");
		int numero12 = sc.nextInt();
		if (numero12 == 12) {
			System.out.println("Has introducido bien el numero");
		} else {
			System.out.println("No has introducido el 12, va a caer un yunque.");
		}
		sc.close();
	}

}
