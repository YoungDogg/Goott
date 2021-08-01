package poly2;

public class Circle extends Shape {

	private int radius;
	public Circle(String name, String color, int countPoint, int radius) {
		super(name, color, countPoint);
		// TODO Auto-generated constructor stub
		this.radius = radius;
	}

	public int getRadius() {
		return this.radius;
	}
//	@Override
//	public void draw() {
//		// TODO Auto-generated method stub
//		System.out.println(this.outputPoints() +
//				this.getName() + this.getColor()
//				);
//	}

}
