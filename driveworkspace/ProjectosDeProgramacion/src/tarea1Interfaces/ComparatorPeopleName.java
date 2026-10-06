package tarea1Interfaces;

import java.util.Comparator;

public class ComparatorPeopleName implements Comparator<Cliente> {

	@Override
	public int compare(Cliente c1, Cliente c2) {
		return c1.getNombre().compareTo(c2.getNombre());
	}

}
