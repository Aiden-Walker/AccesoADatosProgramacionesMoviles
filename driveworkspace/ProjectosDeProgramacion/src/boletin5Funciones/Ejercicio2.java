package boletin5Funciones;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime un numero");
		int numero1 = sc.nextInt();
		System.out.println("Ahora dime otro numero (uno mas grande que el primero)");
		int numero2 = sc.nextInt();
		mostradorNumeros(numero1, numero2);
		sc.close();
	}

	static void mostradorNumeros(int numeroInicial, int numeroFinal) {
		for (; numeroInicial <= numeroFinal; numeroInicial++) {
			System.out.println(numeroInicial);
		}
	}
}
