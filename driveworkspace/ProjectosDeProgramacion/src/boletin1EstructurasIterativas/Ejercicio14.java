package boletin1EstructurasIterativas;

import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un numero");
		int n = sc.nextInt();
		int contador = 0;
		int salto = 0;
		for (contador = n; contador > 0; contador--) {
			for (salto = 0; salto < contador; salto++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		sc.close();
	}

}
