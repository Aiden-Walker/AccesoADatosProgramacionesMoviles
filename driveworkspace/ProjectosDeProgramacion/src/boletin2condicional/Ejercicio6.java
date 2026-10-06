package boletin2condicional;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime cuantas horas has trabajado esta semana");
		int horas = sc.nextInt();
		int sueldo=0;
		if (horas <=40) {
			sueldo = horas*12;
		} else if(horas >40){
			sueldo = (40*12)+(horas-40)*16;
		} else {
			System.out.println("Las horas introducidas no son validas");
		}
		System.out.println("Su sueldo es de: "+sueldo+" Euros");
		sc.close();
	}

}
