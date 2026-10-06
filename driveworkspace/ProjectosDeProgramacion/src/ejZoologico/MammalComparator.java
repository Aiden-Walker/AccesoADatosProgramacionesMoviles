package ejZoologico;

import java.util.Comparator;

public class MammalComparator implements Comparator<Mamifero> {

	@Override
	public int compare(Mamifero o1, Mamifero o2) {
		int result = o1.getDiaNacimiento().compareTo(o2.getDiaNacimiento());
		if (result == 0) {
			result = o1.getNombre().compareTo(o2.getNombre());
		}
		return result;
	}

}
