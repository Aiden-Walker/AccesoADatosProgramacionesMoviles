package tarea1POO;

public class Ejercicio1POO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CuentaCorriente.setNombreBanco("BBVA");
		Banco bancoSantander = new Banco("Santander", 100000, "Barcelona");
		Banco bancoShady = new Banco("ShadowBank", "SkibidiLand");
		bancoSantander.toString();
		bancoSantander.getNOMBRE();

		CuentaCorriente cc1 = new CuentaCorriente("Pepe", "1111A");
		System.out.println("Sacando 100 euros: " + cc1.sacarDinero(100));
		cc1.ingresarDinero(200);
		cc1.infoCuenta();

		CuentaCorriente cuentaShadowy = new CuentaCorriente(70, -100, "SkibidiLord", bancoShady);
		System.out.println("I NEED MORE BULLETS (sacando 100 euros de la cuenta)" + cuentaShadowy.sacarDinero(100));
		cuentaShadowy.ingresarDinero(1000);// Que no lo vea hacienda xd
		cuentaShadowy.infoCuenta();

		System.out.println(CuentaCorriente.getNombreBanco());

		Texto textofunny = new Texto("Me llaman Don, Don Flamenco", 100);
		textofunny.anyadirCaracter("S");
		textofunny.anyadirCadena("Jamas has visto una rosa negra?");
		textofunny.contarVocales();
		Bombilla.setEstanPlomosEnc(true);
		System.out.println(Bombilla.isEstanPlomosEnc());
		Bombilla salon = new Bombilla(true);
		Bombilla sotano = new Bombilla(false);

		salon.estaLaBombillaEncendida();
		sotano.estaLaBombillaEncendida();
		salon.clickInterruptor();
		sotano.clickInterruptor();
		salon.estaLaBombillaEncendida();
		sotano.estaLaBombillaEncendida();
		Bombilla.sabotearRepararFusibles();
		// What did you do with big chungus, we know you're the sus imposter, and I saw
		// you vent, in electrical
		salon.estaLaBombillaEncendida();
		sotano.estaLaBombillaEncendida();
	}

}
