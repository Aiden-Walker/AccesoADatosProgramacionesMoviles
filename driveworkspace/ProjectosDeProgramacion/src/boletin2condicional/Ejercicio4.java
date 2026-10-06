package boletin2condicional;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el radio de una circunferencia");
		double radio = sc.nextDouble();
		double diametro;
		double perimetro;
		double area;
		System.out.println("Seleccione una de las siguientes opciones: \n" + "1. Calcular diametro \n"
				+ "2. Calcular perimetro \n" + "3. Calcular area");
		int input = sc.nextInt();
		switch (input) {
		case 1: {
			diametro = (2 * radio);
			System.out.println("Su diametro es de " + diametro);
			break;
		}
		case 2: {
			perimetro = (2 * Math.PI * radio);
			System.out.println("Su perimetro es de " + perimetro);
			break;
		}
		case 3: {
			area = (Math.PI * (Math.pow(radio, 2)));
			System.out.println("Su area es de " + area);
			break;
		}
		default:
			System.out.println("El input que ha introducido es invalido");
		}
		sc.close();
	}

}
