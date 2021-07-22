package poly;

public abstract class Animal {
	private String species;

	
	
	public Animal(String species) {
		super();
		this.species = species;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public abstract String cry();
}
