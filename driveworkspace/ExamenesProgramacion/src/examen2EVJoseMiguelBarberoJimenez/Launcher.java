package examen2EVJoseMiguelBarberoJimenez;

import java.util.*;

public class Launcher {
	private UltraGestion dataModel;

	public static void main(String[] args) {
		TreeSet<Entity> theTreeOfLife = new TreeSet<>();
		HashMap<Entity, LinkedList<Entity>> thewarOfHell = new HashMap<>();
		UltraGestion dataSkibidi = new UltraGestion(theTreeOfLife, thewarOfHell);
		Machine V1 = new Machine(100, 100, "V1",
				"The ULTIMATE killing machine, designed with one, sole purpose, desrroying everything in it's way",
				"The only weakness of V1 is running out of victims to fuel itself from", Class.Supreme,
				Operative_System.Nocturnal);
		Demon maurice = new Demon(20, 5, "Malicious Face", "Made from demonic energy, a rock as hard as diamonds",
				"Maurice is vulnerable to blunt damage", Class.Lesser, 10);
		Demon kojima = new Demon(40, 20, "Hideous Mass",
				"Made from concentrated hell mass, hides in the ground awaiting to strike",
				"You can parry the hook and will get enraged when reciving a lot of damage", Class.Greater, 30);
		Machine swordsMachine = new Machine(45, 10, "SwordsMachine",
				"No one knows if this is the actual thing, or just a poser",
				"Swordsmachine has a very short attack range, maintain a distance", Class.Greater,
				Operative_System.Smile_OS_2);
		Machine streetCleaner = new Machine(10, 30, "Streetcleaner",
				"A machine made to deal with the pollution caused from the great war, now in search of blood to survive",
				"The streetcleaners have a napalm tank which explodes upon being shot", Class.Lesser,
				Operative_System.Smile_OS_1);
		Demon timmy = new Demon(1, 1, "Timmy", "His purpose is to be obliterated", "Bro's entire purpose is to DIE",
				Class.Lesser, 1);
		try {
			dataSkibidi.saveEntity(V1);
			dataSkibidi.saveEntity(maurice);
			dataSkibidi.saveEntity(kojima);
			dataSkibidi.saveEntity(swordsMachine);
			dataSkibidi.saveEntity(streetCleaner);
			dataSkibidi.saveEntity(timmy);
			dataSkibidi.saveCombat("V1", "Streetcleaner");
			dataSkibidi.saveCombat("V1", "SwordsMachine");
			dataSkibidi.saveCombat("Hideous Mass", "Malicious Face");
			dataSkibidi.saveCombat("Timmy", "Malicious Face");
			dataSkibidi.saveCombat("Streetcleaner", "SwordsMachine");
			dataSkibidi.saveCombat("Malicious Face", "Streetcleaner");
			dataSkibidi.saveCombat("SwordsMachine", "Streetcleaner");
			System.out.println("Imma try to get V1, " + dataSkibidi.getEntity("V1").toString());
			dataSkibidi.deleteCombat("Timmy", "Malicious Face");
			System.out.println(dataSkibidi.toString());
			dataSkibidi.deleteEnt("Timmy");
			System.out.println("Now, the grand winner is: " + dataSkibidi.mostPowerful().toString());
			;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Launcher(UltraGestion dataModel) {
		super();
		this.dataModel = dataModel;
	}

}
