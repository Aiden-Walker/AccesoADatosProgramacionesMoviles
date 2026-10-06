package boletin4;

import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la base de un triangulo");
		int base = sc.nextInt();
		System.out.println("Introduce la altura del triangulo");
		int altura = sc.nextInt();
		float area = (float)base * altura/2;
		System.out.println("El area de tu triangulo es " + area);
		sc.close();
	}

}
