package inheritance;

public class Square {
	private Point[] p = new Point[4];

	public Point[] getP() {
		return p;
	}

	public Square(Point[] p) {
		super();
		this.p = p;
	}
	
	public Square(Point p1, Point p2, Point p3, Point p4) {
		this.p[0] = p1;
		this.p[1] = p2;
		this.p[2] = p3;
		this.p[3] = p4;
	}
}
