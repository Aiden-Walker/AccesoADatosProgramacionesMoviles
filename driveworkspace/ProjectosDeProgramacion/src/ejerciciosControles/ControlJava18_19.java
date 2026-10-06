package ejerciciosControles;

import java.util.Arrays;
import java.util.Scanner;

import funcionesImportantes.FuncionesBasicas;
import funcionesImportantes.FuncionesTablas;

public class ControlJava18_19 {

	public static void main(String[] args) {
		final int NUM_PARTIDOS = 20;
		final int NUM_CIUDADES = 30;
		int[][] votosPartidosCiudades = new int[NUM_CIUDADES][NUM_PARTIDOS];
		String[] partidos = new String[NUM_PARTIDOS];
		int numPartidosIns = 0;
		String[] ciudades = new String[NUM_CIUDADES];
		int numCiudadesIns = 0;
		for (int fila = 0; fila < votosPartidosCiudades.length; fila++) {
			for (int columna = 0; columna < votosPartidosCiudades[fila].length; columna++) {
				votosPartidosCiudades[fila][columna] = -1;
			}
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("1- Introducir votos obtenidos en una ciudad por un partido.\r\n"
				+ "2- Listado alfabetico por partidos de todos los datos introducidos.\r\n"
				+ "3- Listado de los mejores resultados de cada partido\r\n"
				+ "4- Listado de localidades de menor a mayor participacion.\r\n"
				+ "5- Porcentaje de votos obtenidos de cada partido en la comunidad.\r\n" + "6- Fin");
		int opcion = sc.nextInt();
		while (opcion < 6) {
			switch (opcion) {
			case 1:
				int iPA = -1;
				int iCA = -1;
				System.out.println("Introduce una ciudad");
				String ciudadAIntroducir = sc.next();
				iCA = FuncionesTablas.getIndexOfString(ciudadAIntroducir, ciudades, numCiudadesIns);
				if (iCA == -1) {
					iCA = numCiudadesIns;
					ciudades[numCiudadesIns++] = ciudadAIntroducir;
				}
				System.out.println("Introduce ahora un partido");
				String partidoAIntroducir = sc.next();
				iPA = FuncionesTablas.getIndexOfString(partidoAIntroducir, partidos, numPartidosIns);
				if (iPA == -1) {
					iPA = numPartidosIns;
					partidos[numPartidosIns++] = partidoAIntroducir;
				}
				System.out.println("A continuacion, introduce el numero de votos de dicho partido en dicha ciudad");
				votosPartidosCiudades[iCA][iPA] = sc.nextInt();
				break;
			case 2:
				String[] partidosOrdenados = Arrays.copyOf(partidos, numPartidosIns);
				Arrays.sort(partidosOrdenados);
				for (int counter = 0; counter < partidosOrdenados.length; counter++) {
					int partidoAConsultar = FuncionesTablas.getIndexOfString(partidosOrdenados[counter], partidos,
							numPartidosIns);
					System.out.println("Partido: " + partidosOrdenados[partidoAConsultar] + " \t ");
					for (int contador = 0; contador < votosPartidosCiudades.length; contador++) {
						if (votosPartidosCiudades[contador][partidoAConsultar] > -1) {
							System.out.println("\t" + ciudades[contador] + ": "
									+ votosPartidosCiudades[contador][partidoAConsultar]);
						}
					}
				}
				break;
			case 3:
				for (int j = 0; j < NUM_PARTIDOS; j++) {
					int maximoVotosAct = Integer.MIN_VALUE;
					String ciudadMasVotosAct = "";
					for (int i = 0; i < NUM_CIUDADES; i++) {
						if (votosPartidosCiudades[i][j] > -1 && votosPartidosCiudades[i][j] > maximoVotosAct) {
							maximoVotosAct = votosPartidosCiudades[i][j];
							ciudadMasVotosAct = ciudades[i];
						}
					}
					System.out
							.println("El partido " + partidos[j] + " ha obtenido mas votoes en: " + ciudadMasVotosAct);
				}
				break;
			case 4:
				int[] votosPorCiudad = new int[numCiudadesIns];
				for (int i = 0; i < numCiudadesIns; i++) {
					for (int j = 0; j < numPartidosIns; j++) {
						if (votosPartidosCiudades[i][j] > -1) {
							votosPorCiudad[i] += votosPartidosCiudades[i][j];
						}
					}
				}
				int[] votosPorCiudadOrdenados = Arrays.copyOf(votosPorCiudad, numCiudadesIns);
				Arrays.sort(votosPorCiudadOrdenados);
				for (int i = 0; i < numCiudadesIns; i++) {
					// busco el numero de votos total votosPorProvinciaOrdenado[i] en
					// votosPorProvincia
					int indiceCiudBusc = FuncionesTablas.getIndexOfInt(votosPorCiudadOrdenados[i], votosPorCiudad,
							numCiudadesIns);
					System.out.println("En la ciudad de " + ciudades[indiceCiudBusc] + " el numero de votos ha sido "
							+ votosPorCiudadOrdenados[i]);
				}
				break;
			case 5:
				int sumaVotosTotal = getSumaTotal(votosPartidosCiudades);
				for (int j = 0; j < numPartidosIns; j++) {
					int sumaVotosPartido = 0;
					for (int i = 0; i < numCiudadesIns; j++) {
						if (votosPartidosCiudades[i][j] > -1) {
							sumaVotosPartido += votosPartidosCiudades[i][j];
						}
					}
					System.out.println("Partido " + partidos[j] + " Porc Vot:"
							+ FuncionesBasicas.calculoDePorcentaje(sumaVotosPartido, sumaVotosTotal));
				}
				break;
			}
			System.out.println("1- Introducir votos obtenidos en una ciudad por un partido.\r\n"
					+ "2- Listado alfabetico por partidos de todos los datos introducidos.\r\n"
					+ "3- Listado de los mejores resultados de cada partido\r\n"
					+ "4- Listado de localidades de menor a mayor participacion.\r\n"
					+ "5- Porcentaje de votos obtenidos de cada partido en la comunidad.\r\n" + "6- Fin");
			opcion = sc.nextInt();
		}
		sc.close();
	}

	public static int getSumaTotal(int[][] matriz) {
		int suma = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (matriz[i][j] > -1) {
					suma += matriz[i][j];
				}
			}
		}
		return suma;
	}
}
