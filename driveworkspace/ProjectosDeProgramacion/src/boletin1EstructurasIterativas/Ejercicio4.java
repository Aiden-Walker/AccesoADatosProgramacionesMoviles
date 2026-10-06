package boletin1EstructurasIterativas;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero");
		int n = sc.nextInt();
		for (int counter = 1; counter <= n; counter++) {
			System.out.println(counter);
		}
		sc.close();
	}

}
