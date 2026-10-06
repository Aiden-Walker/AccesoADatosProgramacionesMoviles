package solControlPokemon;

import java.util.*;

public class Pokedex {
	private LinkedList<Pokemon> listaPokemons;
	private HashMap<Pokemon, LinkedList<Pokemon>> combates;
	private Principal controlador;

	public Pokedex(Principal controlador) {
		this.controlador = controlador;
		this.listaPokemons = new LinkedList<Pokemon>();
		this.combates = new HashMap<Pokemon, LinkedList<Pokemon>>();
	}

	public boolean guardaPokemon(Pokemon pok) {
		if (this.listaPokemons.contains(pok))
			return false;
		else
			this.listaPokemons.add(pok);
		return true;
	}

	public LinkedList<Pokemon> getListaPokemons() {
		return listaPokemons;
	}

	public void setListaPokemons(LinkedList<Pokemon> listaPokemons) {
		this.listaPokemons = listaPokemons;
	}

	public HashMap<Pokemon, LinkedList<Pokemon>> getCombates() {
		return combates;
	}

	public void setCombates(HashMap<Pokemon, LinkedList<Pokemon>> combates) {
		this.combates = combates;
	}

	public void borraPokemon(String pok) {
		// Mal hecho hay que corregirlo:
		for (Pokemon p : this.listaPokemons)
			if (p.getNombre().equals(pok))
				this.listaPokemons.remove(p);
	}

	private Pokemon buscaPokemon(String nombre) {
		/*
		 * mejor no hacerlo así Pokemon prov = new Pokemon(nombre,"",0,""); return
		 * this.listaPokemons.get(this.listaPokemons.indexOf(prov));
		 */

		for (Pokemon p : this.listaPokemons)
			if (p.getNombre().equals(nombre))
				return p;

		return null;
	}

	public boolean guardaCombate(String ganador, String perdedor) {
		Pokemon pokemonGanador = this.buscaPokemon(ganador);
		Pokemon pokemonPerdedor = this.buscaPokemon(perdedor);

		if (!this.combates.containsKey(pokemonGanador))
			this.combates.put(pokemonGanador, new LinkedList<Pokemon>());

		if (this.combates.get(pokemonGanador).contains(pokemonPerdedor))
			return false;
		else {
			this.combates.get(pokemonGanador).add(pokemonPerdedor);
			pokemonGanador.setPuntos(pokemonGanador.getPuntos() + 1);
		}
		return true;

		/*
		 * PRIMER INTENTO. FUNCIONA, PERO MEJOR COMO ESTÁ ARRIBA
		 * if(this.combates.containsKey(pokemonGanador)) {
		 * if(this.combates.get(pokemonGanador).contains(pokemonPerdedor)) return false;
		 * else { this.combates.get(pokemonGanador).add(pokemonPerdedor); return true; }
		 * 
		 * } else { this.combates.put(pokemonGanador, new LinkedList<Pokemon>());
		 * this.combates.get(pokemonGanador).add(pokemonPerdedor); return true; }
		 */
	}

	public String getListadoTodos() {
		String res = "";
		for (Pokemon p : this.listaPokemons)
			res += p.toString() + "\n";

		return res;
	}

	public String getListadoAlfabeticoMayores(int mínimo) {
		TreeSet<Pokemon> arbol = new TreeSet<Pokemon>();
		for (Pokemon p : this.listaPokemons)
			if (p.getPuntos() > mínimo)
				arbol.add(p);

		String res = "";
		for (Pokemon p : arbol)
			res += p.toString() + "\n";

		return res;
	}

	public String getListadoMayores(int mínimo) {
		String res = "";
		for (Pokemon p : this.listaPokemons)
			if (p.getPuntos() > mínimo)
				res += p.toString() + "\n";

		return res;
	}

	public String getListadoCombates() {
		String res = "";

		for (Pokemon ganador : this.combates.keySet())
			for (Pokemon perdedor : this.combates.get(ganador))
				res += "Ganador: " + ganador.getNombre() + " Perdedor: " + perdedor.getNombre() + "\n";

		return res;
	}

}
