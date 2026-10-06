package ejTipoExamenAnimales;

import java.util.*;

public class Reserva extends HashMap<Area, ListaAnimales> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean anyadeArea(String string, float f) {
		Area areaToPut = new Area(string, f);
		if (this.put(areaToPut, new ListaAnimales()) == null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean anyadeAnimal(String string, Area pradera, List listaPresas) {
		HashSet<Animal> presas = new HashSet<Animal>(listaPresas);
		if (this.get(pradera).add(new Animal(string, presas))) {
			return true;
		} else {
			return false;
		}
	}

	public Set<Area> getListaAreas() {
		Set<Area> areasToReturn = new HashSet<Area>();
		for (Area a : this.keySet()) {
			areasToReturn.add(a);
		}
		return areasToReturn;
	}

	public TreeSet<Animal> getListaAnimales() {
		TreeSet<Animal> animalsToReturn = new TreeSet<>();
		for (ListaAnimales la : this.values()) {
			animalsToReturn.addAll(la);
		}
		return animalsToReturn;
	}

	public String getListadoArea(Area area) {
		String animalsToReturn = "";
		for (Animal a : this.get(area)) {
			animalsToReturn += a.getNombre();
		}
		return animalsToReturn;
	}

	public Animal getAnimal(String nombre) {
		boolean enc = false;
		Animal animalToReturn = null;
		Iterator<ListaAnimales> iteratingAnimals = this.values().iterator();
		while (iteratingAnimals.hasNext() && !enc) {
			ListaAnimales currentList = iteratingAnimals.next();
			for (Animal a : currentList) {
				if (a.getNombre().equals(nombre)) {
					enc = true;
					animalToReturn = a;
				}
			}
		}
		return animalToReturn;
	}

	public void actualizaAnimal(Animal animalSeleccionado, List<Animal> presas) {
		for(Area a : this.keySet()) {
			
		}
	}

	public String getListadoTotal() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getListadoProblemas() {
		// TODO Auto-generated method stub
		return null;
	}

}