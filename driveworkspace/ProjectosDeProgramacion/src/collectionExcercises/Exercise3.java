package collectionExcercises;

import java.util.ArrayList;

public class Exercise3 {
	public static void main(String[] args) {
		ArrayList<Integer> onePiece = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			int numToInsert = (int) (Math.random() * 10);
			boolean inserted = false;
			for (int j = 0; j < onePiece.size() && !inserted; j++) {
				if (numToInsert > onePiece.get(j)) {
					onePiece.add(j, numToInsert);
					inserted = true;
				}
			}
			if(!inserted) {
				onePiece.add(numToInsert);
			}
		}
		for (int goofyAhh : onePiece) {
			System.out.println(goofyAhh);
		}
	}

}
