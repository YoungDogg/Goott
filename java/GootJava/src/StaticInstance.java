// static  클래스가 로딩될 때 생성, 프로그램 종료시 삭제
// 인슨턴스 해당 클래스 변수가 객체화될 때 생성, 객체 소멸되면 삭제

public class StaticInstance {
	static int sint = 0;	// static
	int justInt = 0;		// instance

	public void add() {
		StaticInstance.sint++;
		this.justInt++;

		System.out.println(StaticInstance.sint + " " + this.justInt);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 0; i < 10; i++) {
			StaticInstance s = new StaticInstance();
			s.add();
		}
	}

}
