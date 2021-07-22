package exceptionEx2;

import java.util.Scanner;

public class ExceptionEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NotPositiveException exception = null;
		System.out.println("input number");
		Scanner scanner = new Scanner(System.in);
		int num =  scanner.nextInt();
		
		if(num <= 0) {
			try {
				throw new NotPositiveException("우리가 만든 예외");				
			}catch (NotPositiveException e) {
				// TODO: handle exception
				System.out.println("예왜처리중");
				e.printStackTrace();
				
			}
		}
//		else {
//			throw exception;			
//		}		
		System.out.println(num);
	}

}
