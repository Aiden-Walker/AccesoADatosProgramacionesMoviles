package ejercicio2InterfacesGraficas;

import java.util.*;

public class Principal {
	private Pokedex modelo;
	private VentanaPpal vista;

	public Principal() {
		this.modelo = new Pokedex(this);
		this.vista = new VentanaPpal(this);
		this.vista.setVisible(true);
	}

	public static void main(String args[]) {
		new Principal();
	}

	public boolean guardaPokemon(Pokemon pok) {

		return this.modelo.guardaPokemon(pok);
	}

	public LinkedList<Pokemon> getListaPokemons() {

		return this.modelo.getListaPokemons();
	}

	public void borraPokemon(String pok) {
		this.modelo.borraPokemon(pok);

	}

	public boolean guardaCombate(String ganador, String perdedor) {

		return this.modelo.guardaCombate(ganador, perdedor);
	}

	public String getListadoTodos() {

		return this.modelo.getListadoTodos();
	}

	public String getListadoAlfabeticoMayores(int mínimo) {

		return this.modelo.getListadoAlfabeticoMayores(mínimo);
	}

	public String getListadoMayores(int mínimo) {

		return this.modelo.getListadoMayores(mínimo);
	}

	public String getListadoCombates() {

		return this.modelo.getListadoCombates();
	}
}
