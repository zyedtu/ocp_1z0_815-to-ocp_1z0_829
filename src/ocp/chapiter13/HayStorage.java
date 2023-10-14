package ocp.chapiter13;

public class HayStorage {
	
	private int quantity = 0;
	private HayStorage() {}

	private static final HayStorage instance = new HayStorage();

	public static HayStorage getInstance() {
		return instance;
	}

	public void addHay(int amount) {
		quantity += amount;
	}

	public int getHayQuantity() {
		return quantity;
	}
}
