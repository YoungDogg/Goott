package poly;

public class Doctor {

	private String name;

	public Doctor(String name) {
		super();
		this.name = name;
	}

//	public void cure2Cow(Cow c) {
//		System.out.println(this.name + " cures " + c.getSpecies());
//	}
	
	public void cure2Cow(Animal a) {
		System.out.println(this.name + " cures " + a.getSpecies());
	}

	
	@Override
	public String toString() {
		return "Doctor [name=" + name + "]";
	}	
}
