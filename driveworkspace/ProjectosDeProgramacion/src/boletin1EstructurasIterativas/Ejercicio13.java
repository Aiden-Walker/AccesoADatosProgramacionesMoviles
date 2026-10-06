package boletin1EstructurasIterativas;

import java.util.Scanner;

public class Ejercicio13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Este programa te va a pedir la nota de seis alumnos");
		int nota = 0;
		int aprobados = 0;
		int suspensos = 0;
		for (int contador = 0; contador < 6; contador++) {
			System.out.println("Introduzca una nota");
			nota = sc.nextInt();
			if (nota < 5) {
				suspensos++;
			} else {
				aprobados++;
			}
		}
		if (suspensos == 0) {
			System.out.println("Tu clase no tiene suspensos, y tiene "+aprobados+" alumnos aprobados");
		} else {
			System.out.println("Tu clase tiene " + suspensos + " suspensos, y "+aprobados+" alumnos aprobados");
		}
		sc.close();
	}

}
