package inheritance;

public class Tv {
	private boolean power;
	private int channel;
	
	
	
	public Tv() {
		super();
	}

	public Tv(boolean pwr, int chn) {
		// TODO Auto-generated constructor stub
		this.power = pwr;
		this.channel = chn;
	}
	
	public boolean getPwr() {
		return this.power;
	}
	public int getChanner() {
		return this.channel;
	}
	
	public void setPower() {
		this.power = !this.power;
	}
	public void setChannel(int ch) {
		this.channel = ch;
	}
	
	@Override
	public String toString() {
		return "Tv [power : " + power + ", channel : " + channel + "]";
	}
	
}
