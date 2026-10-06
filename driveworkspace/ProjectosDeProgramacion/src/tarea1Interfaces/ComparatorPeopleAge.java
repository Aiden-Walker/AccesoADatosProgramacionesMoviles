package tarea1Interfaces;

import java.util.Comparator;

public class ComparatorPeopleAge implements Comparator<Cliente> {
	@Override
	public int compare(Cliente c1, Cliente c2) {
		return c1.getEdad() - c2.getEdad();
	}
}
