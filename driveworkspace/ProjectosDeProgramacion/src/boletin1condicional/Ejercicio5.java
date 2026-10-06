package boletin1condicional;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Porfavor introduzca un numero");
		long numero1 = sc.nextLong();
		System.out.println("Introduzca un segundo numero");
		long numero2 = sc.nextLong();
		System.out.println("Introduzca un tercer y ultimo numero");
		long numero3 = sc.nextLong();
		if (numero1 > numero2 && numero1 > numero3) {
			System.out.println(numero1 + " Es el mayor de los tres numeros");
		} else if (numero2 > numero3) {
			System.out.println(numero2 + " Es el mayor de los tres numeros");
		} else {
			System.out.println(numero3 + " Es el mayor de los tres numeros");
		}
		sc.close();
	}

}
