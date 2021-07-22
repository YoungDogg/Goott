
public class InstanceMethod {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
	
// 배열을 넘겨받아 그 깊은 복사, 반환
	public String[] deepCopyStrArr(String[] ar) {
		String[] coptyStr = new String[ar.length * 2];
		
		for(int i = 0; i < ar.length; i++) {
			coptyStr[i] =  ar[i]; 
		}
		
		return coptyStr;
	}

	// 반지름 r 원넓이 반환 static
	public static double circleArea(int rad) {		
		return (double)(rad * rad * Math.PI);	
	}
}
