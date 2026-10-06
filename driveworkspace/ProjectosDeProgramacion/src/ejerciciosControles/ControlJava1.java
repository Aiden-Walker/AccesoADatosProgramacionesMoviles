package ejerciciosControles;

import java.util.Scanner;

public class ControlJava1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el codigo de una clase/departamento ");
		String codigo = sc.next();
		String dptCnMsProfs = "";
		int numPrfsdptCnMsProfs = Integer.MIN_VALUE;
		String mejorAlumn = "";
		float mediaMejorAlumn = Float.MIN_VALUE;
		String mejorAlumngrpPq = "";
		float mediaMjrAlumngrpPq = Float.MIN_VALUE;
		String ultimaEspecialidad = "";
		String penUltimaEspecialidad = "";
		int numAsignBach = 0;
		float mediaAsignBach = 0.0f;
		int clasesBach = 0;
		int cicsConMs1500hrs = 0;
		String fpConMnsDuracn = "";
		int horasFPConMnsDuracn = Integer.MAX_VALUE;
		String dptConMenosPrm = "";
		float mediaPrmdptMnsPrm = Float.MAX_VALUE;

		while (!codigo.equals("fin")) {
			if (codigo.charAt(0) == 'D') {
				System.out.println("Escribe el nombre del departamento");
				String departamento = sc.next();
				System.out.println("Cuantos profesores tiene dicho departamento");
				int profsDpt = sc.nextInt();
				int prmTtl = 0;
				if (profsDpt > numPrfsdptCnMsProfs) {
					dptCnMsProfs = departamento;
					numPrfsdptCnMsProfs = profsDpt;
				}
				for (int contProfs = 0; contProfs < profsDpt; contProfs++) {
					System.out.println("Introduce el nombre del profesor");
					String nombreProf = sc.next();
					System.out.println("Cuantos años lleva en el centro");
					int aniosProf = sc.nextInt();
					prmTtl += aniosProf;
				}
				float mediaPrmDpt = (float) prmTtl / profsDpt;
				if (mediaPrmDpt < mediaPrmdptMnsPrm) {
					mediaPrmdptMnsPrm = mediaPrmDpt;
					dptConMenosPrm = departamento;
				}
			} else if (codigo.charAt(0) == 'C') {
				System.out.println("Introduce una letra (E para ESO,P para PCPI, B para bachillerato, F para FP)");
				char letra = sc.next().charAt(0);
				switch (letra) {
				case 'E': {
					System.out.println("Introduce el nombre de un alumno");
					String alumno = sc.next();
					float mediaalum = 0.0f;
					int numAlumnESO = 0;
					while (!alumno.equals("fin")) {
						System.out.println("Y su respectiva nota");
						mediaalum = sc.nextFloat();
						numAlumnESO++;
						if (mediaalum > mediaMejorAlumn) {
							mejorAlumn = alumno;
							mediaMejorAlumn = mediaalum;
						}
						System.out.println("Introduce el nombre de otro alumno");
						alumno = sc.next();
					}
					if (numAlumnESO < 20) {
						mediaMjrAlumngrpPq = mediaMejorAlumn;
						mejorAlumngrpPq = mejorAlumn;
					}
					break;
				}
				case 'P': {
					System.out.println("Introduce el nombre de la especialidad");
					String especialidad = sc.next();
					penUltimaEspecialidad = ultimaEspecialidad;
					ultimaEspecialidad = especialidad;
					break;
				}
				case 'B': {
					System.out.println("Cuantas asignaturas tiene este bachillerato");
					int asignaturasbach = sc.nextInt();
					numAsignBach += asignaturasbach;
					clasesBach++;
					break;
				}
				case 'F': {
					System.out.println("Introduce el nombre del titulo");
					String tituloFP = sc.next();
					System.out.println("Introduce las horas totales del ciclo");
					int horasFP = sc.nextInt();
					if (horasFP > 1500) {
						cicsConMs1500hrs++;
					}
					if (horasFP < horasFPConMnsDuracn) {
						horasFPConMnsDuracn = horasFP;
						fpConMnsDuracn = tituloFP;
					}
					break;
				}
				default:
					System.out.println("I got a mango on a fork");
				}
			}
			System.out.println("Introduce otro Codigo");
			codigo = sc.next();
		}
		mediaAsignBach = (numAsignBach / clasesBach);
		System.out.println("El departamento con mas profesores es " + dptCnMsProfs);
		System.out.println(
				"El alumno perteneciente a un grupo de menos de 20 alumnos con mayor media es " + mejorAlumngrpPq);
		if (!penUltimaEspecialidad.equals("") && !ultimaEspecialidad.equals("")) {
			System.out.println("Las dos ultimas especialidades introducidas son " + ultimaEspecialidad + " Y "
					+ ultimaEspecialidad);
		} else if (penUltimaEspecialidad.equals("")) {
			System.out.println("La ultima especialidad es " + ultimaEspecialidad + " No existe otra especialidad");
		}
		System.out.println("La media de asignaturas en las clases de bachillerato es" + mediaAsignBach);
		System.out.println("El numero de ciclos con mas de 1500 horas es " + cicsConMs1500hrs);
		System.out.println("El ciclo con menor duracion es " + fpConMnsDuracn);
		System.out.println("El departamento con menos permanencia es " + dptConMenosPrm);
		sc.close();
	}

}
