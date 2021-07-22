package poly2;

import inheritance.Point;

public abstract class Shape {
	private String name;
	private String color;
	private int countPoint;
	private Point[] points;

	public Shape(String name, String color, int countPoint, Point[] points) {
		super();
		this.name = name;
		this.color = color;
		this.countPoint = countPoint;
		this.points = points;
	}

	public Shape(String name, String color, int countPoint) {
		super();
		this.name = name;
		this.color = color;
		this.countPoint = countPoint;
		this.points = new Point[countPoint];
	}

	public void addPoint(Point p, int position) {
		if(position < this.points.length && position >= 0)
			this.points[position] = p;
		else System.out.println("점의 개수 범위에 초과");
	}

	// getter 역할을 하는 멤버 변수 points 배열의 모든원소 출력
	public String outputPoints() {
		String pointst = "";
		for (Point point : points) {
			
			pointst += point.toString() + " "; 
		}
		return pointst;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCountPoint() {
		return countPoint;
	}

	public void setCountPoint(int countPoint) {
		this.countPoint = countPoint;
	}

	public Point getPoints(int index) {
		Point returnVal = null;
		if(index >= 0 && index < this.points.length) {
			returnVal =  this.points[index];			
		}
		return returnVal;
	}

	public void setPoints(Point[] points) {
		this.points = points;
	}

//	public abstract void draw();

}
