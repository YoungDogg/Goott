
public class Phone {

	String model;
	String storage;
	String color;
	String telCom;
	int price;
	
	public Phone(String string) {
		this.color = string;
	}

	public Phone() {
		
	}
	public Phone(String model, String telCom, int price) {
		this.model = model;
		this.telCom = telCom;
		this.price = price;
	}
	public Phone(String model, int price) {
		this(model, null, price);
	}
	

	public void calling() {
		System.out.println("ring");
	}
	public void receiving() {
		System.out.println("calling from");
	}
}
