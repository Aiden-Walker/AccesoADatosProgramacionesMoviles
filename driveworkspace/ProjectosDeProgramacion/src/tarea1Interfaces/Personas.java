package tarea1Interfaces;

import funcionesImportantes.FuncionesBasicas;

public class Personas implements Estadisticas<Persona> {
	private int nElem;
	private Persona[] people = new Persona[nElem];

	public Personas(int nElem, Persona[] peopleToAdd) {
		super();
		this.people = peopleToAdd;
		for (int i = 0; i < peopleToAdd.length; i++) {
			if (peopleToAdd[i] != null) {
				nElem++;
			}
		}
	}

	@Override
	public Persona mayor() {
		Persona bigShot = people[0];
		for (int i = 0; i < nElem; i++) {
			if (people[i].compareTo(bigShot) > 0) {
				bigShot = people[i];
			}
		}
		return bigShot;
	}

	@Override
	public Persona menor() {
		Persona smallShot = people[0];
		for (int i = 0; i < nElem; i++) {
			if (people[i].compareTo(smallShot) < 0) {
				smallShot = people[i];
			}
		}
		return smallShot;
	}

	@Override
	public double media() {
		int totalAge = 0;
		for (int i = 0; i < nElem; i++) {
			totalAge += people[i].getEdad();
		}
		return FuncionesBasicas.calculoDeMedia(totalAge, nElem);
	}

	@Override
	public Persona[] mayoresQue(Persona obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona[] menoresQue(Persona obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
