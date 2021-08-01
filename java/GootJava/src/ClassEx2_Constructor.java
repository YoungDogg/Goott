

public class ClassEx2_Constructor {

	public static void main(String[] args) {
				
		Phone phone = new Phone();
		Phone phone2 = new Phone("이렇게 해도 된다");
		Phone phone3 = new Phone("갤럭시20", "엘지", 1000);
		
		Student std = new Student(1, "smith", Gender.male, "010-0000-0001");
		Student std2 = new Student(2, "John", Gender.male, "010-0000-0002");
		
		std.introduceStudent();
		std2.introduceStudent();
	}
}
