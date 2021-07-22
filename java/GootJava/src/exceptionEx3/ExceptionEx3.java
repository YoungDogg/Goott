package exceptionEx3;
class A {

	public void method(int i, int j) throws ArithmeticException {
		// TODO Auto-generated method stub
		int result = 0;
		result = i /j;
	} 
	
}
public class ExceptionEx3 {
	public static void main(String[] args) throws ArithmeticException {
		A a = new A();
		a.method(4,0);			
//		try {
//		}catch (ArithmeticException e) {
//			// TODO: handle exception
//			System.out.println("0으로 나누는 예외 처리");
//		}
	}
}
