package exceptionEx2;

public class NotPositiveException extends Exception {

	public NotPositiveException() {
		this("");
	}
	
	public NotPositiveException(String msg) {
		super(msg);
		System.out.println("양수가 입력되지 않았습니다.");
//		System.out.println("프로그램이 종료됩니다...");
//		System.exit(0);
		
	}
}
