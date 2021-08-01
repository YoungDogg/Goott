
public class DataTypeAndVariables {

	public static void main(String[] args) {
		//자바 데이터 타입
		//기본 데이터 타입(빌트인 타입)
		//char : 1문자를 저장
		char ch = 'a';
		System.out.println(ch);
		ch = '가';
		System.out.println(ch);
		char char1 = '\u0041';
		System.out.println(char1);
		
		// boolean
		boolean b = true;
		System.out.println("b");
		boolean b2 = false;
		System.out.println(b2);
		
		// 정수표현 byte 1byte, short 2byte, int 4byte, long 8byte
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		
		System.out.println(Short.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);
		
		
		long l = 222l; //  l 
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		//실수표현 float 4byte, double 8byte
		float f = 3.1f; //에러 난다. 뒤에 f 써, default : double
		System.out.println(Float.MAX_VALUE);
		System.out.println(Float.MIN_VALUE);
				
		double d = 2222.222;
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);
		
		//문자열    클래스 타입 
		String str = "대한민국";
		String str2 = new String("woeijfewoifj"); //이렇게 쓰면 불편하다. 
		System.out.println(str);
	}
}
