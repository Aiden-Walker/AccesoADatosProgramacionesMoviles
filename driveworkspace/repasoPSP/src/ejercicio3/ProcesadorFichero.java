package ejercicio3;

import java.io.*;

public class ProcesadorFichero {
	public static void hacerRecuento(String nombreFicheroEntrada, String palabra, String nombreFicheroResultado) {
		FileReader fr = null;
		BufferedReader br = null;

		FileWriter fw = null;
		PrintWriter pr = null;
		String linea;
		int contador = 0;

		String[] words;

		try {
			// Abro el fichero en escritura para registrar el inicio del proceso
			fw = new FileWriter(new File(nombreFicheroResultado));
			pr = new PrintWriter(fw);

			// pr.println("Hora actual inicio: " + System.currentTimeMillis());

			fr = new FileReader(new File(nombreFicheroEntrada));
			br = new BufferedReader(fr);

			while ((linea = br.readLine()) != null) {
				words = linea.split(" ");
				for (int i = 0; i < words.length; i++) {
					if (words[i].equalsIgnoreCase(palabra)) {
						contador++;
					}
				}
			}
			br.close();
			// System.out.println("contador de "+letra+"="+contador);

			pr.println(contador);

			// pr.println("Hora actual fin: " + System.currentTimeMillis());

			pr.close();

		} catch (Exception e) {
			try {
				br.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String nombreFicheroEntrada = args[0];
		String palabra = args[1];
		String nombreFicheroResultado = args[2];

		hacerRecuento(nombreFicheroEntrada, palabra, nombreFicheroResultado);
		// Fin del main
	}
}
