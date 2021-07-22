package inheritance;

public class HasATest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Point p = new Point(100, 200);
		System.out.println(p);
		
		Circle c = new Circle(p, 3);
		System.out.println(c.toString());
	}

}
