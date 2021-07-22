package card;

public class CardEx {

	public static void main(String[] args) {
//		Dealer d = new Dealer();
//		d.displayDealersCard();
		
		String[] str = new String[] {
				"우리",
				"나라",
				"대한민국"
		};
		
		for (String string : str) {
			System.out.println(string);
		}
		
		str[1] = null;
		str[1] = str[2];
		
		System.out.println("============");
		
		for (String string : str) {
			System.out.println(string);
		}
		
		System.out.println("===============");
		
	}
}
