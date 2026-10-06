package collectionExcercises;

import java.util.Scanner;
import java.util.TreeSet;

public class Ejercicio7 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		TreeSet<String> daTreeSet = new TreeSet<>();
		System.out.println("Write down a name: ");
		String theName = sc.nextLine();
		while(!theName.equals("fin")) {
			daTreeSet.add(theName);
			System.out.println("Write another name: ");
			theName = sc.nextLine();
		}
		System.out.println(daTreeSet);
	}

}
