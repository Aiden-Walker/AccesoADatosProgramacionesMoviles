package boletin5Funciones;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Cuantas veces quieres que diga eco");
		int usuarioEco = sc.nextInt();
		eco(usuarioEco);
		sc.close();
	}

	static void eco(int vecesEco) {
		for (int contadorEco = 0; contadorEco < vecesEco; contadorEco++) {
			System.out.println("Eco");
		}
	}
}
