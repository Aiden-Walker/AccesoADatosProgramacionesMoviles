package tema1ProgramacionDeServiciosYProcesos;

public class Multiplicador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero1 = 1;
		int numero2 = 10;
		double numeroFunny = multiplica(numero1, numero2);
		System.out.println("El resultado de multiplicar todos los numeros entre " + numero1 + " Y " + numero2 + " Es: "
				+ numeroFunny);
	}

	public static double multiplica(int n1, int n2) {
		double resultado = 1;
		for (int i = n1; i <= n2; i++) {
			resultado *= i;
		}
		return resultado;
	}
}
