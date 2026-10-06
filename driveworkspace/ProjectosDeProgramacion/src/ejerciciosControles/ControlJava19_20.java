package ejerciciosControles;

import java.util.Arrays;
import java.util.Scanner;

import funcionesImportantes.FuncionesBasicas;
import funcionesImportantes.FuncionesTablas;

public class ControlJava19_20 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		final int MAXTEAMS = 20;
		int[][][] goles = new int[MAXTEAMS][MAXTEAMS][2];
		String[] equipos = new String[MAXTEAMS];
		int numEquipsIns = 0;
		int equipoLocAct = 0;
		int equipoVisAct = 0;
		goles = rellenaTablas3D(goles, MAXTEAMS);
		System.out.println("1- Introducir el resultado de un partido \r\n"
				+ "2- Mostrar todos los partidos introducidos \r\n" + "3- Mostrar el equipo ganador de la liga \r\n"
				+ "4- Mostrar el porcentaje de partidos en los que perdio el equipo local \r\n"
				+ "5- Introducir nombre de equipo y mostrar los resultados de todos sus partidos \r\n"
				+ "6- Finalizar");
		int input = sc.nextInt();
		while (input < 6) {
			switch (input) {
			case 1: {
				System.out.println("Introduce el nombre del equipo local");
				String local = sc.next();
				equipoLocAct = FuncionesTablas.getIndexOfString(local, equipos, numEquipsIns);
				if (equipoLocAct == -1) {
					equipoLocAct = numEquipsIns;
					equipos[numEquipsIns++] = local;
				}
				System.out.println("Ahora introduce el equipo visitante");
				String visitante = sc.next();
				equipoVisAct = FuncionesTablas.getIndexOfString(visitante, equipos, numEquipsIns);
				if (equipoVisAct == -1) {
					equipoVisAct = numEquipsIns;
					equipos[numEquipsIns++] = visitante;
				}
				System.out.println("Introduce los goles del equipo local");
				int golesLocal = sc.nextInt();
				goles[equipoLocAct][equipoVisAct][0] = golesLocal;
				System.out.println("Introduce ahora los goles del equipo visitante");
				int golesVisitante = sc.nextInt();
				goles[equipoLocAct][equipoVisAct][1] = golesVisitante;
				break;
			}
			case 2: {
				String[] equiposOrdenados = Arrays.copyOf(equipos, numEquipsIns);
				Arrays.sort(equiposOrdenados);
				for (int i = 0; i < goles.length; i++) {
					for (int j = 0; j < goles[i].length; j++) {
						if (goles[i][j][0] > -1) {
							System.out.println(equiposOrdenados[i] + " - " + equiposOrdenados[j] + " (" + goles[i][j][0] + "-"
									+ goles[i][j][1] + ")");
						}
					}
				}
				break;
			}
			case 3: {
				int[] puntos = new int[MAXTEAMS];
				for (int i = 0; i < goles.length; i++) {
					for (int j = 0; j < goles[i].length; j++) {
						if (goles[i][j][0] > -1) {
							if (goles[i][j][0] > goles[i][j][1]) {
								puntos[i] += 3;
							} else if (goles[i][j][1] > goles[i][j][0]) {
								puntos[j] += 3;
							} else {
								puntos[i] += 1;
								puntos[j] += 1;
							}
						}
					}
				}
				int puntosGanador = Integer.MIN_VALUE;
				String equipoGanador = "";
				for (int counter = 0; counter < puntos.length; counter++) {
					if (puntos[counter] > puntosGanador) {
						puntosGanador = puntos[counter];
						equipoGanador = equipos[counter];
					}
				}
				System.out
						.println("El quipo con mas puntos es: " + equipoGanador + " con " + puntosGanador + " puntos.");
				break;
			}
			case 4: {
				int partidosTotales = 0;
				int partidosPerdLoc = 0;
				for (int i = 0; i < goles.length; i++) {
					for (int j = 0; j < goles[i].length; j++) {
						if (goles[i][j][0] > -1) {
							partidosTotales++;
							if (goles[i][j][0] < goles[i][j][1]) {
								partidosPerdLoc++;
							}
						}
					}
				}
				float porcentajePerdidosLoc = FuncionesBasicas.calculoDePorcentaje(partidosPerdLoc, partidosTotales);
				System.out.println("Porcentaje de partidos en los que perdio el equipo local " + porcentajePerdidosLoc);
				break;
			}
			case 5:
				System.out.println("Que equipo quieres consultar");
				String equipoAConsultar = sc.next();
				int indiceEquipoConsult = FuncionesTablas.getIndexOfString(equipoAConsultar, equipos, numEquipsIns);
				System.out.println("Como local ha jugado con:");
				for (int j = 0; j < goles[indiceEquipoConsult].length; j++) {
					if(goles[indiceEquipoConsult][j][0]>-1) {
						System.out.println("\t"+equipos[j]);
					}
				}
				System.out.println("Como visitante ha jugado con:");
				for(int i = 0; i < goles.length; i++) {
					if(goles[i][indiceEquipoConsult][0]>-1) {
						System.out.println("\t"+equipos[i]);
					}
				}
				break;
			default:
				System.out.println("Something Evil Will happen");
			}
			System.out.println("1- Introducir el resultado de un partido \r\n"
					+ "2- Mostrar todos los partidos introducidos \r\n" + "3- Mostrar el equipo ganador de la liga \r\n"
					+ "4- Mostrar el porcentaje de partidos en los que perdio el equipo local \r\n"
					+ "5- Introducir nombre de equipo y mostrar los resultados de todos sus partidos \r\n"
					+ "6- Finalizar");
			input = sc.nextInt();
		}
		sc.close();
	}

	public static int[][][] rellenaTablas3D(int[][][] tablaARellenar, int longitudTablas) {
		for (int i = 0; i < tablaARellenar.length; i++) {
			for (int j = 0; j < tablaARellenar[0].length; j++) {
				for (int z = 0; z < tablaARellenar[0][0].length; z++) {
					tablaARellenar[i][j][z] = -1;
				}
			}
		}
		return tablaARellenar;
	}
}
