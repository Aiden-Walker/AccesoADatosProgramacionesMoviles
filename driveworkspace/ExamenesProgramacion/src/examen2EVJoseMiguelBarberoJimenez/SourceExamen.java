package examen2EVJoseMiguelBarberoJimenez;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

public class SourceExamen {
	private TreeSet<Entity> listaEntidades;
	private HashMap<Entity, LinkedList<Entity>> combates;

	public SourceExamen(TreeSet<Entity> listaEntidades, HashMap<Entity, LinkedList<Entity>> combates) {
		super();
		this.listaEntidades = listaEntidades;
		this.combates = combates;
	}

	public static void main(String[] args) {
	}

	public Entity getEntity(String entityName) {
		return null;
	}

	public boolean saveEntity(Entity entityToSave) {
		return false;
	}

	public boolean saveCombat(String winner, String loser) {
		return false;
	}

	public boolean deleteEnt(String entityName) {
		return false;
	}

	public boolean deleteCombat(String winner, String loser) {
		return false;
	}

	public Entity mostPowerful() {
		return null;
	}

	@Override
	public String toString() {
		return "";
	}
}
}
