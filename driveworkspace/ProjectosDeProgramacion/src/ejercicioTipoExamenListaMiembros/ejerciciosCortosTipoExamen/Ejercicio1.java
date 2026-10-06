package ejerciciosCortosTipoExamen;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		final int ALUMSA = 25;
		final int ALUMSB = 28;
		final int ALUMSC = 31;
		final int ALUMSD = 29;
		String mejorAlumn = "???";
		int medMejorAlumn = Integer.MIN_VALUE;
		int numSusp = 0;
		boolean haySobr = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Cual es la letra del grupo que quieres evaluar ");
		char letra = sc.next().charAt(0);
		int numalumnos = 0;
		switch (letra) {
		case 'A':
			numalumnos = ALUMSA;
			break;
		case 'B':
			numalumnos = ALUMSB;
			break;
		case 'C':
			numalumnos = ALUMSC;
			break;
		case 'D':
			numalumnos = ALUMSD;
			break;
		default:
			numalumnos = 0;
			break;
		}
		for (int counter = 0; counter < numalumnos; counter++) {
			System.out.println("Introduzca el nombre del alumno ");
			String nombre = sc.next();
			int nota1;
			int nota2;
			int nota3;
			int media;
			System.out.println("Introduzca le media del primer parcial ");
			nota1 = sc.nextInt();
			System.out.println("La del segundo ");
			nota2 = sc.nextInt();
			System.out.println("La del tercero");
			nota3 = sc.nextInt();
			media = (nota1 + nota2 + nota3) / 3;
			if (media > medMejorAlumn) {
				mejorAlumn = nombre;
				medMejorAlumn = media;
			}
			if (media < 5) {
				numSusp++;
			}
			if (media >= 9) {
				haySobr = true;
			}

		}
		if (haySobr) {
			System.out.println("El alumno con mayor nota media es " + mejorAlumn
					+ " El numero de suspensos del curso es " + numSusp + " Y existen sobresalientes");
		} else {
			System.out.println("El alumno con mayor nota media es " + mejorAlumn
					+ " El numero de suspensos del curso es " + numSusp);
		}
		sc.close();
	}
}
