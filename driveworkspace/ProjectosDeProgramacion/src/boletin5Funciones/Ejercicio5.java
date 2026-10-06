package boletin5Funciones;

import java.util.Scanner;

public class Ejercicio5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero");
		int num1Usuario = sc.nextInt();
		System.out.println("Introduce un segundo numero");
		int num2Usuario = sc.nextInt();
		System.out.println("Introduce un tercer numero");
		int num3Usuario = sc.nextInt();
		System.out.println("El numero mas grande es " + comparador3Numeros(num1Usuario, num2Usuario, num3Usuario));
		sc.close();
	}

	static int comparador2Numeros(int num1, int num2) {
		int mayor = 0;
		if (num1 > num2) {
			mayor = num1;
		} else {
			mayor = num2;
		}
		return mayor;
	}

	static int comparador3Numeros(int num1, int num2, int num3) {
		// int mayor3 = 0;
		// int mayor2 = comparador2Numeros(num1, num2);
		// mayor3 = comparador2Numeros(num3,mayor2);
		// return mayor3;
		return comparador2Numeros(num3, comparador2Numeros(num1, num2));
	}
}
