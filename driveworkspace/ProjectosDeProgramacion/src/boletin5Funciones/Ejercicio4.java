package boletin5Funciones;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero");
		int num1Usuario = sc.nextInt();
		System.out.println("Introduce un segundo numero");
		int num2Usuario = sc.nextInt();
		System.out.println(comparador(num1Usuario, num2Usuario));
		sc.close();
	}

	static int comparador(int num1, int num2) {
		int mayor = 0;
		if (num1 > num2) {
			mayor = num1;
		} else {
			mayor = num2;
		}
		return mayor;
	}
}
