package ejercicioMultiplicador;

public class Multiplica_ej1 {

	public double multiplica(int n1, int n2) {
		double resultado = 1;
		for (double i = n1; i <= n2; i++) {
			resultado = resultado * i;
		}

		return resultado;
	}

	public static void main(String args[]) {

		Multiplica_ej1 m = new Multiplica_ej1();
		double resultado;

		/*
		 * try { Thread.sleep(5*2000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		resultado = m.multiplica(Integer.valueOf(args[0]), Integer.valueOf(args[1]));
		System.out.println(resultado);
	}
}