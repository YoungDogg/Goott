
public class MethodEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		add2Num(2, 3);
//		MethodEx1.add2Num(0, 0);

//		double avg =  aveThreeNumbers(11, 20, 30);
//		System.out.println(avg);

		int[] ar = { 11, 21, 30, 40, 50 };
//		System.out.println(accArray(ar));

//		double[] dbleArr = accAvgArr(ar);
//		for (double d : dbleArr) {			
//			System.out.println(d);		
//		}

//		MethodEx1 m = new MethodEx1();
//		System.out.println(m.isEvenNumer(11));

//		String[] beforeArr = {"hi", " nicee to ", "meet ", "you"};
		InstanceMethod iMethod = new InstanceMethod();
//		
//		System.out.println(iMethod.deepCopyStrArr(beforeArr)); 
//		for (int i =0; i< iMethod.deepCopyStrArr(beforeArr).length; i++) {
//			System.out.print(iMethod.deepCopyStrArr(beforeArr)[i] + " ");
//		}
		// instance, static 차이점
		// instance : 객체 만들어야 호출 가능
		// static : 얘는 아님, 각 인스턴스 사이에 공통점이 있을 때 사용
//		System.out.println(iMethod.circleArea(10));  // 이것도 된다. 
		System.out.println(InstanceMethod.circleArea(10)); // 하지만 이렇게 하자

		
	}

	public static void add2Num(int n1, int n2) {
		int result = n1 + n2;
		System.out.println(result);
	}

	// 매개변수 : 세 수, 평균 반환 static
	public static double aveThreeNumbers(int n1, int n2, int n3) {
		double avg;
		avg = (n1 + n2 + n3) / 3f;

		return avg;
	}

	// 정수타입의 배열을 매개변수로 받아 그 배열의 모든 값 합 메서드 static
	public static long accArray(int[] arr) { // 배열을 넘기면 주소값이 넘어가서 얕은복사
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	// 정수 타입의 배열 받아서 섬을 0번째에 평균을 1에 반환
	public static double[] accAvgArr(int[] ar) {
		long sum = accArray(ar);
		double avg = (double) (sum / ar.length);

		double[] returnArr = new double[2];

		returnArr[0] = sum;
		returnArr[1] = avg;

		return returnArr;
	}

	// 매개변수 : 정수 | 리턴값 : 짝수면 트루, instance method
	public boolean isEvenNumer(int val) {

		if (val % 2 == 0) {
			return true;
		} else {
			return false;
		}

	}
}
