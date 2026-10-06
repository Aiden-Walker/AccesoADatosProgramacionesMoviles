package ejerciciosCortosTipoExamen;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numProvincias = 0;
		String prvnMjrA = "";
		String prvnMjrB = "";
		int totalVotos = 0;
		int votosVlds = 0;
		int prvnMasVotosPA = Integer.MIN_VALUE;
		int prvnMasVotosPB = Integer.MIN_VALUE;
		int abstenciones = 0;
		float pAbstnc = 0;
		float pVtsTotls = 0;
		boolean altAbstn = false;
		System.out.println("Dime el numero de la region de la que quieres introducir datos");
		int region = sc.nextInt();
		switch (region) {
		case 1: {
			numProvincias = 10;
			break;
		}
		case 2: {
			numProvincias = 4;
			break;
		}
		case 3: {
			numProvincias = 6;
			break;
		}
		case 4: {
			numProvincias = 1;
			break;
		}
		default:
			System.out.println("Region invalida");
		}
		for (int contPrvn = 1; contPrvn <= numProvincias; contPrvn++) {
			System.out.println("Introduce el nombre de la provincia actual ");
			String nmbrProvn = sc.next();
			System.out.println("Introduce el numero de votos obtenido por el partido A ");
			int votosA = sc.nextInt();
			System.out.println("Ahora el numero de votos del partido B ");
			int votosB = sc.nextInt();
			System.out.println("Y por ultimo el numero de abstenciones ");
			int abstnc = sc.nextInt();
			totalVotos += abstnc + votosA + votosB;
			votosVlds += votosA + votosB;
			abstenciones += abstnc;
			if (abstnc > 100000) {
				altAbstn = true;
			}
			if (votosA > prvnMasVotosPA) {
				prvnMjrA = nmbrProvn;
				prvnMasVotosPA =votosA;
			}
			if (votosB > prvnMasVotosPB) {
				prvnMjrB = nmbrProvn;
				prvnMasVotosPB = votosB;
			}
		}
		pVtsTotls = ((float) votosVlds / totalVotos) * 100;
		pAbstnc = ((float) abstenciones / totalVotos) * 100;
		System.out.println("El porcentaje de votos totales es " + pVtsTotls + " Y el de abstenciones es " + pAbstnc
				+ " La provincia donde A ha obtenido mas votos es " + prvnMjrA
				+ " Y la provincia donde B ha obtenido mas votos es " + prvnMjrB);
		if (altAbstn == true) {
			System.out.println("Alta abstencion");
		}
		sc.close();
	}
}
