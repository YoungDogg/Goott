package overridingEx;

public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public String getLocation() {
		return  "x : " + this.x + " y : " + this.y;
	}
}
