package ejerciciosFicheros;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EjercicioFicheros2 {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Introduce tu nombre");
		String nombre = sc.next();
		System.out.println("Ahora introduce tu edad");
		int edad = sc.nextInt();
		String info = nombre + edad;
		try (FileWriter fw = new FileWriter("datos.txt")){
			fw.write(info);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
