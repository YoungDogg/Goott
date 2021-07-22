

public class ClassEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car();
		System.out.println(car.model);
		car.forward();
		car.stop();
		car.introduceCar();
		
		Car car2 = new Car();
		car2.color = "white";
		System.out.println(car2.color);
	}

}
