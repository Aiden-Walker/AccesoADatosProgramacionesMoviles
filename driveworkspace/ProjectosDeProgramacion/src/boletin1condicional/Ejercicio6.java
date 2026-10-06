package boletin1condicional;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final double GRAVEDAD = 9.8;
		System.out.println("Introduzca un valor de tiempo");
		double tiempo = sc.nextDouble();
		double velocidad;
		if (tiempo > 0) {
			velocidad = GRAVEDAD * tiempo;
			System.out.println("Su velocidad es " + velocidad);
		} else {
			System.out.println("La unidad de tiempo introducida es invalida");
		}
		sc.close();
	}

}
