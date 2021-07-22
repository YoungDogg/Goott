package tv;

public class TVCR extends Tv{

	private VCR vcr = new VCR();
//	public static void main(String[] args) {
//		TVCR tvcr = new TVCR();
//		
//		tvcr.power();//상속받은 멤버 활용
//		tvcr.channelUp();
//	}
	
	public void play() {
		vcr.play();
	}
	public void stop() {
		vcr.stop();
	}
}
