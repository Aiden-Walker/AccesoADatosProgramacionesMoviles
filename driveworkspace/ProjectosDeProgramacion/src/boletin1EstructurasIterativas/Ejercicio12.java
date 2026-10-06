package boletin1EstructurasIterativas;

import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nota = 0;
		int suspensos = 0;
		System.out.println("En este programa se le va a pedir que introduzca las calificaciones de 5 alumnos");
		for (int contadornotas = 0; contadornotas < 5; contadornotas++) {
			System.out.println("Introduzca la nota del alumno");
			nota = sc.nextInt();
			if (nota < 5) {
				suspensos++;
			}
		}
		if (suspensos == 0) {
			System.out.println("Tu clase no tiene ningun suspenso");
		} else {
			System.out.println("Entre tus alumnos hay " + suspensos + " suspensos");
		}
		sc.close();

	}

}
