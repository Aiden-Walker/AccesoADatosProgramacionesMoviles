package ejerciciosFicheros;

import java.util.Scanner;
import java.io.*;

public class EjercicioFicheros1 {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Write the name of a file: ");
		String fileToRead = sc.next();
		try (FileReader fr = new FileReader(fileToRead)){
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			FileReader fr = new FileReader("prueba.txt");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
