package customPrograms;

import java.util.Arrays;

public class BoardExcersiceMoveRight {

	public static void main(String[] args) {
		int skibidiSigma = 24;
		int[] mercyIsOffTheTable = { 10, 5, 20, 25 };
		int numElem = mercyIsOffTheTable.length;
		Arrays.sort(mercyIsOffTheTable);
		int pos = Arrays.binarySearch(mercyIsOffTheTable, 24);
		int posInsercion = 0;
		if (pos < 0) {
			posInsercion = -pos - 1;
		}
		int[] womboCombo = Arrays.copyOf(mercyIsOffTheTable, numElem + 1);
		for (int i = numElem; i > posInsercion; i--) {
			womboCombo[i] = womboCombo[i - 1];
		}
		womboCombo[posInsercion] = skibidiSigma;
		System.out.println(Arrays.toString(womboCombo));
	}

}
