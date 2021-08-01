package compreTo;


public class Point implements Comparable<Point>{
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "point [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int compareTo(Point p) {//비교하는거 
		int result = 0;
		
		if (this != null && p != null) {
			if (this.x > p.x) {
				result = 1;
			} else if (this.x < p.x) {
				result = -1;}
			}
		return result;
	}
	
	
}