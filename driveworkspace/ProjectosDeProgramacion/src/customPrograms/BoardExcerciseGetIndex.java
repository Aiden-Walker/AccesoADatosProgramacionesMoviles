package customPrograms;

public class BoardExcerciseGetIndex {

	public static void main(String[] args) {
		int valueISeek = 3;
		int[] table = { 1, 2, 3, 4 };
		System.out.println(getIndexOf(valueISeek, table));
	}

	public static int getIndexOf(int searchNumber, int[] tableToSearch) {
		int indexFound = -1;
		for (int counter = 0; counter < tableToSearch.length; counter++) {
			if (tableToSearch[counter] == searchNumber) {
				indexFound = counter;
			}
		}
		return indexFound;
	}
}