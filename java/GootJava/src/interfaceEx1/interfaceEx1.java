package interfaceEx1;

public interface interfaceEx1 {
	public static void main(String[] args) {
		SmartPhone phone = new SmartPhone();
		
		phone.calling();
		
		Computer c = new Computer() {

			@Override
			public void playingGame() {
				// TODO Auto-generated method stub
				System.out.println("c plays game");
			}  
			
		};
		c.playingGame();
		
		Computer c2 = new Computer() {

			@Override
			public void playingGame() {
				// TODO Auto-generated method stub
				System.out.println("c2 plays game");
			}
		};
		c2.playingGame();
	}
}
