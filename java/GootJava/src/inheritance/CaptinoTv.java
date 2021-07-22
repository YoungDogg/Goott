package inheritance;

public class CaptinoTv extends Tv {

	public CaptinoTv() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("caption tv" +super.getPwr());
	}

	public void display() {
		System.out.println("자막 나온다.");
	}

	@Override
	public String toString() {
		return "CaptinoTv []";
	}
	
}
