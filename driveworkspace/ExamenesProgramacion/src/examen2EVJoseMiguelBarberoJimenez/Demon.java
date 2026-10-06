package examen2EVJoseMiguelBarberoJimenez;

public class Demon extends Entity {
	int demon_energy;

	public Demon(int hp, int atk, String name, String description, String weaknesses, Class clase, int demon_energy) {
		super(hp, atk, name, description, weaknesses, clase);
		this.demon_energy = demon_energy;
	}

	@Override
	public int compareTo(Entity o) {
		this.calcPoints(); // Esto se hace por si acaso los puntos no estan calculados
		return this.points - o.points;
	}

	@Override
	public void calcPoints() {
		int finalPoints = 0;
		finalPoints += this.hp + this.atk;
		finalPoints += demon_energy;
		switch (this.clase) {
		case Greater: {
			finalPoints *= 1.5;
		}
		case Supreme: {
			finalPoints *= 2;
		}
		default:
			System.out.println("No multiplier added");
		}
		finalPoints += 5;
		this.points = finalPoints;
	}
}
