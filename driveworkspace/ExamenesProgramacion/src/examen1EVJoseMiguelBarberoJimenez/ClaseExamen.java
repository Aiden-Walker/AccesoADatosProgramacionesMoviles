package examen1EVJoseMiguelBarberoJimenez;

import java.util.Arrays;
import java.util.Scanner;

public class ClaseExamen {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numSuma1 = 5;
		int numeroResta2 = 10;
		// Llamando a las funciones en la main:
		suma(numSuma1, numeroResta2);
		int numResta1 = 20;
		int numResta2 = 10;
		resta(numResta1, numResta2);
		int numMultiplica1 = 3;
		int numMultiplica2 = 5;
		multiplica(numMultiplica1, numMultiplica2);
		double numDivide1 = 20;
		double numDivide2 = 2;
		divide(numDivide1, numDivide2);
		double numPotencia1 = 4;
		double aQuePotencio = 3;
		potencia(numPotencia1, aQuePotencio);
		double raizCuadradaDe = 100;
		raizCuadrada(raizCuadradaDe);
		crazOFritz();
		String[] arrayAUsar = new String[10];
		int posicion = 0;
		System.out.println("Seleccione una de las opciones:\n" + "1- Guardar frase\n" + "2- Borrar frase\n"
				+ "3- Record de frase mas larga\n" + "4- Mostrar todo el poema\n" + "Introduzca '0' para salir");
		int opcion = sc.nextInt();
		while (opcion > 0 && opcion < 5) {
			switch (opcion) {
			case 1: {
				if (posicion >= arrayAUsar.length) {
					arrayAUsar = Arrays.copyOf(arrayAUsar, arrayAUsar.length + 1);
				}
				System.out.println("Que frase quiere guardar");
				String fraseaGuardar = sc.next();
				arrayAUsar[posicion] = fraseaGuardar;
				posicion += 1;
				System.out.println("Frase guardada, posicion aumentada");
				break;
			}
			case 2: {
				System.out.println("Introduzca el indice de la clase que quiere guardar (de 0 a 10)");
				int posaBorrar = sc.nextInt();
				arrayAUsar[posaBorrar] = null;
				for (int i = posaBorrar; i < posicion; i++) {
					posaBorrar = posaBorrar + 1;
				}
				posicion -= 1;
				break;
			}
			case 3: {
				String fraseRecordAct = "";
				for (int i = 0; i < posicion; i++) {
					if (arrayAUsar[i].length() > fraseRecordAct.length()) {
						fraseRecordAct = arrayAUsar[i];
					}
				}
				System.out.println("La frase mas larga es: " + fraseRecordAct);
				break;
			}
			case 4: {
				for (int i = 0; i < posicion; i++) {
					System.out.println(arrayAUsar[i]);
				}
				break;
			}
			default:
				System.out.println("Me void");
				break;
			}
			System.out.println("Numero de frases actuales: " + posicion);
			System.out.println("Seleccione una de las opciones:\n" + "1- Guardar frase\n" + "2- Borrar frase\n"
					+ "3- Record de frase mas larga\n" + "4- Mostrar todo el poema\n" + "Introduzca '0' para salir");
			opcion = sc.nextInt();
		}
		System.out.println("fin");
	}

	public static int suma(int num1, int num2) {
		// Ejemplo de suma.
		int res = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + res);
		return res;
	}

	public static int resta(int num1, int num2) {
		// Ejemplo de resta;
		int res = num1 - num2;
		System.out.println(num1 + " - " + num2 + " = " + res);
		return res;
	}

	public static int multiplica(int num1, int num2) {
		// Ejemplo de multiplicacion;
		int res = num1 * num2;
		System.out.println(num1 + " * " + num2 + " = " + res);
		return res;
	}

	public static double divide(double num1, double num2) {
		double res = num1 / num2;
		System.out.println(num1 + " / " + num2 + " = " + res);
		return res;
	}

	// Ejemplos de operaciones hechas llamando a la API de Java:
	public static double potencia(double num1, double num2) {
		double res = Math.pow(num1, num2);
		System.out.println(num1 + " potenciado a: " + num2 + " = " + res);
		return res;
	}

	public static double raizCuadrada(double num1) {
		double res = Math.sqrt(num1);
		System.out.println("Raiz cuadrada de: " + num1 + " = " + res);
		return res;
	}

	public static void crazOFritz() {
		int fe = 100;
		int corazones = 10;
		while (fe > 10) {
			corazones = (int) (Math.random() * 10);
			if (fe < 50) {
				System.out.println("Houston, tenemos un problema, me temo que debemos de rezar al dios del RNG");
				break;
			}
			switch (corazones) {
			case 0: {
				System.out.println(
						"ooo, soy el fantasma de Fritz, me he matado cuando un oso animatronico me metio mano, ooo");
				fe = fe - 10;
				break;
			}
			case 1, 2, 3, 4: {
				System.out.println("ahh, I need, a medic bag...");
				fe = fe - 10;
				break;
			}
			case 5, 6: {
				System.out.println("I am hungry, go make me a sandwich");
				break;
			}
			case 7, 8: {
				System.out.println("Something smells... fishy, around here...");
				break;
			}
			case 9, 10: {
				System.out.println(
						"Hace un día precioso afuera, las flores brotan, los pájaros cantan, en días como estos es un buen día para hacer un ejercicio de programación y estudiar tranquilamente");
				break;
			}
			default:
				System.out.println("Me when I lie");
				break;
			}
		}
	}
}
