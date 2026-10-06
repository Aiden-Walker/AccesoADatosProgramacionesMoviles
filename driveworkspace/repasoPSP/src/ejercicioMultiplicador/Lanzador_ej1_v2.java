package ejercicioMultiplicador;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class Lanzador_ej1_v2 {
	public Process lanzarMultiplicador(Integer n1, Integer n2) {

		String clase = "multiplicador.jar";
		ProcessBuilder pb;
		Process proceso = null;
		try {

			pb = new ProcessBuilder("java", "-jar", clase, n1.toString(), n2.toString());

			proceso = pb.start();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return proceso;
	}

	public static void main(String[] args) {
		Lanzador_ej1_v2 l1 = new Lanzador_ej1_v2();
		Lanzador_ej1_v2 l2 = new Lanzador_ej1_v2();
		Process pr1 = null;
		Process pr2 = null;

		pr1 = l1.lanzarMultiplicador(1, 1);
		pr2 = l2.lanzarMultiplicador(1, 2);

		try {
			pr1.waitFor();
			pr2.waitFor();

			InputStreamReader isr_error = new InputStreamReader(pr1.getErrorStream());
			InputStreamReader isr_error2 = new InputStreamReader(pr2.getErrorStream());

			BufferedReader br_error = new BufferedReader(isr_error);
			BufferedReader br2_error = new BufferedReader(isr_error2);
			if (br_error.readLine() == null && br2_error.readLine() == null) {

				// Se han generado correctamente los ficheros
				InputStreamReader isr = new InputStreamReader(pr1.getInputStream());
				BufferedReader br = new BufferedReader(isr);

				String cadena = br.readLine();

				Double suma = Double.valueOf(cadena);

				isr = new InputStreamReader(pr2.getInputStream());
				br = new BufferedReader(isr);

				suma += Double.valueOf(br.readLine());

				System.out.println("RESULTADO v2 = " + suma);

			} else {

				System.out.println("ERRORES AL LANZAR LOS PROCESOS");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException");
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Interrupted Exception");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception genérica");
			e.printStackTrace();
		}

	}
}
