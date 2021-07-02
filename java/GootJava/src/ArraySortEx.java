import java.util.Random;
import java.util.Scanner;

public class ArraySortEx {

	public static void main(String[] args) {
		// 크기가 20인 배열에 1 ~ 100까지의 난수 저장
		// 값 입력, 몇 번째에 있는지 출력
		
		int[] randArr = new int[20];
		Random rand = new Random();
		
		//난수 생성
		for(int i = 0; i< randArr.length; i++) {
			int randNum = rand.nextInt(100) + 1;
			randArr[i] =  randNum;
		}
		
		for (int i : randArr) {			
			System.out.print(i + " ");
		}
		
		// 찾을 값을 키보드로부터 입력 받음
		Scanner sc = new Scanner(System.in);
		System.out.println("배열 입력 ");
		int num =  sc.nextInt();

		boolean find = false; 	//못찾았다고 가정하면 
		for(int i = 0; i < randArr.length; i++) {
			if(randArr[i] == num) {
				System.out.println("ar 배열의 "+ i + "번째에 " +num +"있다");
				find = true;
				break; 
			}
			if(!find && i >= randArr.length -1) {
				System.out.println("no num in this arr");
			}
		}
		

	}
}
