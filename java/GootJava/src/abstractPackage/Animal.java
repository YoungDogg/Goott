package abstractPackage;

public abstract class Animal {

	private String type; // type of animal

	public Animal(String type) {
		super();
		this.type = type;
	}
	
	public abstract void cry();	
}
