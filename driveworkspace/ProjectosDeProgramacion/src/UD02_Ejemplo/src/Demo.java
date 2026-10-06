package UD02_Ejemplo.src;

public class Demo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hilo uno, dos;

		Thread.currentThread().setName("PRINCIPAL");
		System.out.println(
				"HILO PPAL:" + Thread.currentThread().getName() + " Estado::" + Thread.currentThread().getState());

		uno = new Hilo("JAMAICA");
		dos = new Hilo("FIJI");

		System.out.println("ANTES DEL HILO UNO:" + uno.getState());
		uno.start();

		System.out.println("ANTES DEL HILO DOS:" + dos.getState());
		dos.start();

		try {
			uno.join();
			System.out.println("DESPUÉS DEL HILO UNO:" + uno.getState());
			dos.join();
			System.out.println("DESPUÉS DEL HILO DOS:" + dos.getState());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// El bloque de código anterior es equivalente al siguiente
//		while (!(uno.getState() == Thread.State.TERMINATED)) {
//			//No hago nada
//		}
//		while (!(dos.getState() == Thread.State.TERMINATED)) {
//			//No hago nada
//		}			
		System.out.println("DESPUÉS DEL HILO UNO:" + uno.getState());
		System.out.println("DESPUÉS DEL HILO DOS:" + dos.getState());

	}
}
