package exceptionExcercises;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Excercise2 {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Excercise2.askInt();
		sc.close();
	}
	public static void askInt() {
		Integer testerInt;
		try {
			System.out.println("Introduce a number (try to break the program)");
			testerInt = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("You tried inputting something that is not an integer");
		}
	}
}
