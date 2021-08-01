
public class MethodEx2_Overloading {

	// int 타입 2개를 받아 두 수를 더해 출력 메서드 
	public static void add (int a, int b) {
		System.out.println(a + b);
	}

	// int 3 parameters static 
	public static void add (int a, int b, int c){
		System.out.println(a + b + c);
	}
	
	public String add(String a, String b) {
		return a + b;
	}
	
	public float add(float a, float b, float c) {
		return a + b + c;
	}
	
	public static void main(String[] args) {
		
		MethodEx2_Overloading m = new MethodEx2_Overloading();
		
		add(2, 3);
		add(1, 2, 3);
		System.out.println(m.add("안녕","하세요"));
		System.out.println(m.add(1f, 2f, 333.333f));
	}
}
