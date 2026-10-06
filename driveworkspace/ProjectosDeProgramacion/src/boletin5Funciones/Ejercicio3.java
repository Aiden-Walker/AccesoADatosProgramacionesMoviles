package boletin5Funciones;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce '1' para calcular el area, introduce '2' para calcular el volumen");
		int decisionUsuario = sc.nextInt();
		System.out.println("Introduce el radio que vas a usar");
		float radioUsuario = sc.nextFloat();
		System.out.println("Por ultimo, introduce la altura que vas a usar");
		int alturaUsuario = sc.nextInt();
		areaOvolumen(decisionUsuario, radioUsuario, alturaUsuario);
		sc.close();
	}

	static void areaOvolumen(int decisor, float radio, int altura) {
		double resultado = 0.0;
		if (decisor == 1) {
			resultado = 2 * Math.PI * radio * (altura + radio);
		} else if (decisor == 2) {
			resultado = Math.PI * Math.pow(radio, 2) * altura;
		}
		System.out.println(resultado);
	}
}
