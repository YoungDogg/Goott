package poly2;

public class Painter {

	public void draw(Shape s){
		if(s instanceof Triangle) {
			System.out.println(s.outputPoints() + "을 가지고 있고, 이름 : " 
					+ s.getName() + ", 색상 : " + s.getColor() 
					);		
		}else if (s instanceof Circle) {
			Circle c = (Circle)s;	//다운캐스팅 해서 자식 것을 가져온다 
			System.out.println(s.outputPoints() + "을 가지고 있고, 이름 : " 
					+ s.getName() + ", 색상 : " + s.getColor() + " 반지름 : " 
					+  c.getRadius()
					);
		}
	}
}
