package boletin4;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserte un numero");
		int numero1 = sc.nextInt();
		System.out.println("Inserte otro numero");
		int numero2 = sc.nextInt();
		float media = ((float) (numero1 + numero2) / 2);
		System.out.println("La media aritmetica es " + media);
		sc.close();
	}

}
