package examenfinalprimeraProgramacionJMBJ;

import java.util.Arrays;
import java.util.Scanner;

public class ExamenProgramacion25_26 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		final int MAXSUCURSALES = 10;
		int[][][] sucursales = new int[21][MAXSUCURSALES][1];
		String[] codigosSucursales = new String[MAXSUCURSALES];
		int numSucInsertadas = 0;
		int sucursalActiva = 0;
		System.out.println("1- Introducir dato \r\n" + "2- Listar todos los datos \r\n"
				+ "3- Sucursal con mas clientes en un anio concreto \r\n" // Lo siento, java no me permite poner "Ñ"
				+ "4- Listado de sucursales y años con menos de 1000 clientes \r\n"
				+ "5- Listado ordenado de sucursales con mas de 2000 clientes de media \r\n" + "6- Fin");
		int input = sc.nextInt();
		while (input < 6) {
			switch (input) {
			case 1: {
				System.out.println("Escribe el anio del que vas a introducir datos");
				int anioAIntroducir = sc.nextInt();
				System.out.println("Escribe ahora la sucursal de la que vas a introducir datos");
				String sucursal = sc.next();
				sucursalActiva = getIndexOfString(sucursal, codigosSucursales, numSucInsertadas);
				if (sucursalActiva == -1) {
					sucursalActiva = numSucInsertadas;
					codigosSucursales[numSucInsertadas++] = sucursal;
				}
				System.out.println("Bien, por ultimo, introduce los clientes de dicha sucursal en dicho anio");
				int clientes = sc.nextInt();
				sucursales[anioAIntroducir - 2000][sucursalActiva][0] = clientes;
				break;
			} /*
				 * Para saber donde colocar el año (Ya que va desde 2000 hasta el 2020)
				 * simplemente tenemos que restarle 2000 a, año introducido por el usuario, por
				 * ejemplo, al introducir 2000, este se introducira en la posicion 0 (2000 -
				 * 2000 = 0)
				 */
			case 2: {
				/*
				 * Debido a que tambien debo saber en que posicion "j" estamos al momento de
				 * printear el año, debo crear la "j" en el for superior, lo unico que cambia es
				 * que no creo la J en el for interior
				 */
				for (int i = 0; i < sucursales.length; i++) {
					int j = 0;
					if (sucursales[i][j][0] > 0) {
						System.out.println((i + 2000));
					}
					for (; j < sucursales[i].length; j++) {
						if (sucursales[i][j][0] > 0) {
							/*
							 * Yo asumo que 0 es un dato invalido ya que de lo contrario dicho dato no seria
							 * introducido
							 */
							System.out.println("\t" + codigosSucursales[j] + ": " + sucursales[i][j][0] + " clientes");
						}
					}
				}
				break;
			}
			case 3: {
				System.out.println("Introduce el anio que quieres comprobar");
				int anioACheckear = sc.nextInt() - 2000;
				int clientesMax = Integer.MIN_VALUE;
				String sucMasClientes = "";
				for (int i = 0; i < sucursales[anioACheckear].length; i++) {
					if (sucursales[anioACheckear][i][0] > clientesMax) {
						clientesMax = sucursales[anioACheckear][i][0];
						sucMasClientes = codigosSucursales[i];
					}
				}
				System.out.println("La sucursal: " + sucMasClientes + " es la que ha tenido mas clientes ese anio");
				break;
			}
			case 4: {
				for (int j = 0; j < numSucInsertadas; j++) {
					int aniosMenMilClient = 0;
					for (int i = 0; i < sucursales.length; i++) {
						if (sucursales[i][j][0] < 1000 && sucursales[i][j][0] > 0) {
							/* De nuevo, suponemos que 0 es un dato invalido */
							aniosMenMilClient++;
						}
					}
					System.out.println(
							codigosSucursales[j] + ": " + aniosMenMilClient + " anios con menos de 1000 clientes");
				}
				break;
			}
			case 5: {
				String[] sucConMasClientMedia = new String[numSucInsertadas];
				int sucursalesConMasMedia = 0;
				/*
				 * Como ya he dicho en ejercicios anteriores, asumimos que los años con "0" o
				 * sin datos, no cuentan, por lo tanto a la hora de hacer la media estos años no
				 * seran tenidos en cuenta
				 */
				for (int j = 0; j < numSucInsertadas; j++) {
					int totalClientes = 0;
					float mediaClientes = 0.0f;
					int aniosConsiderados = 0;
					for (int i = 0; i < sucursales.length; i++) {
						if (sucursales[i][j][0] > 0) {
							aniosConsiderados++;
							totalClientes += sucursales[i][j][0];
						}
					}
					mediaClientes = calculoDeMedia(totalClientes, aniosConsiderados);
					/* Sucursales.length es el numero de años considerados */
					if (mediaClientes > 2000) {
						sucConMasClientMedia[sucursalesConMasMedia] = codigosSucursales[j];
						sucursalesConMasMedia++;
					}
				}
				String[] sucMasMediaRecort = Arrays.copyOf(sucConMasClientMedia, sucursalesConMasMedia);
				Arrays.sort(sucMasMediaRecort);
				System.out.println(Arrays.toString(sucMasMediaRecort));
				break;
			}
			default:
				System.out.println("Something evil will happen..."); // En principio el programa no deberia entrar aqui.
			}
			System.out.println("1- Introducir dato \r\n" + "2- Listar todos los datos \r\n"
					+ "3- Sucursal con mas clientes en un anio concreto \r\n" // Lo siento, java no me permite poner "Ñ"
					+ "4- Listado de sucursales y años con menos de 1000 clientes \r\n"
					+ "5- Listado ordenado de sucursales con mas de 2000 clientes de media \r\n" + "6- Fin");
			input = sc.nextInt();
		}
		sc.close();
	} // I just wanna talk

	private static int getIndexOfString(String elemBuscado, String[] tabla, int numEInsertados) {
		int indexFound = -1;
		boolean enc = false;
		for (int counter = 0; counter < numEInsertados && !enc; counter++) {
			if (tabla[counter].equals(elemBuscado)) {
				indexFound = counter;
				enc = true;
			}
		}
		return indexFound;
	}

	private static float calculoDeMedia(int total, int instancias) {
		float mediaResultado = (float) total / instancias;
		return mediaResultado;
	}
}
