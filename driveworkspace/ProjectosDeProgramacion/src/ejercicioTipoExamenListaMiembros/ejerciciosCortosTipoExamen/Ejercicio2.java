package ejerciciosCortosTipoExamen;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		int numArbs = 0;
		int sumaAlts = 0;
		int medAlturas = 0;
		int maxAlt = Integer.MIN_VALUE;
		int minAlt = Integer.MAX_VALUE;
		int maxDia = Integer.MIN_VALUE;
		int minDia = Integer.MAX_VALUE;
		int medEdArbsB = 0;
		int edadArbsB = 0;
		int numArbsB = 0;
		boolean hayArbsMs30Mts = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el numero de arboles que quieres evaluar");
		numArbs = sc.nextInt();
		for (int counter = 0; counter < numArbs; counter++) {
			System.out.println("Dime el tipo del arbol (A o B)");
			char tipArb = sc.next().charAt(0);
			System.out.println("Dime la altura de tu arbol");
			int altura = sc.nextInt();
			System.out.println("Dime el diametro de tu arbol");
			int diametro = sc.nextInt();
			if (tipArb == 'B') {
				System.out.println("Introduce la edad de tu arbol");
				int edad = sc.nextInt();
				numArbsB++;
				edadArbsB += edad;
			}
			if (altura > 30) {
				hayArbsMs30Mts = true;
			}
			if (altura > maxAlt) {
				maxAlt = altura;
			} else if (altura < minAlt) {
				minAlt = altura;
			}
			if (diametro > maxDia) {
				maxDia = altura;
			} else if (diametro < minDia) {
				minDia = altura;
			}
			sumaAlts += altura;
		}
		medAlturas = sumaAlts / numArbs;
		medEdArbsB = edadArbsB / numArbsB;
		System.out.println("La altura media de los arboles es " + medAlturas + " La altura maxima entre los arboles es "
				+ maxAlt + " La altura minima en cambio es " + minAlt + " El diametro maximo entre los arboles es "
				+ maxDia + " El minimo en cambio es " + minDia + " La edad media de los arboles tipo B es "
				+ medEdArbsB);
		if (hayArbsMs30Mts == true) {
			System.out.println("Existen arboles de mas de 30 metros");
		}
		sc.close();
	}

}
