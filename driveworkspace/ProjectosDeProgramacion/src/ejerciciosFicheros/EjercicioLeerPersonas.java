package ejerciciosFicheros;

import java.io.*;
import java.util.*;

public class EjercicioLeerPersonas {

	public static void main(String[] args) {
		File people = new File("personas.txt");
		HashSet<Persona> thirtyDollarLecture = leePersona(people);
		System.out.println(thirtyDollarLecture);
	}

	public static HashSet<Persona> leePersona(File f) {
		HashSet<Persona> peopleToReturn = new HashSet<Persona>();
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String currPerson = br.readLine();
			while (currPerson != null) {
				String[] perData = currPerson.split(" ");
				String name = perData[0];
				Integer age = Integer.parseInt(perData[1]);
				Float height = Float.parseFloat(perData[2]);
				Persona person = new Persona(name, age, height);
				peopleToReturn.add(person);
				currPerson = br.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("The file you are attempting to read does not exist");
		} catch (IOException e1) {
			System.out.println("Something went wrong when attempting to read or write, please try again");
		}
		return peopleToReturn;
	}
}
