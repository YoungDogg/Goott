package inheritance;

import java.awt.Graphics;

import javax.swing.JFrame;

public class DrawShapeEx1 extends JFrame {

	public DrawShapeEx1(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		super.setSize(1000, 1000);
		super.setVisible(true);
	}

	public static void main(String[] args) {
		DrawShapeEx1 drawShapeEx1 = new DrawShapeEx1("도형그리기");

	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		Point[] p = {
				new Point(100, 100),
				new Point(140, 150),
				new Point(200, 100)
		};

		Triangle t = new Triangle(p);
		
		g.drawLine(t.getP()[0].getX(), t.getP()[0].getY(), 
				t.getP()[1].getX(), t.getP()[1].getY());
		
		g.drawLine(t.getP()[1].getX(), t.getP()[1].getY(),
				t.getP()[2].getX(), t.getP()[2].getY());
		
		g.drawLine(t.getP()[2].getX(), t.getP()[2].getY(),
				t.getP()[0].getX(), t.getP()[0].getY());
		
		Point[] p2 = {
				new Point(300, 400),
				new Point(600, 400),
				new Point(300, 800),
				new Point(600, 800)
		};
		
		Square s = new Square(p2);
		g.drawLine(s.getP()[0].getX(), s.getP()[0].getY(), 
				s.getP()[1].getX(), s.getP()[1].getY());
		
		g.drawLine(s.getP()[1].getX(), s.getP()[1].getY(), 
				s.getP()[3].getX(), s.getP()[3].getY());
		
		g.drawLine(s.getP()[2].getX(), s.getP()[2].getY(), 
				s.getP()[3].getX(), s.getP()[3].getY());
		
		g.drawLine(s.getP()[2].getX(), s.getP()[2].getY(), 
				s.getP()[0].getX(), s.getP()[0].getY());
		
		Point p3 = new Point(100, 400);
		Circle c = new Circle(p3, 100);
		
		g.drawOval(c.getPoint().getX(), c.getPoint().getY(), 
				c.getRadius() * 2, c.getRadius() * 2);
	}

}
