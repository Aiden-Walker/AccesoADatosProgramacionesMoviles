package examenProgramacionColleciones;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class Modelo {
	private TreeSet<Vivienda> catalogo;
	private HashMap<Persona, String> censoEmpadronamiento;
	private HashMap<Agencia, LinkedList<Operacion>> registroOperaciones;

	public Modelo() {
		this.catalogo = new TreeSet<>();
		this.censoEmpadronamiento = new HashMap<>();
		this.registroOperaciones = new HashMap<>();
	}

	// --- MÉTODOS QUE EL ALUMNO DEBE IMPLEMENTAR ---

	public boolean altaVivienda(Vivienda v) {
		if (catalogo.add(v)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean registrarEmpadronamiento(Persona p, String refCatastral) {
		if (censoEmpadronamiento.put(p, refCatastral) == null) {
			return true;
		} else {
			return false;
		}
	}

	public void anyadirOperacionAAgencia(Agencia a, Operacion op) {
		if (!registroOperaciones.containsKey(a)) {
			LinkedList<Operacion> operationListToPut = new LinkedList<Operacion>();
			operationListToPut.add(op);
			registroOperaciones.put(a, operationListToPut);
		} else {
			registroOperaciones.get(a).add(op);
		}
	}

	public Persona obtenerCaseroDePersona(Persona p) {
		Vivienda vivBuscada = this.getViviendaPorReferencia(this.censoEmpadronamiento.get(p));
		Persona casero = vivBuscada.getDuenyo();
		return casero;
	}

	public int contarPersonasViviendoEnCiudad(Ciudad c) {
		int poblacion = 0;
		/*
		 * No podemos recorrer las viviendas de catalogo directamente porque hay algunas
		 * que no tendran a nadie viviendo en ellas, tenemos que recorrer las del censo
		 */
		for (String s : this.censoEmpadronamiento.values()) {
			Vivienda vivActual = this.getViviendaPorReferencia(s);
			if (vivActual.getUbicacion().equals(c)) {
				poblacion++;
			}
		}
		return poblacion;
	}

	public float incrementoMedioPorAgencia(Agencia a) {
		float incrementoTotal = 0.0f;
		LinkedList<Operacion> opsToCheck = this.registroOperaciones.get(a);
		int numHouses = 0;
		for (Operacion currOp : opsToCheck) {
			incrementoTotal += currOp.getPrecioFinal() - currOp.getVivienda().getPrecioActual();
			numHouses++;
		}
		return incrementoTotal / numHouses;
	}

	public HashSet<Persona> obtenerInquilinos() {
		HashSet<Persona> rentistas = new HashSet<Persona>();
		/*
		 * Podemos utilizar el metodo "obtenerCaseroDePersona" hecho en ejercicios
		 * anteriores, si el casero de dicha persona no es el mismo, asumimos que esta
		 * de alquiler
		 */
		for (Persona p : this.censoEmpadronamiento.keySet()) {
			if (!this.obtenerCaseroDePersona(p).equals(p)) {
				rentistas.add(p);
			}
		}
		return rentistas;
	}

	/* Metodos Extra */
	public Vivienda getViviendaPorReferencia(String referenciaBuscada) {
		Vivienda vivADevolver = null;
		boolean enc = false;
		Iterator<Vivienda> iteratingHouses = this.catalogo.iterator();
		while (iteratingHouses.hasNext() && !enc) {
			Vivienda currentHouse = iteratingHouses.next();
			if (currentHouse.getReferenciaCatastral().equals(referenciaBuscada)) {
				vivADevolver = currentHouse;
				enc = true;
			}
		}
		return vivADevolver;
	}
}
