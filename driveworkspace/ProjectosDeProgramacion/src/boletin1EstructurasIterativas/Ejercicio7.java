package boletin1EstructurasIterativas;

public class Ejercicio7 {

	public static void main(String[] args) {
		int product = 1;
		for (int counter = 1; counter < 20; counter++) {
			if (counter % 2 != 0) {
				product *= counter;
			}
		}
		System.out.println("El producto de todos los numeros es "+product);
	}
}
