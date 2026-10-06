package collectionExcercises;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Exercise11 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		TreeSet<String> set1 = Exercise11.createSet();
		TreeSet<String> set2 = Exercise11.createSet();
		TreeSet<String> mySkibidiSigma = (TreeSet<String>) Exercise11.difference(set1, set2);
		System.out.println(mySkibidiSigma);
	}

	public static Set difference(Set conjunto1, Set conjunto2) {
		TreeSet<String> different = new TreeSet<>(conjunto1);
		different.removeAll(conjunto2);
		return different;
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