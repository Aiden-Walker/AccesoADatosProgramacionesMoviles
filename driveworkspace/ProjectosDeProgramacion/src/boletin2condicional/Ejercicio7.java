package boletin2condicional;

import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el primer coeficiente de la ecuacion");
		int a = sc.nextInt();
		System.out.println("Introduce el segundo coeficiente de la ecuacion");
		int b = sc.nextInt();
		System.out.println("Introduce el tercer y ultimo coeficiente de la ecuacion");
		int c = sc.nextInt();
		double solucionesposibles;
		solucionesposibles = (Math.pow(b, 2)) - (4 * a * c);
		if (solucionesposibles < 0) {
			System.out.println("No hay soluciones posibles");
		} else if (solucionesposibles == 0) {
			System.out.println("Hay una solucion posible, es la siguiente: " + (-b / 2 * a));
		} else {
			System.out.println("Hay dos soliciones posibles, estas son las siguientes: "
					+ (-b + Math.sqrt(solucionesposibles) / 2 * a) + " Y "
					+ (-b - Math.sqrt(solucionesposibles) / 2 * a));
		}
		sc.close();
	}

}
