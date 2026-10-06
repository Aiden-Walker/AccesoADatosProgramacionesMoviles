package controlesProgramacion;

import java.util.Scanner;

public class ControlesU1U2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Cuantos investigadores han enviado informes");
		int investigadores = sc.nextInt();
		float promedioNoches = 0.0f;
		int totalNoches = 0;
		int numeroExp = 0;
		boolean hayUnivrstrsMiskatonic = false;
		boolean hayCultsDeCthulhu = false;
		boolean hayErudtsIndp = false;
		int maxEnergCosm = Integer.MIN_VALUE;
		int expMaxEnergCosm = 0;
		int valorMsBajoActCult = Integer.MAX_VALUE;
		int segValrMsBajoActCult = Integer.MAX_VALUE;
		String invstgdrRecordCosm = "???";
		float prcntjExpMas3Nochs = 0.0f;
		int expsMs3nochs = 0;
		for (int contadorInvestgdrs = 0; contadorInvestgdrs < investigadores; contadorInvestgdrs++) {
			System.out.println("Introduzca el nombre de un investigador");
			String nombreInvestgdr = sc.next();
			System.out.println("Ahora introduzca el lugar que dicho investigador ha explorado");
			String lugarExplorado = sc.next();
			String pertenencia = "???";
			switch (nombreInvestgdr.charAt(0)) {
			case 'M': {
				pertenencia = "Universidad Miskatonic";
				hayUnivrstrsMiskatonic = true;
				break;
			}
			case 'C': {
				pertenencia = "Culto de Cthulhu";
				hayCultsDeCthulhu = true;
				break;
			}
			case 'E': {
				pertenencia = "Erudito Independiente";
				hayErudtsIndp = true;
				break;
			}
			default:
				pertenencia = "Desconocido";
			}
			System.out.println("Ingrese el codigo de expedicion");
			int codigoExp = sc.nextInt();
			while (codigoExp != -1) {
				numeroExp++;
				System.out.println("¿Cual es el numero de noches de registro de esta expedicion?");
				int nochesRegistro = sc.nextInt();
				if (nochesRegistro > 3) {
					expsMs3nochs++;
				}
				totalNoches += nochesRegistro;
				for (int contadorNoches = 0; contadorNoches < nochesRegistro; contadorNoches++) {
					System.out.println("Introduzca el nivel de cordura restante");
					int cordura = sc.nextInt();
					System.out.println("Ahora el indice de actividad cultista");
					int indcActCult = sc.nextInt();
					if (indcActCult < valorMsBajoActCult) {
						segValrMsBajoActCult = valorMsBajoActCult;
						valorMsBajoActCult = indcActCult;
					} else if (indcActCult < segValrMsBajoActCult) {
						segValrMsBajoActCult = indcActCult;
					}
					System.out.println("Por ultimo, el nivel de energia cosmica percibida");
					int energiaCosmcPercb = sc.nextInt();
					if (energiaCosmcPercb > maxEnergCosm) {
						maxEnergCosm = energiaCosmcPercb;
						expMaxEnergCosm = codigoExp;
						invstgdrRecordCosm = nombreInvestgdr;
					}
				}
				System.out.println("Introduzca el codigo de otra expedicion");
				codigoExp = sc.nextInt();
			}
		}
		promedioNoches = (float) totalNoches / numeroExp;
		prcntjExpMas3Nochs = ((float) expsMs3nochs * 100) / numeroExp;
		System.out.println("El numero promedio de noches que dura una expedicion es " + promedioNoches);
		if (hayUnivrstrsMiskatonic && hayCultsDeCthulhu && hayErudtsIndp) {
			System.out.println("Hay investigadores de las tres procedencias");
		}
		System.out.println("El nivel maximo de energia cosmica es " + maxEnergCosm
				+ " El identificador de expedicion que registro dicho maximo es " + expMaxEnergCosm
				+ " Y el investigador que hizo dicho registro es " + invstgdrRecordCosm);
		System.out.println("Los dos valores mas bajos de actividad cultista son " + valorMsBajoActCult
				+ " Y el segundo mas bajo es " + segValrMsBajoActCult);
		System.out.println("El porcentaje de expediciones que duraron mas de 3 noches es " + prcntjExpMas3Nochs);
		sc.close();
	}

}
