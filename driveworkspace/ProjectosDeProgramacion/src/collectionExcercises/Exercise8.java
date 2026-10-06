package collectionExcercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class Exercise8 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<String> theOG = new ArrayList<>();
		System.out.println("Write a name: ");
		String aName = sc.nextLine();
		while(!aName.equals("fin")) {
			theOG.add(aName);
			System.out.println("Put out another name: ");
			aName = sc.nextLine();
		}
		ArrayList<String> theNEW = (ArrayList<String>) Exercise8.eliminaRepetidos(theOG);
		System.out.println(theNEW);
	}
	
	public static List eliminaRepetidos (List c) {
		List iAlwaysComeBack = new ArrayList<>();
		LinkedHashSet<String> quickFix = new LinkedHashSet<>();
		quickFix.addAll(c);
		iAlwaysComeBack.addAll(quickFix);
		return iAlwaysComeBack;
	}

}
