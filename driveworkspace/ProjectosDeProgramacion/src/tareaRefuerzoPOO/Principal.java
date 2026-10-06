package tareaRefuerzoPOO;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alumno a1 = new Alumno("Juan", 22, 2006);
		Alumno a2 = new Alumno("Paco", 19, 1984);
		Alumno a3 = new Alumno("Raul", 20, 1614);
		Alumno a4 = new Alumno("Esteban", 24, 69420);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		Profesor p1 = new Profesor("Edward_Newgate", 33, "Piracy");
		Profesor p2 = new Profesor("Gordon_Freeman", 24, "Theorethical_Physics");
		System.out.println(p1);
		System.out.println(p2);
		Grupo g1 = new Grupo("DAW1", p1);
		g1.addAlumn(a1);
		g1.addAlumn(a2);
		g1.addAlumn(a3);
		g1.addAlumn(a4);
		System.out.println(g1);
		g1.addAlumn(new Alumno("Maria", 19, 54321));

		Scanner sc = new Scanner(System.in);
		System.out.println("1- Añadir alumno al grupo 2- Listar el grupo 3- Salir");
		int opcion = sc.nextInt();
		while (opcion > 0 && opcion <= 3) {
			switch (opcion) {
			case 1: {
				System.out.println("Di el nombre del alumno");
				String nombreAlumn = sc.next();
				System.out.println("Ahora su edad");
				int edadAlum = sc.nextInt();
				System.out.println("Por ultimo su expediente");
				long expedienteAlum = sc.nextLong();
				g1.addAlumn(new Alumno(nombreAlumn, edadAlum, expedienteAlum));
				break;
			}
			case 2: {
				g1.toString();
				break;
			}
			default:
				System.out.println("No bueno");
			}
			System.out.println("1- Añadir alumno al grupo 2- Listar el grupo 3- Salir");
			opcion = sc.nextInt();
		}
		sc.close();
	}

}
