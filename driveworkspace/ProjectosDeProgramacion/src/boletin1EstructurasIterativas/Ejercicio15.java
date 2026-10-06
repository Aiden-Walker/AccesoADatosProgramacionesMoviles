package boletin1EstructurasIterativas;

import java.util.Scanner;

public class Ejercicio15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe el numero hasta el que quieres llegar");
		int n = sc.nextInt();
		int contadorprimos = 0;
		int contadordivisibles = 0;
		for (int posibleprimo = 1; posibleprimo < n; posibleprimo++) {
			for (int posibledivisor = 1; posibledivisor <= posibleprimo; posibledivisor++) {
				if (posibleprimo % posibledivisor == 0) {
					contadordivisibles++;
				}
			}
			if (contadordivisibles <= 2) {
				contadorprimos++;
			}
			contadordivisibles = 0;
		}
		System.out.println("Entre 1 y " + n + " hay " + contadorprimos + " numeros primos");
		sc.close();
	}

}
