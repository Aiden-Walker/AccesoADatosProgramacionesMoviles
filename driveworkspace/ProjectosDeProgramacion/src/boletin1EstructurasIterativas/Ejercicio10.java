package boletin1EstructurasIterativas;

import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero del 1 al 10, y calculare su tabla de multiplicar");
		int input = sc.nextInt();
		if (input <= 10) {
			for (int multiplicador = 1; multiplicador <= 10; multiplicador++) {
				System.out.println(input * multiplicador);
			}
		} else {
			System.out.println("El numero introducido es incorrecto");
		}
		sc.close();
	}

}
