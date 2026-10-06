package boletin4;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserte una cantidad de millas");
		int millas = sc.nextInt();
		int metros = millas * 1609;
		System.out.println("La cantidad de metros que da al convertir las millas es de " + metros + " metros");
		sc.close();
	}

}
