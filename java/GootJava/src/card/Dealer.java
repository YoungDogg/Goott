package card;

public class Dealer {
	final int CARD_NUM = 52; // 카드의 갯수 
	Card[] cards = new Card[CARD_NUM];
	
	public Dealer() {
		int cnt = 0;
		for(int i = Card.KIND_MAX; i > 0 ; i--) {	// i = 4, 3, 2, 1
			for(int j = 1; j < Card.NUM_MAX + 1; j++) {	// j = 1 ~ 13
				cards[cnt++] = new Card(i, j);
			}
		}
	}
	
	public void shuffle() {
		for(int i = 0; i < 1000; i++) {
			int n = (int)(Math.random() * CARD_NUM); //0 ~ 51 까지의 난수 발생 
			Card temp = this.cards[0];
			this.cards[0] = this.cards[n];
			this.cards[n] = temp;
		}
	}
	
	public Card pick() {
		return this.cards[0];
	}
	
	public void displayDealersCard() {
		for (Card card : cards) {
			System.out.println(card.toString());
		}
		
	}
}
