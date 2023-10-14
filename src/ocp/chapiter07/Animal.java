package ocp.chapiter07;

public class Animal {
	private int age;
	protected String name;

	public Animal(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public Animal(int age) {
		super();
		this.age = age;
		this.name = null;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

class Gorilla extends Animal {
	int ageG;
	
	public Gorilla(int age) {
		super(age, "Gorilla");
	}

	public Gorilla() {
		super(5);
	}
}