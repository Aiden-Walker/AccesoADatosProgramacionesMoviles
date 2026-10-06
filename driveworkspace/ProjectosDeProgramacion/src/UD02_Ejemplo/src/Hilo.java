package UD02_Ejemplo.src;

public class Hilo extends Thread {
	// static private int contador =0;

	public Hilo(String str) {
		super(str);
	}

	public void run() {

		for (int i = 0; i < 10; i++) {
			// System.out.println("HILO " + getName() + ": " + getState());

			System.out.println(i + " " + getName() + " " + getState());
			/*
			 * try{ sleep((long) (Math.random()*1000)); }catch(InterruptedException e){
			 * 
			 * }
			 */
		}

	}
}
