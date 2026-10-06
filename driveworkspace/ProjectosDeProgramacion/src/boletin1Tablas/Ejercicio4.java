package boletin1Tablas;

import java.util.Scanner;

public class Ejercicio4 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Dime cual quieres que sea la longitud de la clave");
		int longitud = sc.nextInt();
		int[] claveSpookyScary = creacionClave(longitud);
		intentoDeAdivinar(claveSpookyScary);
		sc.close();
	}

	static int[] creacionClave(int longitudClave) {
		int[] clave = new int[longitudClave];
		for (int i = 0; i < clave.length; i++) {
			clave[i] = (int) (Math.random() * 5 + 1);
		}
		return clave;
	}

	static void intentoDeAdivinar(int[] claveCifrada) {
		boolean haSidoAcertada = false;
		while (haSidoAcertada == false) {
			int contadorAciertos = 0;
			for (int contadorDigits = 0; contadorDigits < claveCifrada.length; contadorDigits++) {
				System.out.println("Intenta adivinar un digito");
				int digitoIntroducido = sc.nextInt();
				if (digitoIntroducido == claveCifrada[contadorDigits]) {
					contadorAciertos++;
					System.out.println("El numero es correcto");
				} else if (digitoIntroducido < claveCifrada[contadorDigits]) {
					System.out.println("El numero es mas grande");
				} else if (digitoIntroducido > claveCifrada[contadorDigits]) {
					System.out.println("El numero es mas pequeño");
				}
			}
			if (contadorAciertos == claveCifrada.length) {
				haSidoAcertada = true;
				System.out.println("¡¡¡Felicidades, has acertado!!!");
			} else {
				System.out.println("Has fallado... Intentalo de nuevo");
			}
		}
	}
}
