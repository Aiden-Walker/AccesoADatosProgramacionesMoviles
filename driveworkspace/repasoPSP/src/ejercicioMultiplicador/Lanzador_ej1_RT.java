package ejercicioMultiplicador;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class Lanzador_ej1_RT {
	public Process lanzarMultiplicador(Integer n1, Integer n2) {

		String clase = "Multiplica_ej1";
		Runtime rt = Runtime.getRuntime();
		Process proceso = null;

		String cmd = "";
		try {

			cmd = "java -cp ./bin " + clase + " " + n1.toString() + " " + n2.toString();

			proceso = rt.exec(cmd);

			// System.out.println("1=" + ProcessHandle.current().isAlive());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return proceso;
	}

	public static void main(String[] args) {
		Lanzador_ej1_RT l1 = new Lanzador_ej1_RT();
		Lanzador_ej1_RT l2 = new Lanzador_ej1_RT();
		Process pr1 = null;
		Process pr2 = null;

		pr1 = l1.lanzarMultiplicador(2, 4);
		pr2 = l2.lanzarMultiplicador(3, 5);

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
