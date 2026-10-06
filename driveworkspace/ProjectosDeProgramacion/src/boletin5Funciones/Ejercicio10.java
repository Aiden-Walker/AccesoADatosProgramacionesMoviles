package boletin5Funciones;

public class Ejercicio10 {

	public static void main(String[] args) {
		int amigo1 = 1184;
		int amigo2 = 1210;
		System.out.println("¿¿¿Son los numeros amigos??? " + divisoresAmigo(amigo1, amigo2));
	}

	static boolean divisoresAmigo(int posibleAmigo1, int posibleAmigo2) {
		boolean sonAmigos = false;
		int sumaDivisoresPAmigo1 = 0;
		int sumaDivisoresPAmigo2 = 0;
		for (int contadorComprobaciones = 1; contadorComprobaciones < posibleAmigo1; contadorComprobaciones++) {
			if (posibleAmigo1 % contadorComprobaciones == 0) {
				sumaDivisoresPAmigo1 += contadorComprobaciones;
			}
		}
		for (int contadorComprobaciones = 1; contadorComprobaciones < posibleAmigo2; contadorComprobaciones++) {
			if (posibleAmigo2 % contadorComprobaciones == 0) {
				sumaDivisoresPAmigo2 += contadorComprobaciones;
			}
		}
		if (sumaDivisoresPAmigo1 == posibleAmigo2 && sumaDivisoresPAmigo2 == posibleAmigo1) {
			sonAmigos = true;
		}
		return sonAmigos;
	}
}
