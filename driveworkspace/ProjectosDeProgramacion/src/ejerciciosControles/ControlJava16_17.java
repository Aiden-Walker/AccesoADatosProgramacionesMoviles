package ejerciciosControles;

import java.util.Scanner;

public class ControlJava16_17 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Cuantas provincias quieres procesar");
		int numProv = sc.nextInt();
		String nmbrProvMsGrand = "";
		float extnsMedProvMsGrand = 0.0f;
		String lcldMsHbts = "";
		int hbtslcldMsHbts = Integer.MIN_VALUE;
		String sgndLcldMsHbts = "";
		int hbtsSgndlcldMsHbts = Integer.MIN_VALUE;
		String trcrLcldMsHbts = "";
		int hbtsTrcrLcldMsHbts = Integer.MIN_VALUE;
		float medLcldsProv = 0.0f;
		int totalNumLclds = 0;
		boolean provMnsTresLclds = false;
		String lcldMnsDensPobl = "";
		float densPoblLcldMensDensPobl = Float.MAX_VALUE;
		String provMasJuzgds = "";
		float prcntjProvMasJuzgds = Float.MIN_VALUE;
		for (int contProv = 0; contProv < numProv; contProv++) {
			System.out.println("Introduce el nombre de la provincia");
			String nombreProv = sc.next();
			System.out.println("Introduce el nombre de una localidad");
			String nombreLocl = sc.next();
			float extnsTtlProv = 0.0f;
			int lcldsProv = 0;
			float porcentajeJuzgds = 0.0f;
			int numJuzgds = 0;
			while (!nombreLocl.equals("fin")) {
				System.out.println("Introduce el numero de habitantes de esta localidad");
				int numHabtns = sc.nextInt();
				System.out.println("Introduce ahora su termino municipal");
				float termMncpl = sc.nextFloat();
				extnsTtlProv += termMncpl;
				System.out.println("Di si la localidad tiene juzgados propios");
				char tieneJzgds = sc.next().charAt(0);
				if (tieneJzgds == 's') {
					numJuzgds++;
				}
				lcldsProv++;
				float densidadPobl = numHabtns / termMncpl;
				if (densidadPobl < densPoblLcldMensDensPobl) {
					lcldMnsDensPobl = nombreLocl;
					densPoblLcldMensDensPobl = densidadPobl;
				}
				totalNumLclds++;
				if (numHabtns > hbtslcldMsHbts) {
					trcrLcldMsHbts = sgndLcldMsHbts;
					hbtsTrcrLcldMsHbts = hbtsSgndlcldMsHbts;
					sgndLcldMsHbts = lcldMsHbts;
					hbtsSgndlcldMsHbts = hbtslcldMsHbts;
					lcldMsHbts = nombreLocl;
					hbtslcldMsHbts = numHabtns;
				} else if (numHabtns > hbtsSgndlcldMsHbts) {
					trcrLcldMsHbts = sgndLcldMsHbts;
					hbtsTrcrLcldMsHbts = hbtsSgndlcldMsHbts;
					sgndLcldMsHbts = nombreLocl;
					hbtsSgndlcldMsHbts = numHabtns;
				} else if (numHabtns > hbtsTrcrLcldMsHbts) {
					trcrLcldMsHbts = nombreLocl;
					hbtsTrcrLcldMsHbts = numHabtns;
				}
				System.out.println("Ahora introduce el nombre de otra localidad");
				nombreLocl = sc.next();
			}
			float mediaExtns = extnsTtlProv / lcldsProv;
			if (mediaExtns > extnsMedProvMsGrand) {
				nmbrProvMsGrand = nombreProv;
				extnsMedProvMsGrand = mediaExtns;
			}
			if (lcldsProv < 3) {
				provMnsTresLclds = true;
			}
			porcentajeJuzgds = (100 * numJuzgds / lcldsProv);
			if (porcentajeJuzgds > prcntjProvMasJuzgds) {
				provMasJuzgds = nombreProv;
				prcntjProvMasJuzgds = porcentajeJuzgds;
			}
		}
		medLcldsProv = (float)totalNumLclds / numProv;
		System.out.println("La provincia con mayor extension media de sus municipios es " + nmbrProvMsGrand);
		System.out.println("La localidad con mas habitantes es " + lcldMsHbts + " La segunda con mas habitantes es "
				+ sgndLcldMsHbts + " Y la tercera con mas habitantes es " + trcrLcldMsHbts);
		System.out.println("El numero medio de localidades por provincia es " + medLcldsProv);
		if (provMnsTresLclds) {
			System.out.println("Existe una provincia con menos de tres localidades");
		}
		System.out.println("La localidad con menor densidad de poblacion es " + lcldMnsDensPobl);
		System.out.println("La provincia con mayor porcentaje de juzgados es " + provMasJuzgds);
		sc.close();
	}
}
