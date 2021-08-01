package compreTo;

public class HasATest {

	public static void main(String[] args) {
		Point p = new Point (100,100);
		System.out.println(p.toString());
				
		Point p2 = new Point(220,0);
		System.out.println(p2.toString());
		
		
		int result = p.compareTo(p2);
		if(result > 0) {
			System.out.println("p가 더 큽니다");
		} else if (result < 0) {
			System.out.println("p2가 더 큽니다");
		}else if (result == 0) {
			System.out.println("서로 같습니다");
		}
		
		
//		if (p instanceof Point) {
//			System.out.println("그렇다");
//		} else {
//			System.out.println("아니랜다");
//		}
	}

}