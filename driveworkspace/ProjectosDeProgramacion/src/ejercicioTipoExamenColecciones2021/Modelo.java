package ejercicioTipoExamenColecciones2021;

import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Modelo {

	private TreeMap<Localidad, HashSet<Vuelo>> conexiones;
	private TreeSet<LineaAerea> lineas;

	public Modelo() {
		this.conexiones = new TreeMap<Localidad, HashSet<Vuelo>>();
		this.lineas = new TreeSet<LineaAerea>();
	}

	public void addLinea(LineaAerea linea) {
		this.lineas.add(linea);
	}

	public void addLocalidad(Localidad localidad) {
		// añade al mapa de conexiones una nueva pareja con la localidad
		// pasada como parámetro y un nuevo conjunto de vuelos vacío.
		conexiones.put(localidad, new HashSet<Vuelo>());
	}

	public void addVueloALocalidad(Localidad localidad, Vuelo vuelo) {
		// añade el vuelo pasado como parámetro al conjunto de vuelos asociado a
		// la localidad pasada como parámetro.
		conexiones.get(localidad).add(vuelo);
	}

	public boolean hayErrores() {
		// devuelve un boolean indicando si hay errores en los datos, es decir,
		// si hay algún vuelo con la misma localidad de origen que de destino.
		for (Localidad l : conexiones.keySet()) {
			for (Vuelo v : conexiones.get(l)) {
				if (l.equals(v.getDestino())) {
					return true;
				}
			}
		}
		return false;
	}

	public int numVuelosALocsMillon(Localidad loc) {
		// devuelve un entero con el número de vuelos que parten de la localidad
		// pasada como parámetro y llegan a localidades con más de 1.000.000 habs.
		int numVuelosQueCumplenCondiciones = 0;
		for (Vuelo v : conexiones.get(loc)) {
			if (v.getDestino().getHabitantes() > 1000000) {
				numVuelosQueCumplenCondiciones++;
			}
		}
		return numVuelosQueCumplenCondiciones;
	}

	public TreeSet<LineaAerea> lineasHasta(Localidad localidad) {
		// devuelve un TreeSet con todas las líneas aéreas que tienen vuelos hacia
		// la localidad pasada como parámetro.
		TreeSet<LineaAerea> answer = new TreeSet<>();
		for (Localidad l : conexiones.keySet()) {
			for (Vuelo v : conexiones.get(l)) {
				if (v.getDestino().equals(localidad)) {
					answer.add(v.getLinea());
				}
			}
		}
		return answer;
	}

	public int totalAvionesDesde(Localidad localidad) {
		// devuelve un entero con la suma de todos los aviones que tienen las líneas
		// que hacen vuelos desde la localidad pasada como parámetro.
		int sumAviones = 0;
		
		for (Localidad loc : conexiones.keySet()) {
			if()
		}
		return sumAviones;
	}

	public boolean hayVuelosReciprocos() {
		// devuelve un boolean indicando si existen dos ciudades entre las que hay
		// vuelos en los dos sentidos.
		return false;
	}

	@Override
	public String toString() {
		String res = "";
		for (Localidad l : this.conexiones.keySet()) {
			res += "\nDesde: " + l.getNombre() + " hasta:\n";
			for (Vuelo v : this.conexiones.get(l))
				res += v.getDestino().getNombre() + " con " + v.getLinea() + ", ";
		}

		return res;
	}

}
