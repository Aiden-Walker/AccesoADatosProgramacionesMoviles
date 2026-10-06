package ejercicio1Boletin1ProgramacionMultihilo;

public class Main {

	public static void main(String[] args) {
		Teclado teclado = new Teclado();
		Hilo3 theOnePiece = new Hilo3(teclado);
		theOnePiece.start();
		Hilo1 one = new Hilo1(teclado);
		Hilo2 two = new Hilo2(teclado);
		one.start();
		two.start();
	}

}
