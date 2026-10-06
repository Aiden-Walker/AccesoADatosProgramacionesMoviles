package ejTurnosEntre3;

public class Unc {

	public static void main(String[] args) {
		IamTheOneWhoStops holdIt = new IamTheOneWhoStops();
		SkibidiThread hilo1 = new SkibidiThread("Hilo1", holdIt, 0);
		SkibidiThread hilo2 = new SkibidiThread("Hilo2", holdIt, 1);
		SkibidiThread hilo3 = new SkibidiThread("Hilo3", holdIt, 2);
		hilo1.start();
		hilo2.start();
		hilo3.start();
	}

}
