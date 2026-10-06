package collectionExcercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Ejercicio4 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Introduce una frase");
		String cheesyOneLiner = sc.nextLine();
		ArrayList<String> sevenMinutes = new ArrayList<>(Arrays.asList(cheesyOneLiner.split(" ")));
		System.out.println(sevenMinutes);
		HashSet<String> noRepeat = new HashSet<>();
		ArrayList<String> repeat = new ArrayList<>();
		for (int i = 0; i < sevenMinutes.size(); i++) {
			if (!noRepeat.add(sevenMinutes.get(i))) {
				if (!repeat.contains(sevenMinutes.get(i))) {
					repeat.add(sevenMinutes.get(i));
				}
			}
		}
		noRepeat.removeAll(repeat);
		System.out.println(repeat);
		System.out.println(noRepeat);
	}
}