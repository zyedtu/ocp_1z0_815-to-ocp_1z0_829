package ocp.chapiter05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DuckWithComparator {

	private String name;
	private int weight;
	
	public DuckWithComparator(String name, int weight) {
		this.name = name; 
		this.weight = weight;
	}
	
	public String getName() { return name;}
	public void setName(String name) {this.name = name; }
	public int getWeight() { return weight; }
	public void setWeight(int weight) { this.weight = weight; }
	
	@Override
	public String toString() {
		return "[name=" + name + ", weight=" + weight + "]";
	}

	public static void main(String[] args) {
		List<DuckWithComparator> ducks = new ArrayList<>();
		ducks.add(new DuckWithComparator("Quack", 7));
		ducks.add(new DuckWithComparator("Puddles", 10));
		Collections.sort(ducks, (d1, d2) -> d1.getName().compareTo(d2.getName()));
		System.out.println("Tri avec nom: " + ducks);
		Collections.sort(ducks, (d1, d2) -> d1.getWeight() - 
				d2.getWeight());
		System.out.println("Tri avec poid: " + ducks);
	}
}
