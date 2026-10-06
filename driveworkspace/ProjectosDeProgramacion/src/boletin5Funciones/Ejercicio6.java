package boletin5Funciones;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe una letra, te dire si es una vocal o no");
		char letraUsuario = sc.next().charAt(0);
		System.out.println("¿Es la letra una vocal? " + checkerDeVocal(letraUsuario));
		sc.close();
	}

	static boolean checkerDeVocal(char letraAEvaluar) {
		boolean esVocal = false;
		switch (letraAEvaluar) {
		case 'a', 'e', 'i', 'o', 'u': {
			esVocal = true;
			break;
		}
		default:
			esVocal = false;
		}
		return esVocal;
	}
}
