package card;

public class Card {

	static final int KIND_MAX = 4; // 카드 무늬 수
	static final int NUM_MAX = 13; // 카드 숫자 수

	private int kind;
	private int number;

	public Card(int kind, int number) {
		this.kind = kind;
		this.number = number;
	}

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	// 카드의값(종류, 숫자)를 반환하는 매서드
	// object.toString() 사용
	// 오버라이딩 : 부모의 멤버를 재정의 하며 사용
	// 오버라이딩 규칙 : 매개변수, 반환값 타입, 스태틱, 인스턴스 여부 모두 부모가 선언한 것과같아야한다
	// 오버라이딩 규칙 : 접근제한자는 부모의 것과 같거나 커야 한다

	@Override
	public String toString() {
		String kind = "";
		String number = "";

		switch (this.kind) {
		case 4:
			kind = "SPADE";
			break;
		case 3:
			kind = "DIAMOND";
			break;
		case 2:
			kind = "CLOVER";
			break;
		case 1:
			kind = "HEART";
			break;
		}
		switch (this.number) {
		case 13:
			number = "K";
			break;
		case 12:
			number = "Q";
			break;
		case 11:
			number = "J";
			break;
		case 1:
			number = "A";
			break;
		default:
			number = this.number + "";
		}
		return "TYPE[" + kind + "]" + "NUMBER[" + number + "]";
	}
}