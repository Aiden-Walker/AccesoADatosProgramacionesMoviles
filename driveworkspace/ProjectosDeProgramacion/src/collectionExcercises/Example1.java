package collectionExcercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// People p1 = new People("Joe",23);
		People p2 = new People("Jane", 22);
		People p3 = new People("Paco", 54);
		People p4 = new People("Juan", 43);
		ArrayList<People> miGente = new ArrayList<People>();
		miGente.add(new People("Joe", 23));
		miGente.add(p2);
		miGente.add(p3);
		miGente.add(p4);
		for (int i = 0; i < miGente.size(); i++) {
			System.out.println(miGente.get(i));
		}
		System.out.println("Bottom text");
		for (People ex : miGente) {
			System.out.println(ex);
		}
		Iterator<People> slobidiIterator = miGente.iterator();
		System.out.println("Bottom text 2, electric boogalo");
		while (slobidiIterator.hasNext()) {
			People example = slobidiIterator.next();
			System.out.println(example);
		}
		System.out.println("Bottom text 3, nobody asked");
		HashSet<People> minecraftServer = new HashSet<People>();
		minecraftServer.add(new People("Joe Biden", 86));
		minecraftServer.add(p2);
		minecraftServer.add(p3);
		minecraftServer.add(p4);
		for (People example : minecraftServer) {
			System.out.println(example);
		}
		Iterator<People> iteratingmyHash = minecraftServer.iterator();
		System.out.println("Bottom text 4, I am running out of ideas");
		while (iteratingmyHash.hasNext()) {
			People example = iteratingmyHash.next();
			System.out.println(example);
		}
	}
}
