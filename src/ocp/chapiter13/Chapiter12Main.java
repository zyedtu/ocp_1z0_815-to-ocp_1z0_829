package ocp.chapiter13;

import java.util.Arrays;
import java.util.List;

public class Chapiter12Main {

	public static void main(String[] args) {

		Animal animal = new Animal(List.of("favoriteFoods1", "favoriteFoods2"));
		animal.getFavoriteFoods().stream().forEach(System.out::println);
		animal.getFavoriteFoods().clear();
		animal.getFavoriteFoods().stream().forEach(System.out::println); // on a pu modifier la classe
		// ------------------------------------------------------------------------------------------------
		HayStorage instance1 = HayStorage.getInstance();
		instance1.addHay(2);
		HayStorage instance2 = HayStorage.getInstance();
		System.out.println(instance2.getHayQuantity());
		System.out.println(instance1 == instance2);
		// ------------------------------------------------------------------------------------------------
		AnimalBuilder build = new AnimalBuilder.Builder().withAge(5).withSpecies("spa")
				.withFavoriteFoods(Arrays.asList("Favo1", "Favo2")).build();
		System.out.println(build);
		// ------------------------------------------------------------------------------------------------
		Food food = FoodFactory.getFood("polar bear");
		food.consumed();

	}

}
