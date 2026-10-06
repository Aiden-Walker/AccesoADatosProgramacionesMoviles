package boletin1condicional;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero");
		int numero1 = sc.nextInt();
		System.out.println("Introduce un segundo y ultimo numero");
		int numero2 = sc.nextInt();
		if (numero1 % 2 == 0 && numero2 % 2 == 0) {
			System.out.println("Tus 2 numeros son pares");
		} else if (numero1 % 2 == 0 || numero2 % 2 == 0) {
			System.out.println("Uno de tus numeros es par, el otro es impar");
		} else {
			System.out.println("Tus 2 numeros son impares");
		}
		sc.close();
	}

}
