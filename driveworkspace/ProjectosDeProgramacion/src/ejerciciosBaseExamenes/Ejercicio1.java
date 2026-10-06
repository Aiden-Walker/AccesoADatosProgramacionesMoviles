package ejerciciosBaseExamenes;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mediaAritmetica = 0;
		int porcentajeMenorqueCinco = 0;
		int contadorNumerosMenorqueCinco = 0;
		int contadorNumerosMayorqueCien = 0;
		int contadorDeNumerosIntroducidos = 0;
		int sumaTotal = 0;
		int input;
		System.out.println("Introduce un numero");
		input = sc.nextInt();
		int valorMinimo = input;
		int valorMaximo = input;
		while (input >= 0) {
			if (input < valorMinimo) {
				valorMinimo = input;
			}
			if (input > valorMaximo) {
				valorMaximo = input;
			}
			if (input < 5) {
				contadorNumerosMenorqueCinco++;
			}
			if (input > 100) {
				contadorNumerosMayorqueCien++;
			}
			sumaTotal = sumaTotal + input;
			contadorDeNumerosIntroducidos++;
			System.out.println("Introduzca otro numero");
			input = sc.nextInt();
		}
		mediaAritmetica = (sumaTotal / contadorDeNumerosIntroducidos);
		porcentajeMenorqueCinco = ((contadorNumerosMenorqueCinco * 100) / contadorDeNumerosIntroducidos);
		System.out.println("La media aritmetica de todos los numeros es " + mediaAritmetica
				+ " El valor maximo de todos los numeros es " + valorMaximo
				+ " El valor minimo de todos los numeros es " + valorMinimo
				+ " El porcentaje de valores menores que 5 es " + porcentajeMenorqueCinco
				+ "% El numero de valores que son mayores que 100 es " + contadorNumerosMayorqueCien);
		sc.close();
	}

}
