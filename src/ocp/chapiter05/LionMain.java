package ocp.chapiter05;

class Lion {
	private int idNumber;
	private int age;
	private String name;

	public Lion(int idNumber, int age, String name) {
		this.idNumber = idNumber;
		this.age = age;
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if(o == this)
			return true;
		if(!(o instanceof Lion))
			return false;
		Lion lion = (Lion) o;
		return lion.idNumber == this.idNumber 
				&& lion.age == this.age 
				&& lion.name.equals(this.name);
	}
}

public class LionMain {

	public static void main(String[] args) {
		Lion lion1 = new Lion(1, 12, "Lion_1");
		Lion lion2 = new Lion(2, 8, "Lion_2");
		Lion lion3 = new Lion(1, 12, "Lion_1");
		System.out.println(lion1.equals(lion2));
		System.out.println(lion1.equals(lion3));
	}
}
