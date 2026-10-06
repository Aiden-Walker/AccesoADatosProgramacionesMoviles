package jmbj_Examen_2EV;

import java.util.Arrays;

public class GestionJJOO {
	public static void main(String[] args) {
		/* Nota, voy a hacer el examen entero en Esanyol por motivos de claridad */
		// 1. Creación de Atletas
		Atleta a1 = new Atleta("Johannes Boe", 5);
		Atleta a2 = new Atleta("Quentin Fillon", 2);
		Atleta a3 = new Atleta("Marte Olsbu", 3);
		Atleta a4 = new Atleta("Therese Johaug", 3);
		Atleta a5 = new Atleta("Irene Schouten", 3);

		// 2. Creación de Países
		Pais noruega = new Pais("Noruega");
		Pais francia = new Pais("Francia");
		Pais paisesBajos = new Pais("Países Bajos");

		// 3. Asignación a delegaciones
		noruega.getAtletas().anyadeAtleta(a1); // Boe (Nor)
		noruega.getAtletas().anyadeAtleta(a3); // Marte (Nor)
		noruega.getAtletas().anyadeAtleta(a4); // Johaug (Nor)
		francia.getAtletas().anyadeAtleta(a2); // Fillon (Fra)
		paisesBajos.getAtletas().anyadeAtleta(a5); // Schouten (PB)

		Pais[] jjoo = { noruega, francia, paisesBajos };

		// --- PRUEBA APARTADO A: contieneAtleta ---
		System.out.println("a) ¿Noruega tiene a Boe?: " + noruega.getAtletas().contieneAtleta(a1));
		System.out.println("a) ¿Noruega tiene a Schouten?: " + noruega.getAtletas().contieneAtleta(a5));

		// --- PRUEBA APARTADO B: registrarRival ---
		hacerRivales(a1, a2); // Válido (Boe vs Fillon)
		hacerRivales(a1, a1); // Inválido (Mismo atleta)
		hacerRivales(a3, a2); // Válido (Marte vs Fillon)
		hacerRivales(a5, a2); // Válido (Schouten vs Fillon)

		System.out.println("\nb) Rivales registrados: ");
		System.out.println(a1);// Johannes Boe tiene como rival a [Quentin Fillon]
		System.out.println(a2);// Quentin Fillon tiene como rival a [Johannes Boe, Marte, Schouten]
		System.out.println(a3);// Marte tiene como rival a [Quentin Fillon]
		System.out.println(a4);// Therese Johaug no tiene rivales
		System.out.println(a5);// Schouten tiene como rival a Quentin Fillon

		// --- PRUEBA APARTADO C: hayErrores ---
		System.out.println("\nc) Errores antes de fallo: " + hayErrores(jjoo));
		// Forzamos error: Marte (Nor) registra como rival a Boe (Nor)
		a3.registrarRival(a1);
		System.out.println("c) Errores tras registro erróneo (mismo país): " + hayErrores(jjoo));

		// --- PRUEBA APARTADO D: getAtletasOrdenados ---
		// Noruega tiene a Boe (5), Marte (3) y Johaug (3).
		System.out.println("\nd) Atletas de Noruega ordenados:");
		Atleta[] noruegosOrd = getAtletasOrdenados(noruega);
		for (Atleta at : noruegosOrd) {
			System.out.println("- " + at.getNombre() + " (" + at.getMedallasOro() + " oros)");
		}

		// --- PRUEBA APARTADO E: paisMenosMedallas ---
		Pais menosLaureado = paisMenosMedallas(jjoo);
		System.out.println("\ne) País con menos medallas: " + menosLaureado.getNombre());

		// --- PRUEBA APARTADO F: rivalesEnComun ---
		// Registramos otro rival común para Boe (a1) y Marte (a3)
		Atleta a6 = new Atleta("Otro Rival Común", 1);
		hacerRivales(a1, a6);
		hacerRivales(a3, a6);
		System.out.println("\nf) Rivales en común entre Boe y Marte: ");
		ListaAtletas comunes = a1.rivalesEnComun(a3);
		for (int i = 0; i < comunes.getNumAtletas(); i++) {
			System.out.println(comunes.getAtleta(i).getNombre());
		}
	}

	/**
	 * Establece una relación de rivalidad bidireccional entre dos atletas.
	 */
	public static void hacerRivales(Atleta a, Atleta b) {
		a.registrarRival(b);
		b.registrarRival(a);
	}

	// Apartado c)
	public static boolean hayErrores(Pais[] paisesJJOO) {
		boolean hayError = false;
		/* Asumimos que no hay errores hasta que se demuestre lo contrario */
		for (int i = 0; i < paisesJJOO.length && !hayError; i++) {
			/*
			 * Aqui deberiamos hacer un bucle for doble: Bucle for1: Recorremos todos los
			 * atletas de un pais. Bucle for2: Recorremos todos los rivales de dichos
			 * atletas, y comprobamos su nacionalidad para ver si existen errores
			 */
			for (int j = 0; j < paisesJJOO[i].getAtletas().getNumAtletas() && !hayError; j++) {
				/*
				 * Aqui ya podemos recorrer los rivales de cada atleta de cada pais y ver si
				 * alguno de sus rivales tiene su misma nacionalidad (Es decir, se encuentra en
				 * el mismo array de paises)
				 */
				/*
				 * La comprobacion dicha arriba se podria hacer utilizando el metodo
				 * contieneAtleta hecho en ejercicios anteriores
				 */
				Atleta atletaActual = paisesJJOO[i].getAtletas().getAtleta(j);
				for (int z = 0; z < atletaActual.getRivales().getNumAtletas() && !hayError; z++) {
					if (paisesJJOO[i].getAtletas().contieneAtleta(atletaActual.getRivales().getAtleta(z))) {
						hayError = true;
					}
				}
			}
		}
		return hayError;
	}

	// Apartado d)
	public static Atleta[] getAtletasOrdenados(Pais pais) {
		/*
		 * Este metodo se puede realizar facilmente con Arrays.sort, cabe recordar que
		 * el sort utilizara la ordenacion natural de os atletas, que nosotros hemos
		 * hecho en el primer apartado
		 */
		/*
		 * Tambien debemos hacer un arrays.copy of con el numero de atletas de la tabla
		 * de atletas del pais para que si o si no haya nulos
		 */
		Atleta[] tablaOrdenada = Arrays.copyOf(pais.getAtletas().getTabla(), pais.getAtletas().getNumAtletas());
		Arrays.sort(tablaOrdenada);
		return tablaOrdenada;
	}

	// Apartado e)
	public static Pais paisMenosMedallas(Pais[] paisesJJOO) {
		/*
		 * Para esto habra que recorrer los paises en un bucle que compare las medallas
		 * de cada pais con las medallas de un "pais menos galardonado"
		 */
		Pais paisMenosGalardonado = paisesJJOO[0];
		int medallasPaisMenosGalardonado = Integer.MAX_VALUE;
		/*
		 * Para evitar tener que crear un pais completamente desde 0 vamos a decir que
		 * el pais menos galardonado es el pais "0" de la tabla, como lo vamos a
		 * comparar de todas maneras con TODOS los paises esto no deberia suponernos un
		 * problema
		 */
		for (int i = 0; i < paisesJJOO.length; i++) {
			/*
			 * Aunque el pais que hemos creado para ahorrar tiempo es el pais 0, tenemos que
			 * recorrer sus atletas tambien para sumar su numero de medallas
			 */
			int sumaMedallas = 0;
			/* Esa sera la suma de medallas del pais actual */
			for (int j = 0; j < paisesJJOO[i].getAtletas().getNumAtletas(); j++) {
				/*
				 * Ahora tendremos que ver cual es el total de medallas del pais sumandole las
				 * medallas de cada atleta
				 */
				sumaMedallas += paisesJJOO[i].getAtletas().getAtleta(j).getMedallasOro();
			}
			/*
			 * Una vez finalizado el bucle j, comparamos la suma de medallas con las del
			 * pais menos galardonado
			 */
			if (sumaMedallas < medallasPaisMenosGalardonado) {
				paisMenosGalardonado = paisesJJOO[i];
				medallasPaisMenosGalardonado = sumaMedallas;
			}
		}
		return paisMenosGalardonado;
	}

}
