package ejerciciosFicheros;

import java.io.*;

public class EjercicioFicheros5 {

	public static void main(String[] args) {
		try (FileReader fr = new FileReader("numeros.txt");BufferedReader br = new BufferedReader(fr)){
			int greatest = Integer.MIN_VALUE;
			int lessest = Integer.MAX_VALUE;
			int currentInt = br.read();
			while(currentInt != -1) {
				System.out.println(currentInt);
				if(currentInt > greatest) {
					greatest = currentInt;
				}
				if(currentInt < lessest) {
					lessest = currentInt;
				}
				currentInt = br.read();
			}
			System.out.println("The greatest int gotten is: "+greatest+" And the lessest is "+lessest);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
