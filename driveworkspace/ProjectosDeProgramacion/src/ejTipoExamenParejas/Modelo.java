package ejTipoExamenParejas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Modelo {
	public static final int CORRECTO = 0;
	public static final int YA_EXISTE = 1;

	private LinkedHashSet<Persona> solicitantes;
	private HashMap<Persona, TreeMap<Persona, Persona>> gestoresParejas;

	public Modelo() {
		solicitantes = new LinkedHashSet<>();
		gestoresParejas = new HashMap<Persona, TreeMap<Persona, Persona>>();
	}

	public int anyadeSolicitante(String nombre, Sexo sexoSolicitante, Sexo sexoSolicitado, boolean gestor,
			List<String> aficiones) {
		Persona personToAdd = new Persona(nombre, sexoSolicitante, sexoSolicitado, gestor, aficiones);
		if (solicitantes.add(personToAdd)) {
			if (personToAdd.isGestor()) {
				gestoresParejas.put(personToAdd, new TreeMap<Persona, Persona>());
			}
			return Modelo.CORRECTO;
		} else {
			return Modelo.YA_EXISTE;
		}
	}

	public Set<Persona> getListaGestores() {
		return new HashSet<Persona>(gestoresParejas.keySet());
	}

	public Set<Persona> getListaSolicitantes() {
		return this.solicitantes;
	}

	public Persona getPersona(String nombreABuscar) {
		Iterator<Persona> itrSolicitants = solicitantes.iterator();
		boolean enc = false;
		Persona currPerson = null;
		while (itrSolicitants.hasNext() && !enc) {
			Persona personFound = itrSolicitants.next();
			if (personFound.getNombre().equals(nombreABuscar)) {
				currPerson = personFound;
				enc = true;
			}
		}
		return currPerson;
	}

	public String getListadoAfinidades(String nombreSolicitante) {
		String afinidades = "";
		Persona currPerson = this.getPersona(nombreSolicitante);
		for (Persona p : solicitantes) {
			if (currPerson.getSexoBuscado().equals(p.getSexoBuscado())) {
				afinidades += ("Aficiones comunes de " + currPerson.getNombre() + " y " + p.getNombre()
						+ currPerson.aficionesComunesCon(p) + "\n");
			}
		}
		return afinidades;
	}

	public int creaPareja(String nombreGestor, String nombreSolicitante, String nombrePareja) {
		Persona managerToUse = this.getPersona(nombreGestor);
		Persona requester = this.getPersona(nombreSolicitante);
		Persona match = this.getPersona(nombrePareja);
		if (gestoresParejas.get(managerToUse).put(requester, match) == null) {
			return Modelo.CORRECTO;
		} else {
			return Modelo.YA_EXISTE;
		}
	}

	public String getListadoSolicitantes() {
		String returnThis = "";
		for (Persona p : solicitantes) {
			returnThis += (p.toString());
		}
		return returnThis;
	}

	public String getListadoParejas() {
		String res = "";
		for (TreeMap<Persona, Persona> pareja : gestoresParejas.values()) {
			res += pareja.toString();
		}
		return res;
	}

}
