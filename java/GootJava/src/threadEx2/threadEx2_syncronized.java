package threadEx2;

public class threadEx2_syncronized {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r= new Family();
		Thread dad = new Thread(r, "아빠");
		Thread mom = new Thread(r, "엄마");
		
		dad.start();
		mom.start();
	}

}
