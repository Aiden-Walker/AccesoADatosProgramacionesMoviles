package examen2EVJoseMiguelBarberoJimenez;

import java.util.*;
import java.util.Map.Entry;

public class UltraGestion {
	private TreeSet<Entity> listaEntidades;
	private HashMap<Entity, LinkedList<Entity>> combates;

	public UltraGestion(TreeSet<Entity> listaEntidades, HashMap<Entity, LinkedList<Entity>> combates) {
		super();
		this.listaEntidades = listaEntidades;
		this.combates = combates;
	}

	public static void main(String[] args) {
	}

	public Entity getEntity(String entityName) {
		Entity entityToReturn = null;
		for (Entity ent : this.listaEntidades) {
			if (ent.getName().equals(entityName)) {
				entityToReturn = ent;
			}
		}
		return entityToReturn;
	}

	public boolean saveEntity(Entity entityToSave) {
		boolean isInserted = false;
		if (this.listaEntidades.add(entityToSave)) {
			isInserted = true;
		}
		return isInserted;
	}

	public boolean saveCombat(String winner, String loser) {
		Entity winningEnt = this.getEntity(winner);
		Entity losingEnt = this.getEntity(loser);
		boolean isSaved = false;
		if (!this.combates.containsKey(winningEnt)) {
			this.combates.put(winningEnt, new LinkedList<Entity>());
		}
		if (this.combates.get(winningEnt).add(losingEnt)) {
			isSaved = true;
		}

		return isSaved;
	}

	public boolean deleteEnt(String entityName) {
		boolean isDeleted = false;
		/*
		 * Iterator<Entity> it = listaEntidades.iterator(); Entity keyABorrar = null;
		 * while (it.hasNext()) { if (it.next().getName().equals(entityName)) {
		 * it.remove(); for (Entity p : this.combates.keySet()) { keyABorrar = p; }
		 * isDeleted = true; } this.combates.remove(keyABorrar); }
		 */
		Entity entToDelete = this.getEntity(entityName);
		this.combates.remove(entToDelete);
		if (this.listaEntidades.remove(entToDelete)) {
			isDeleted = true;
		}
		return isDeleted;
	}

	public boolean deleteCombat(String winner, String loser) {
		Entity winningEnt = this.getEntity(winner);
		Entity losingEnt = this.getEntity(loser);
		return combates.get(winningEnt).remove(losingEnt);
	}

	public Entity mostPowerful() {
		Entity supremeEntity = null;
		for (Entity currEntity : this.listaEntidades) {
			currEntity.calcPoints();
			int pointsFromCombat = 0;
			pointsFromCombat = this.combates.get(currEntity).size();
			currEntity.addPoints(pointsFromCombat);
			if (supremeEntity == null) {
				supremeEntity = currEntity;
			} else if (currEntity.compareTo(supremeEntity) > 0) {
				supremeEntity = currEntity;
			}
		}
		return supremeEntity;
	}

	@Override
	public String toString() {
		return "UltraGestion [listaEntidades=" + listaEntidades + ", combates=" + combates + "]";
	}
}
