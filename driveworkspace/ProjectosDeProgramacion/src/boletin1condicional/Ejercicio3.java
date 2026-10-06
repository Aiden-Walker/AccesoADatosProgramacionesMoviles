package boletin1condicional;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero, te dire si es impar o par");
		int numerofunny = sc.nextInt();
		if ((numerofunny % 2) == 0) {
			System.out.println("Tu numero es par");
		} else {
			System.out.println("Tu numero es impar");
		}
		sc.close();
	}
}
