package collectionExcercises;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Ejercicio6 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Introduce a name: ");
		String sayMyName = sc.nextLine();
		LinkedHashSet<String> theFunSet = new LinkedHashSet<String>();
		while(!sayMyName.equals("fin")) {
			theFunSet.add(sayMyName);
			System.out.println("Introduce another name would ya: ");
			sayMyName = sc.nextLine();
		}
		System.out.println(theFunSet);
	}

}
