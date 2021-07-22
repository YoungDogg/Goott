package recursiveEx1;

public class RecursiveEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 3;
		
		System.out.println(factorial(n));
	}

	private static int factorial(int n) {
		// TODO Auto-generated method stub
		if(n <= 1) {return n;}
		else {
			return factorial(n - 1) * n;
		}
	}

}
