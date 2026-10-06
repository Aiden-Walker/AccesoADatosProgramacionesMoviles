package exceptionExcercises;

import java.util.Scanner;

public class Excercise3 {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws NoVocalException {
		System.out.println("Introduce a letter");
		String letra = sc.next();
		switch (letra) {
		case "a","e","i","o","u": {
			System.out.println("A bowel was introduced");
			break;
		}
		default:
			throw new NoVocalException("A bowel was not introduced");
		}
	}

}
