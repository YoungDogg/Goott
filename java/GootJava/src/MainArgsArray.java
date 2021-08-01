//메인 메서드 : 프로그램의 진입점
//메임 메서드 : 자바프로그램 호출시키면 오에스가 호출
//매개변수 : 메서드가 호출되어 실행될 때 사용할 재료 
public class MainArgsArray {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length < 1) {
			System.out.println("no parameters");
		}else {
			for(int i = 0; i < args.length; i++) {
				System.out.println("args[" + i + "] : " + args[i]);
			}
		}
	}
}