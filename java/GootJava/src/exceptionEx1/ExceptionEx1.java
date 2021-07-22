package exceptionEx1;

public class ExceptionEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 5, b = 0;
		int result = 0;
				
		
		try {
			result = a / b;						
		}catch(ArithmeticException e) {
			System.out.println("0으로 나누지 말아요~");
			e.printStackTrace();
			System.exit(0);
		}catch (Exception e) {	// 다중 캐치시 최상위 익셉션을 제일 나중에 둔다 
			System.out.println("보편적인 예외");
			e.printStackTrace();
		}finally {	// try 수행 상관없이 수행됨 
			System.out.println("!");
		}
	}

}
