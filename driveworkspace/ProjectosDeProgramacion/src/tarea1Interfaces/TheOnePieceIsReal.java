package tarea1Interfaces;

import java.util.Arrays;

public class TheOnePieceIsReal {

	public static void main(String[] args) {
		Cliente[] oldSport = new Cliente[5];
		oldSport[0] = new Cliente("1111A", "Juan", 27, 50000);
		oldSport[1] = new Cliente("2222B", "Paco", 30, 1280);
		oldSport[2] = new Cliente("5555E", "Raul", 19, 1080);
		oldSport[3] = new Cliente("3333C", "Esteban", 45, 2100);
		oldSport[4] = new Cliente("4444D", "Skibidi", 32, 1945);
		System.out.println(Arrays.toString(oldSport));
		Arrays.sort(oldSport);
		System.out.println(Arrays.toString(oldSport));
		Arrays.sort(oldSport, new ComparatorPeopleName());
		System.out.println(Arrays.toString(oldSport));
		Arrays.sort(oldSport, new ComparatorPeopleAge());
		System.out.println(Arrays.toString(oldSport));

		Mascota[] pets = new Mascota[4];
		pets[0] = new Perro("Maxiliam I", 5, Origen.Asociacion, true);
		pets[1] = new Perro("Firulais", 10, Origen.Calle, true);
		pets[2] = new Gato("Herbert", 17, Origen.Tienda, 6);
		pets[3] = new Gato("Mr. Mittens", 6, Origen.Otro_Dueno, 9);
		System.out.println(Arrays.toString(pets));
		Arrays.sort(pets);
		System.out.println(Arrays.toString(pets));
		Arrays.sort(pets, new MascotDescendingComparator());
		System.out.println(Arrays.toString(pets));
	}
}
