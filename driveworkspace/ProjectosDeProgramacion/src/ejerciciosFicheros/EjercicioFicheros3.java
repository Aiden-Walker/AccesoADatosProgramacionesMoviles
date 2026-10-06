package ejerciciosFicheros;

import java.io.*;
import java.util.Scanner;

public class EjercicioFicheros3 {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		copiFich1();
		copiFich2();
	}

	public static void copiFich1() {
		try (FileReader fr = new FileReader("original.txt");
				BufferedReader br = new BufferedReader(fr);
				FileWriter fw = new FileWriter("copia.txt");
				BufferedWriter bw = new BufferedWriter(fw)) {
			String linetoWrite = br.readLine();
			while (linetoWrite != null) {
				bw.write(linetoWrite);
				linetoWrite = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void copiFich2() {
		System.out.println("Write the name of the original file: ");
		String fichToWrite = sc.next();
		try (FileReader fr = new FileReader(fichToWrite);
				BufferedReader br = new BufferedReader(fr);
				FileWriter fw = new FileWriter("copia_de"+fichToWrite);
				BufferedWriter bw = new BufferedWriter(fw)) {
			String linetoWrite = br.readLine();
			while (linetoWrite != null) {
				bw.write(linetoWrite);
				linetoWrite = br.readLine();
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
