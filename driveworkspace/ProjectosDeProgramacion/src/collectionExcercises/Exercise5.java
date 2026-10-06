package collectionExcercises;

import java.util.Collections;
import java.util.TreeSet;

public class Exercise5 {

	public static void main(String[] args) {
		TreeSet<Integer> onePiece = new TreeSet<>(Collections.reverseOrder());
		while (onePiece.size() < 20) {
			int numToInsert = (int) (Math.random() * 100);
			onePiece.add(numToInsert);
		}
		for (int goofyAhh : onePiece) {
			System.out.println(goofyAhh);
		}
	}

}
