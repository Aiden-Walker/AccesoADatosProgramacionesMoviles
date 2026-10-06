package examen2EVJoseMiguelBarberoJimenez;

public class Machine extends Entity {
	public Machine(int hp, int atk, String name, String description, String weaknesses, Class clase,
			Operative_System os) {
		super(hp, atk, name, description, weaknesses, clase);
		this.os = os;
	}

	Operative_System os;

	@Override
	public int compareTo(Entity o) {
		this.calcPoints();
		return this.points - o.points;
	}

	@Override
	public void calcPoints() {
		int finalPoints = 0;
		finalPoints += this.hp + this.atk;
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
		switch (this.os) {
		case Smile_OS_2: {
			finalPoints *= 1.5;
		}
		case Nocturnal: {
			finalPoints *= 2;
		}
		default:
			System.out.println("No multiplier added");
		}
		finalPoints += 15;
		this.points = finalPoints;
	}

}
