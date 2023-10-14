package ocp.chapiter13;

import java.util.List;

public class AnimalBuilder {
	
	private String species;
	private int age;
	private List<String> favoriteFoods;
	
	public String getSpecies() { return species; }
	public void setSpecies(String species) { this.species = species; }
	
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	
	public List<String> getFavoriteFoods() { return favoriteFoods; }
	public void setFavoriteFoods(List<String> favoriteFoods) { this.favoriteFoods = favoriteFoods; }
	
	@Override
	public String toString() {
		return "AnimalBuilder [species=" + species + ", age=" + age + ", favoriteFoods=" + favoriteFoods +  "]";
	}

	static class Builder {
		private String species;
		private int age;
		private List<String> favoriteFoods;
		
		Builder withSpecies(String species) {
			this.species = species;
			return this;
		}
		
		Builder withAge(int age) {
			this.age = age;
			return this;
		}
		
		Builder withFavoriteFoods(List<String> favorite){
			this.favoriteFoods = favorite;
			return this;
		}
		
		AnimalBuilder build() {
			AnimalBuilder ab = new AnimalBuilder();
			ab.setAge(this.age);
			ab.setSpecies(this.species);
			ab.setFavoriteFoods(this.favoriteFoods);
			return ab;
		}
	}
}
