package boletin1;

import java.util.Scanner;

public class ScannerExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Inserte un numero");
		int num=sc.nextInt();
		
		System.out.println("El numero insertado es " + num);
		
		System.out.println("Inserte una palabra");
		String palabra=sc.next();
		System.out.println("La palabra insertada es " + palabra);
		sc.close();
	}

}
