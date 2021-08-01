package poly2;

import inheritance.Point;

public class polyEx2 {
	public static void main(String[] args) {
		Triangle triangle = new Triangle("tri", "yellow", 3);
		triangle.addPoint(new Point(0, 0), 0);
		triangle.addPoint(new Point(10, 10), 1);
		triangle.addPoint(new Point(20, 20), 2);
//		triangle.draw();
		
		Circle circle = new Circle("cir", "red", 1, 3);
		circle.addPoint(new Point(50, 50), 0);
//		circle.draw();
		System.out.println("===========================");
		
		Painter painter = new Painter();
		
		Shape triShape = new Triangle("tri", "yellow", 3);
		triShape.addPoint(new Point(0, 0), 0);
		triShape .addPoint(new Point(10, 10), 1);
		triShape .addPoint(new Point(20, 20), 2);
		
		Shape cirShape = new Circle("cir", "red", 1, 3);
		cirShape.addPoint(new Point(50, 50), 0);
		
		painter.draw(triShape);
		painter.draw(cirShape);
	}
}
