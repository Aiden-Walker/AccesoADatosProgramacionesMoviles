package ejerciciosFicheros;

import java.io.*;
import java.util.*;

public class EjercicioFicheros4 {

	public static void main(String[] args) {
		try (FileReader fr = new FileReader("cara.txt");BufferedReader br = new BufferedReader(fr)){
			int caracteres = 0;
			int palabras = 0;
			int lineas = 0;
			String currentLine = br.readLine();
			while(currentLine != null) {
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
