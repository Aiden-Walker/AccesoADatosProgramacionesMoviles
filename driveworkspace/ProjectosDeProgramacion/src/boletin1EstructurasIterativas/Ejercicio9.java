package boletin1EstructurasIterativas;

import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int etarbolmasalto = 0;
		int altarbolmasalto = 0;
		int etiqueta=0;
		System.out.println("Introduce la altura de un arbol (-1 para acabar el programa)");
		int input = sc.nextInt();
		while (input>0) {
			if (input>altarbolmasalto) {
				altarbolmasalto=input;
				etarbolmasalto=etiqueta;
			}
			etiqueta++;
			System.out.println("Introduce la altura de otro arbol");
			input = sc.nextInt();
		}
		System.out.println("El arbol mas alto es el arbol con la etiqueta "+etarbolmasalto+" con una altura de "+altarbolmasalto);
		sc.close();
	}

}
