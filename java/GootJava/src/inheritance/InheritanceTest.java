package inheritance;

public class InheritanceTest {
	public static void main(String[] args) {
		Tv tv = new Tv(true, 7);
		System.out.println(tv.toString()); 
		
		CaptinoTv captinoTv = new CaptinoTv();
		captinoTv.setPower();
		System.out.println(captinoTv.getPwr());
		
		System.out.println(captinoTv.toString());
	}
	
}
