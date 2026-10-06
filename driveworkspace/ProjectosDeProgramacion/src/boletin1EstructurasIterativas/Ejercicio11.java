package boletin1EstructurasIterativas;

public class Ejercicio11 {

	public static void main(String[] args) {
		System.out.println("Voy a mostrar las tablas de multiplicar del 1 al 10");
		for (int producto = 1; producto <= 10; producto++) {
			for (int multiplo = 1; multiplo <= 10; multiplo++) {
				System.out.println(producto * multiplo);
			}
		}
	}

}
