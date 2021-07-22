
public class ArrayCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		char[] charArr = new char[3] {'a', 'b', 'c'}; // 숫자 넣어서 에러남
		char[] charArr = new char[] {'a', 'b', 'c'};
		
		System.out.println(charArr.length);
		
		
//		charArr[3] = 'd'; //더 집어넣으려니까 에러난다 
		for (char c : charArr) {
			System.out.println(c);
		}
		
		//    복사하기
		// 깊은 복사 -- value change of heap 
		char[] charArrCopy = new char[10];
		for (int i = 0; i <  charArr.length; i++) {
			charArrCopy[i] = charArr[i];
		}
		
		for (char c : charArrCopy) {
			System.out.print(c);
		}
		System.out.println();
		System.out.println("shallow copy");
		
		// 얕은 복사 -- address copy inside of stack
		char[] charArrShallowCpy = new char[100];
		charArrShallowCpy = charArr;
		for (char c : charArrShallowCpy) {
			System.out.print(c);
		}
	}

}
