package collectionExcercises;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercise9 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HashSet<String> set1 = Exercise9.createSet();
		HashSet<String> set2 = Exercise9.createSet();
		HashSet<String> mySkibidiSigma = (HashSet<String>) Exercise9.union(set1, set2);
		System.out.println(mySkibidiSigma);
	}

	public static Set union(Set conjunto1, Set conjunto2) {
		HashSet<String> unionized = new HashSet<>();
		unionized.addAll(conjunto1);
		unionized.addAll(conjunto2);
		return unionized;
	}

	public static HashSet<String> createSet() {
		HashSet<String> theOG = new HashSet<>();
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
