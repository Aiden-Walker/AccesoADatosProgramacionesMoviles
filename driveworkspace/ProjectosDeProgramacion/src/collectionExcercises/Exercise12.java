package collectionExcercises;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise12 {

	public static void main(String[] args) {
		ArrayList<Integer> lista1 = new ArrayList<Integer>();
		lista1.add(5);
		lista1.add(8);
		lista1.add(4);
		Collections.sort(lista1);
		ArrayList<Integer> lista2 = new ArrayList<Integer>();
		lista2.add(9);
		lista2.add(7);
		lista2.add(1);
		Collections.sort(lista2);
		ArrayList<Integer> theOnePiece = Exercise12.fusionador(lista1, lista2);
		System.out.println(theOnePiece);
	}

	public static ArrayList<Integer> fusionador(ArrayList<Integer> l1, ArrayList<Integer> l2) {
		ArrayList<Integer> ouroboros = new ArrayList<>();
		int i = 0;
		int j = 0;
		for (int z = 0; z < (l1.size() + l2.size()); z++) {
			if (i < l1.size() && j < l2.size()) {
				if (l1.get(i) <= l2.get(j)) {
					ouroboros.add(l1.get(i));
					i++;
				} else {
					ouroboros.add(l2.get(j));
					j++;
				}
			} else if (i < l1.size()) {
				ouroboros.add(l1.get(i));
				i++;
			} else {
				ouroboros.add(l2.get(j));
				j++;
			}
		}
		return ouroboros;
	}
}