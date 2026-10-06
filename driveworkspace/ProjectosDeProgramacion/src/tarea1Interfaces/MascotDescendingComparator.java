package tarea1Interfaces;

import java.util.Comparator;

public class MascotDescendingComparator implements Comparator<Mascota> {

	@Override
	public int compare(Mascota m1, Mascota m2) {
		return m2.getEdad() - m1.getEdad();
	}

}
