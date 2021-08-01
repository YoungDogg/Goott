package poly2;

import inheritance.Point;

public class Triangle extends Shape{

	public Triangle(String name, String color, int countPoint, Point[] points) {
		super(name, color, countPoint, points);
		// TODO Auto-generated constructor stub
	}

	public Triangle(String name, String color, int countPoint) {
		// TODO Auto-generated constructor stub
		super(name, color, countPoint);
	}

//	@Override
//	public void draw() {
//		// TODO Auto-generated method stub
////		System.out.println("Triangle");
//		System.out.println(this.outputPoints() +
//				this.getName() + this.getColor()
//				);
//		
//	}

}
