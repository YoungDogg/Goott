
public class CardTest {

	public static void main(String[] args) {
		
		Card c1 = new Card(2,Shape.Heart);
		
		System.out.println(c1.displayCard());
		
		Card c2 = c1.memorialGonni();
		System.out.println(c2.displayCard());
	}	

}
