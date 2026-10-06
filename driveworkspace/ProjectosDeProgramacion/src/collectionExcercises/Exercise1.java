package collectionExcercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Exercise1 {
	public static void main(String[] args) {
		ArrayList<Integer> twentyNumbers = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			twentyNumbers.add((int) (Math.random() * 100));
		}
		for (int example : twentyNumbers) {
			System.out.println(example);
		}
		Collections.sort(twentyNumbers);
		System.out.println("Bottom text 1");
		Iterator<Integer> iteratingmyClown = twentyNumbers.iterator();
		while (iteratingmyClown.hasNext()) {
			System.out.println(iteratingmyClown.next());
		}
		System.out.println("Exercise 2");
		Collections.sort(twentyNumbers, Collections.reverseOrder());
		for(int printThi : twentyNumbers) {
			System.out.println(printThi);
		}
	}

}
