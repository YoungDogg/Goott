package interfaceEx3;

interface I{
	String methodB(int width, int height);
}

class A {
	public void methodA (I i) {
		i.methodB(100, 200);
	}
}

class B implements I{
	public void methodB() {
		System.out.println("B");
	}

	@Override
	public String methodB(int width, int height) {
		// TODO Auto-generated method stub
		return null;
	}
}
public class InterfaceEx3 {
	public static void main(String[] args) {
		
	}
}
