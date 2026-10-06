package tarea1Herencia;

public class SkibidiTester {

	public static void main(String[] args) {
		Piano devilsGaze = new Piano();
		Campana SCP_513 = new Campana();
		Caja amazonDelivery = new Caja(6, 7, 6, Unidades.m);

		System.out.println(amazonDelivery.toString());

		devilsGaze.addNota(NotaMusical.DO);
		devilsGaze.addNota(NotaMusical.RE);
		devilsGaze.addNota(NotaMusical.MI);

		SCP_513.addNota(NotaMusical.FA);
		SCP_513.addNota(NotaMusical.SOL);
		SCP_513.addNota(NotaMusical.LA);

		devilsGaze.interpretar();
		System.out.println(devilsGaze.toString());
		SCP_513.interpretar();
		System.out.println(SCP_513.toString());
	}

}
