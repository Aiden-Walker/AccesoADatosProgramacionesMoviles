package exceptionExcercises;

public class Examples {

	public static void main(String[] args) {
		Integer[] helloChat = new Integer[5];
		Integer searchThis = 5;
		try {
			Examples.goofyAhhArrayFillMeTooLazy(helloChat);
			System.out.println(Examples.exceptionExamples(helloChat, searchThis));
		} catch (IndexOutOfBoundsException e) {
			System.out.println("The index you're trying to search is out of bounds");
		} catch (NullPointerException e) {
			System.out.println("The index you're attempting to searrch is null");
		}
	}

	static public int exceptionExamples(Integer[] arrayAUsar, Integer enteroABuscar) {
		int pos = 0;
		for (int i = 0; i <= arrayAUsar.length; i++) {
			if (arrayAUsar[i].equals(enteroABuscar)) {
				pos = i;
			}
		}
		return pos;
	}

	static public void goofyAhhArrayFillMeTooLazy(Integer[] arrayToFill) {
		Integer heavyTF2 = 1;
		// I finally have the Lugermorph after 9 years, yay!!!
		for (int i = 1; i < arrayToFill.length; i++) {
			arrayToFill[i] = heavyTF2;
			heavyTF2++;
		}
	}
}
