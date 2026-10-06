package ejTipoExamenParejas;

import java.util.LinkedList;
import java.util.List;

public class Persona {
	public static final boolean HOMBRE = true;
	public static final boolean MUJER = false;

	private String nombre;
	private Sexo sexoPropio;
	private Sexo sexoBuscado;
	private boolean esGestor;
	private LinkedList<String> aficiones = new LinkedList<>();

	public Persona(String nombre, Sexo sexoPropio, Sexo sexoBuscado, boolean esGestor, List<String> gustos) {
		this.nombre = nombre;
		this.sexoPropio = sexoPropio;
		this.sexoBuscado = sexoBuscado;
		this.esGestor = esGestor;
		this.aficiones.addAll(gustos);
	}

	public String aficionesComunesCon(Persona otra) {
		String aficionesComunes = "";
		for (int i = 0; i < this.aficiones.size(); i++) {
			for (int j = 0; j < otra.aficiones.size(); j++) {
				if (this.aficiones.get(i).equals(otra.aficiones.get(j))) {
					aficionesComunes += (" " + this.aficiones.get(i) + " ");
				}
			}
		}
		return aficionesComunes;
	}

	@Override
	public String toString() {
		String result = "Nombre... " + this.getNombre() + "\n Sexo Propio... " + this.getSexoPropio()
				+ "\n Sexo Buscado... " + this.getSexoBuscado() + "\n Es gestor... " + this.isGestor()
				+ "\n Aficiones...\n" + this.aficiones.toString();
		return result;
	}

	public boolean isGestor() {
		return esGestor;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Sexo getSexoPropio() {
		return sexoPropio;
	}

	public Sexo getSexoBuscado() {
		return sexoBuscado;
	}
}
