package ejercicioMultiplicador;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class Lanzador_ej1 {
	public Process lanzarMultiplicador(Integer n1, Integer n2, String nombre_fichero) {

		String clase = "Multiplica_ej1";
		ProcessBuilder pb;
		Process proceso = null;
		try {

			pb = new ProcessBuilder("java", "-cp", "./bin", clase, n1.toString(), n2.toString());

			// pb=new ProcessBuilder("java", "-jar", clase, n1.toString(), n2.toString());
			// System.out.println(System.getProperty("user.dir"));

			pb.redirectOutput(new File(nombre_fichero));

			pb.redirectError(new File("Errores-" + nombre_fichero));

			proceso = pb.start();
			// System.out.println("1=" + ProcessHandle.current().isAlive());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return proceso;
	}

	public static void main(String[] args) {
		Lanzador_ej1 l1 = new Lanzador_ej1();
		Lanzador_ej1 l2 = new Lanzador_ej1();
		Process pr1 = null;
		Process pr2 = null;

		pr1 = l1.lanzarMultiplicador(2, 4, "primerDato.txt");

		pr2 = l2.lanzarMultiplicador(3, 5, "segundoDato.txt");

		try {
			pr1.waitFor();
			pr2.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Leo la información de los ficheros que se han generado
		Path ruta1 = Paths.get("Errores-primerDato.txt");
		Path ruta2 = Paths.get("Errores-segundoDato.txt");

		try {
			if (Files.size(ruta1) == 0 && Files.size(ruta2) == 0) {
				// El fichero está vacío=> no se han producido errores.
				FileReader fr = new FileReader("primerDato.txt");
				BufferedReader br = new BufferedReader(fr);

				String n = br.readLine();
				double suma = Double.valueOf(n);

				fr = new FileReader("segundoDato.txt");
				br = new BufferedReader(fr);

				n = br.readLine();
				suma += Double.valueOf(n);

				System.out.println("RESULTADO=" + suma);

				fr.close();
				br.close();

			} else {
				System.out.println("ERRORES AL LANZAR LOS PROCESOS");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}