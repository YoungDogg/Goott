// 배열 : 같은 이름으로 같은 타입의 데이터를 연속 저장할 수 있는타입 
public class ArrayEx1 {

	public static void main(String[] args) {		
		int[] scoresArr = new int[4];	// int타입의 배열
		
		System.out.println(scoresArr);
		
		int[] scores = {90, 22, 11, 30};
		System.out.println(scores);
		
		for(int i = 0; i < scores.length; i++) {
			System.out.println(scores[i]);
		}
		for (int i : scores) {
			System.out.println(i);
		}
		
		//socore 배열의 총 합을 구해보자
//		int i = 0, sum = 0;
//		while(i < scores.length) {
//			sum += scores[i];
//			i++;
//		}
//		System.out.println(sum);
		
		//------------------------------------------------
		//score 배열의 최댓값 최솟값 풀기

//		int min = 1000, max = -1000;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for(int i = 1; i< scores.length; i++) {
			for(int j = 0; j < i; j++) {
				if(scores[i] < scores[j]) {
					int temp = scores[i];
					scores[i] = scores[j];
					scores[j] = temp;
				}
			}
		}
		min = scores[0];
		max = scores[scores.length-1];
		System.out.println("min : " + min);
		System.out.println("max : " + max);
	}
}
