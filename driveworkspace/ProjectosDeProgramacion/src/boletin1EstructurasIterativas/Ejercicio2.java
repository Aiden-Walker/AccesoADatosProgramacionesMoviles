package boletin1EstructurasIterativas;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sumaedades = 0;
		int media = 0;
		int contadorinputs = 0;
		int contadormayoresedad = 0;
		System.out.println("Introduce la edad de un alumno (Introduzca un numero negativo para terminar el programa)");
		int input = sc.nextInt();
		while (input >= 0) {
			sumaedades = sumaedades + input;
			contadorinputs++;
			media = sumaedades / contadorinputs;
			if (input >= 18) {
				contadormayoresedad++;
			}
			System.out.println(
					"Introduzca la edad de otro alumno (Recuerde introducir un numero negativo si quiere terminar)");
			input = sc.nextInt();
		}
		System.out.println("La suma de todas las edades es " + sumaedades + " La media de todas las edades es " + media
				+ " El numero de alumnos introducidos es " + contadorinputs + " Y el numero de mayores de edad es "
				+ contadormayoresedad);
		sc.close();
	}

}
