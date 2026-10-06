package examen2EVJoseMiguelBarberoJimenez;

public abstract class Entity implements Comparable<Entity> {
	int hp;
	int atk;
	String name;
	String description;
	String weaknesses;
	Class clase;
	int points;

	public Entity(int hp, int atk, String name, String description, String weaknesses, Class clase) {
		super();
		this.hp = hp;
		this.atk = atk;
		this.name = name;
		this.description = description;
		this.weaknesses = weaknesses;
		this.clase = clase;
		this.points = points;
	}

	public boolean equals(Entity other) {
		return this.name.equals(other.name);
	}

	public void addPoints(int pointsToAdd) {
		this.points += pointsToAdd;
	}

	public abstract void calcPoints();

	/**
	 * @return the hp
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * @param hp the hp to set
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 * @return the atk
	 */
	public int getAtk() {
		return atk;
	}

	/**
	 * @param atk the atk to set
	 */
	public void setAtk(int atk) {
		this.atk = atk;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the weaknesses
	 */
	public String getWeaknesses() {
		return weaknesses;
	}

	/**
	 * @param weaknesses the weaknesses to set
	 */
	public void setWeaknesses(String weaknesses) {
		this.weaknesses = weaknesses;
	}

	/**
	 * @return the clase
	 */
	public Class getClase() {
		return clase;
	}

	/**
	 * @param clase the clase to set
	 */
	public void setClase(Class clase) {
		this.clase = clase;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Entity [hp=" + hp + ", atk=" + atk + ", name=" + name + ", clase=" + clase + ", points=" + points + "]";
	}
}
