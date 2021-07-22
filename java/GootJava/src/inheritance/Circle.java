package inheritance;

public class Circle {
	private Point point;
	private int radius;
	public Circle(Point point, int radius) {
		super();
		this.point = point;
		this.radius = radius;
	}
	
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [point=" + point + ", radius=" + radius + "]";
	}
	
	
	
}
