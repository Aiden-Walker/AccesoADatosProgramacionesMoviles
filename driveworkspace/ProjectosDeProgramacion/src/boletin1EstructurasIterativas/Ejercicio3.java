package boletin1EstructurasIterativas;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int secretnumber = (int) (Math.random() * 101);
		int input;
		System.out.println("Intenta adivinar el numero secreto");
		input = sc.nextInt();
		while (input != secretnumber && input > 0) {
			if (input < secretnumber) {
				System.out.println("El numero secreto es mayor");
			} else {
				System.out.println("El numero secreto es menor");
			}
			System.out.println("Vuelve a intentarlo (introduce -1 para finalizar el programa)");
			input = sc.nextInt();
		}
		System.out.println("GG");
		sc.close();
	}

}
