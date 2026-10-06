package boletin4;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una nota decimal");
		float nota1 = sc.nextFloat();
		System.out.println("Introduce una segunda nota decimal");
		float nota2 = sc.nextFloat();
		System.out.println("Introduce una tercera nota decimal");
		float nota3 = sc.nextFloat();
		System.out.println("Introduce una cuarta y ultima nota decimal");
		float nota4 = sc.nextFloat();
		int notamedia = ((int) (nota1 + nota2 + nota3 + nota4) / 4);
		System.out.println("La media de las 4 notas es " + notamedia);
		sc.close();
	}

}
