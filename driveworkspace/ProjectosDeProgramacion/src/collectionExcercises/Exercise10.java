package collectionExcercises;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Exercise10 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		TreeSet<String> set1 = Exercise10.createSet();
		TreeSet<String> set2 = Exercise10.createSet();
		TreeSet<String> mySkibidiSigma = (TreeSet<String>) Exercise10.interseccion(set1, set2);
		System.out.println(mySkibidiSigma);
	}

	public static Set interseccion(Set conjunto1, Set conjunto2) {
		TreeSet<String> intersected = new TreeSet<>(conjunto1);
		intersected.retainAll(conjunto2);
		return intersected;
	}

	public static TreeSet<String> createSet() {
		TreeSet<String> theOG = new TreeSet<>();
		System.out.println("Write a name: ");
		String aName = sc.nextLine();
		while (!aName.equals("fin")) {
			theOG.add(aName);
			System.out.println("Put out another name: ");
			aName = sc.nextLine();
		}
		return theOG;
	}
}