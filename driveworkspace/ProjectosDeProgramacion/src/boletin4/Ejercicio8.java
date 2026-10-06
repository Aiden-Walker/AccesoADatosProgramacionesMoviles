package boletin4;

import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un numero de horas");
		int horas = sc.nextInt();
		System.out.println("Introduzca un numero de minutos");
		int minutos = sc.nextInt();
		System.out.println("Introduzca un numero de segundos");
		int segundos = sc.nextInt();

		minutos = minutos + (segundos / 60);
		segundos = segundos % 60;
		horas = horas + (minutos / 60);
		minutos = minutos % 60;

		System.out.println(
				"El tiempo que ha dado serian " + horas + " horas " + minutos + " minutos " + segundos + " segundos");
		sc.close();
	}

}
