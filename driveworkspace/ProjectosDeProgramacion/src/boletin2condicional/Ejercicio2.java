package boletin2condicional;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero entero");
		int numintroducido = sc.nextInt();
		int par;
		if (numintroducido % 2 == 0) {
			par = 1;
		} else {
			par = 0;
		}
		par = (numintroducido % 2 == 0) ? 1 : 0;
		System.out.println("Par = " + par);
		sc.close();
	}

}
