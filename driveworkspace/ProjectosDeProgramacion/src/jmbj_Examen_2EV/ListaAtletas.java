package jmbj_Examen_2EV;

import java.util.Arrays;

public class ListaAtletas {
	private Atleta[] tabla = new Atleta[10];
	private int numAtletas = 0;

	public ListaAtletas() {

	}

	public Atleta[] getTabla() {
		return tabla;
	}

	public void anyadeAtleta(Atleta a) {
		if (numAtletas >= tabla.length) {
			tabla = Arrays.copyOf(tabla, numAtletas + 10);
		}
		tabla[numAtletas++] = a;

	}

	// Apartado a)
	public boolean contieneAtleta(Atleta a) {
		boolean hayAtleta = false;
		/*
		 * De primera mano vamos a asumir que no esta el atleta. Vamos a recorrer la
		 * tabla de atleta hasta el numero de atletas, llamando al metodo equals de
		 * atletta cada vez, si vemos que el atleta pasado por parametro coincide con el
		 * que estamos comprobando en la tabla, entonces el metodo devolvera verdadero
		 */
		for (int i = 0; i < numAtletas && !hayAtleta; i++) {
			if (a.equals(tabla[i])) {
				hayAtleta = true;
			}
		}
		/*
		 * Para evitar recorrer la tabla mas veces de la necesaria tambien pongo como
		 * condicion que solo recorra la tabla si ademas hayAtleta es falso
		 */
		return hayAtleta;
	}

	public int getNumAtletas() {
		return numAtletas;
	}

	public Atleta getAtleta(int i) {
		return tabla[i];
	}

	@Override
	public String toString() {
		return "ListaAtletas [tabla=" + Arrays.toString(tabla) + "]";
	}

}
