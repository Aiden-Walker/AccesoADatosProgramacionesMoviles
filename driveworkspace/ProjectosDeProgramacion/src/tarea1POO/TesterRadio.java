package tarea1POO;

public class TesterRadio {

	public static void main(String[] args) {
		SintonizadorDigital ultraFM = new SintonizadorDigital(96);
		System.out.println(ultraFM.toString());
		ultraFM.down();
		ultraFM.down();
		ultraFM.down();
		System.out.println(ultraFM.toString());
		
		SintonizadorDigital lowPowFM = new SintonizadorDigital(80.2f);
		System.out.println(lowPowFM.toString());
		lowPowFM.down();
		System.out.println(lowPowFM.toString());
		
		SintonizadorDigital highPowFM = new SintonizadorDigital(107.8f);
		System.out.println(highPowFM.toString());
		highPowFM.up();
		System.out.println(highPowFM.toString());
	}

}
