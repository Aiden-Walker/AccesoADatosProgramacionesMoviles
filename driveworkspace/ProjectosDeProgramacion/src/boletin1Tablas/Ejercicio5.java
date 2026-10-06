package boletin1Tablas;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio5 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int longitudTablas = 6;
		int[] tabla1 = creadorTablas(longitudTablas);
		int[] tabla2 = creadorTablas(longitudTablas);
		int[] tablaFinal = fusionadorTablas(tabla1, tabla2, longitudTablas);
		System.out.println(Arrays.toString(tablaFinal));
		sc.close();
	}

	static int[] creadorTablas(int cantidadNumeros) {
		System.out.println("Vamos a crear una tabla");
		int[] tabla = new int[cantidadNumeros];
		for (int i = 0; i < tabla.length; i++) {
			System.out.println("Teclea un numero");
			tabla[i] = sc.nextInt();
		}
		Arrays.sort(tabla);
		return tabla;
	}

	static int[] fusionadorTablas(int[] primerTabla, int[] segundaTabla, int longitudSupertabla) {
		int[] superTabla = new int[longitudSupertabla * 2];
		int i = 0;
		int j = 0;
		for (int z = 0; z < superTabla.length; z++) {
			if (i < primerTabla.length && j < segundaTabla.length) {
				if (primerTabla[i] <= segundaTabla[j]) {
					superTabla[z] = primerTabla[i];
					i++;
				} else {
					superTabla[z] = segundaTabla[j];
					j++;
				}
			} else if (i > primerTabla.length) {
				superTabla[z] = segundaTabla[j];
				j++;
			} else {
				superTabla[z] = primerTabla[i];
				i++;
			}
		}
		return superTabla;
	}
}
