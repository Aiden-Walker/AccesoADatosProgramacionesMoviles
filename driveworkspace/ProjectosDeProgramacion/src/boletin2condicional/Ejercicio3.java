package boletin2condicional;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero");
		byte numero1 = sc.nextByte();
		System.out.println("Introduce un segundo numero");
		byte numero2 = sc.nextByte();
		byte menor;
		if (numero1 < numero2) {
			menor = numero1;
		} else {
			menor = numero2;
		}
		menor = (numero1 < numero2) ? numero1 : numero2;
		System.out.println("El menor de los dos numeros es " + menor);
		sc.close();
	}

}
