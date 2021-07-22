enum Shape {
	Heart, Spade, Diamond, Clover
}

public class Card {

	int number;
	Shape shape;

	private static final int width = 100;
	private static final int height = 150;

	public int getNumber() {
		return this.number;
	}

	public String getShape() {
	      String returnVal = "";
	      if (this.shape == Shape.Clover) {
	         returnVal = "♣";
	      } else if (this.shape == Shape.Spade) {
	         returnVal = "♠";
	      } else if (this.shape == Shape.Diamond) {
	         returnVal = "◆";
	      } else {
	         returnVal = "♥";
	      }
	      return returnVal;
	   }



	void setNumer(int num) {
		this.number = num;
	}
	public Card(Card originCard) {
		this.number = originCard.number;
		this.shape = originCard.shape;

	}

	public Card(int num, Shape shape) {
		this.number = num;
		this.shape = shape;
	}

	public String displayCard() {
		return this.hashCode() + " : " + this.shape + "  " + this.number;
	}

	// 깊은 복사를 하는 인스턴스 메서드
//	public Card memorialGonni(Card originCard) {
//		return new Card(originCard);
//	}
	public Card memorialGonni() {
		return new Card(this);
	}
}
