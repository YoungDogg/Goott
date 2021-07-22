package inheritance;

import java.util.Arrays;

public class Triangle {
	private Point[] p = new Point[3];
	
	public Triangle(Point[] p) {
		// TODO Auto-generated constructor stub
		this.p = p;
	}
	
	public Triangle(Point p1, Point p2, Point p3) {
		// TODO Auto-generated constructor stub
		this.p[0] = p1;
		this.p[1] = p2;
		this.p[2] = p3;
	}

	public Point[] getP() {
		return this.p;
	}
	
	@Override
	public String toString() {
		return "Triangle [p=" + Arrays.toString(p) + "]";
	}
	

}
