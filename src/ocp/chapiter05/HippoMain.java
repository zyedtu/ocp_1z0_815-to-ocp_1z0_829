package ocp.chapiter05;


class Hippo {
	private String name;
	private double weight;

	public Hippo(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", Weight: " + weight;
	}
}

public class HippoMain {
	
	public static void main(String[] args) {
		Hippo h1 = new Hippo("Harry", 3100);
		System.out.println(h1); // Harry
	}
}