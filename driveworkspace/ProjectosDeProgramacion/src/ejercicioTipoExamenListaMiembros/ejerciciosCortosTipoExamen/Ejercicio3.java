package ejerciciosCortosTipoExamen;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el numero del mes que vas a evaluar");
		int mes = sc.nextInt();
		int dias = 0;
		int piezsFabrMes = 0;
		int mejorDia = 0;
		int piezsFbrMejorDia = Integer.MIN_VALUE;
		int peorDia = 0;
		int piezsFbrPeorDia = Integer.MAX_VALUE;
		boolean diaMns300Piezas = false;
		switch (mes) {
		case 1, 3, 5, 7, 8, 10, 12: {
			dias = 31;
			break;
		}
		case 2: {
			dias = 28;
			break;
		}
		case 4, 6, 9, 11: {
			dias = 30;
			break;
		}
		default:
			System.out.println("Mes invalido");
		}
		for (int contDias = 1; contDias <= dias; contDias++) {
			System.out.println("Cuantas piezas se han fabricado hoy");
			int piezsFabrHoy = sc.nextInt();
			if (piezsFabrHoy < 300) {
				diaMns300Piezas = true;
			}
			if (piezsFabrHoy > piezsFbrMejorDia) {
				mejorDia = contDias;
				piezsFbrMejorDia = piezsFabrHoy;
			}
			if (piezsFabrHoy < piezsFbrPeorDia) {
				peorDia = contDias;
				piezsFbrPeorDia = piezsFabrHoy;
			}
			piezsFabrMes += piezsFabrHoy;
		}
		System.out.println("El dia que se fabricaron mas piezas fue " + mejorDia
				+ " el dia con el menor numero de piezas fabricadas fue " + peorDia
				+ " el numero de motores fabricados este mes es " + piezsFabrMes);
		if (diaMns300Piezas == true) {
			System.out.println("Existen dias por debajo del minimo");
		}
		sc.close();

	}

}