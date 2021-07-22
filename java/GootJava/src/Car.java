
public class Car {	
	// member var
	String model = "Granduer";
	String color = "black";
	int door = 4;
	String horsePower = "2500cc";
	
	// member method
	public void forward() {
		System.out.println(this.model + " go ahead");
	}
	public void stop() {
		System.out.println(this.model + " stop");
	}
	public void introduceCar() {
		System.out.println("model : " + this.model + ", color : " + this.color);
	}
}