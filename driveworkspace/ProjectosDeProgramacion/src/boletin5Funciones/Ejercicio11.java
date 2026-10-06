package boletin5Funciones;

public class Ejercicio11 {

	public static void main(String[] args) {
		/* Version Iterativa */
		int baseIterativaUsuario = 10;
		int exponenteIterativoUsuario = 1;
		System.out.println(potenciaIterativa(baseIterativaUsuario, exponenteIterativoUsuario));
		/* Version Recursiva */
		int baseRecursivaUsuario = 5;
		int exponenteRecursivoUsuario = 2;
		System.out.println(potenciaRecursiva(baseRecursivaUsuario, exponenteRecursivoUsuario));

	}

	static int potenciaIterativa(int baseIterativa, int exponenteIterativo) {
		int resultadoPotenciaIterativa = baseIterativa;
		for (int contadorPotencia = 1; contadorPotencia <= exponenteIterativo; contadorPotencia++) {
			resultadoPotenciaIterativa *= resultadoPotenciaIterativa;
		}
		return resultadoPotenciaIterativa;
	}

	static int potenciaRecursiva(int baseRecursiva, int exponenteRecursivo) {
		int resultadoPotenciaRecursiva = baseRecursiva;
		if (exponenteRecursivo == 0) {
			resultadoPotenciaRecursiva = 1;
		} else {
			resultadoPotenciaRecursiva = resultadoPotenciaRecursiva
					* potenciaRecursiva(resultadoPotenciaRecursiva, exponenteRecursivo - 1);
		}
		return resultadoPotenciaRecursiva;
	}
}