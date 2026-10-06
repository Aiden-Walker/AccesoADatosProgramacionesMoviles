package ejercicioTipoExamenVistaComercial;

import java.util.*;

import ejTipoExamenFeria.Consumicion;

public class Modelo {
	private HashMap<Comercial, TreeSet<Empresa>> asignaciones;
	private Vector<Visita> visitas;

	public Modelo() {
		this.asignaciones = new HashMap<Comercial, TreeSet<Empresa>>();
		this.visitas = new Vector<Visita>();
	}

	public void anyadeComercial(Comercial c) {
		// anyade al mapa de asignaciones una nueva pareja con el comercial pasado como
		// parimetro y un conjunto nuevo vacio de empresas asignadas.
		TreeSet<Empresa> bottomText = new TreeSet<>();
		asignaciones.put(c, bottomText);
	}

	public void asignaEmpresaAComercial(Comercial c, Empresa e) {
		// asigna la empresa pasada como parimetro al conjunto de empresas que tiene
		// asignadas
		// el comercial pasado como parimetro.
	}

	public void anyadeVisita(Visita visita) {
		this.visitas.add(visita);
	}

	public boolean hayErrores() {
		// Devuelve true si hay alguna visita hecha por un comercial a una empresa que
		// NO estaba
		// asignada a ese comercial. Devuelve false en otro caso.
		boolean isThereAMistake = false;
		return isThereAMistake;
	}

	public float totalComprasPorComercial(Comercial c) {
		// Devuelve el total de compras hechas por las empresas asignadas al comercial
		// pasado como parimetro.
		return 0;
	}

	public float totalVentasPorEmpresa(Empresa e) {
		// Devuelve el total de ventas hechas por todos los comerciales asignados a
		// la empresa pasada como parimetro.
		return 0;
	}

	public TreeSet<Comercial> comercialesQueVisitaronEnElMes(int mes) {
		// Devuelve un TreeSet con todos los comerciales que hicieron alguna visita
		// en el mes pasado como parimetro.
		TreeSet<Comercial> visitors = new TreeSet<>();
		for (Visita v : this.visitas) {
			if (v.getMes() == mes) {
				visitors.add(v.getComercial());
			}
		}
		return visitors;
	}

	public TreeSet<String> nombresDeEmpresasNoVisitadas() {
		// Devuelve un TreeSet con todas las empresas que no han recibido ninguna
		// visita.
		TreeSet<String> notVisited = new TreeSet<>();
		HashSet<Empresa> visited = new HashSet<>();
		for (Visita v : this.visitas) {
			visited.add(v.getEmpresa());
		}
		for (TreeSet<Empresa> conjuntoEmpresas : this.asignaciones.values()) {
			for (Empresa emp : conjuntoEmpresas) {
				if (!visited.contains(emp)) {
					notVisited.add(emp.getNombre());
				}
			}
		}//You must gangman, like I have
		return notVisited;
	}

	public TreeMap<Comercial, LinkedList<Visita>> mapaVisitasPorComercial() {
		// Devuelve un mapa con todos los comerciales como claves, y el valor asociado a
		// cada comercial es una LinkedList de las visitas que ha hecho ese comercial.
		TreeMap<Comercial, LinkedList<Visita>> mapADevolver = new TreeMap<Comercial, LinkedList<Visita>>();
		for (Comercial c : this.asignaciones.keySet()) {
			mapADevolver.put(c, new LinkedList<Visita>());
		}
		Iterator<Visita> visitItr = visitas.iterator();
		while (visitItr.hasNext()) {
			Visita currentVist = visitItr.next();
			Comercial keyToUse = currentVist.getComercial();
			mapADevolver.get(keyToUse).add(currentVist);
		}
		return mapADevolver;
	}

}
