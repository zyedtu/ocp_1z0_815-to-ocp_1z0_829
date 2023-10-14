package ocp.chapiter05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Duck implements Comparable<Duck> {

	private String name;
	private int weight;
	
	public Duck(String name) { this.name = name; }
	
	public String getName() { return name;}
	public void setName(String name) {this.name = name; }
	public int getWeight() { return weight; }
	public void setWeight(int weight) { this.weight = weight; }

	@Override
	public int compareTo(Duck o) {
		return name.compareTo(o.getName());
	}
	@Override
	public String toString() {
		return "Duck [name=" + name + "]";
	}
	
	public static void main(String[] args) {
		List<Duck> ducks = new ArrayList<>();
		ducks.add(new Duck("Quack "));
		ducks.add(new Duck("Puddles"));
		System.out.println("Before tri: " + ducks); // [Quack ,Puddles ]
		Collections.sort(ducks); // sort by name
		System.out.println("After tri: " + ducks); // [Puddles, Quack]
	} 
}
