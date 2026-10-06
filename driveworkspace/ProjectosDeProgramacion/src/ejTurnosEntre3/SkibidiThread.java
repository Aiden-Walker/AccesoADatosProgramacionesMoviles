package ejTurnosEntre3;

public class SkibidiThread extends Thread {
	String nombre;
	private int myTurn;

	public SkibidiThread(String nombre, IamTheOneWhoStops stopper, int sentTurn) {
		super();
		this.nombre = nombre;
		this.sayCheese = stopper;
		this.myTurn = sentTurn;
	}

	IamTheOneWhoStops sayCheese;

	public void run() {
		for (int i = 0; i <= 10;) {
			if (myTurn == sayCheese.getNextTurn()) {
				sayCheese.helloGuysWelcomeToMyMinecraftGameplay(nombre);
				System.out.println(nombre + "La I es: " + i);
				i++;
			}
		}
	}
}
