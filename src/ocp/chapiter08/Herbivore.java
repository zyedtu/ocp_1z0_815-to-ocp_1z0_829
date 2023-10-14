package ocp.chapiter08;

public interface Herbivore {
	public int eatPlants(int quantity);
	public void eatMeat();
}

interface Omnivore {
	public void eatPlants();
	public void eatMeat();
}

class Bear1 implements Herbivore, Omnivore {
	public int eatPlants(int quantity) {
		System.out.println("Eating plants: " + quantity);
		return quantity;
	}

	public void eatPlants() {
		System.out.println("Eating plants");
	}
	public void eatMeat() {}
}