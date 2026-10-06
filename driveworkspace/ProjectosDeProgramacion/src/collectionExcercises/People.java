package collectionExcercises;

import java.util.Objects;

public class People implements Comparable<People> {
	private String name;
	private int age;

	public People(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public People() {
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
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		People other = (People) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	@Override
	public int compareTo(People o) {
		int res = this.name.compareTo(o.name);
		if (res == 0) {
			res = Integer.compare(this.age, o.age);
		}
		return res;
	}

	@Override
	public String toString() {
		return "People [name=" + name + ", age=" + age + "]";
	}
}
