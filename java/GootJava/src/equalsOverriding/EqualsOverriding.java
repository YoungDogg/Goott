package equalsOverriding;

public class EqualsOverriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student = new Student("2020", "name1");
		Student student2 = new Student("2020", "name1");
		
//		if(student == student2)
//			System.out.println("smae");
//		
//		if(student.getStdNo().equals(student2.getStdNo()))
//			System.out.println("same");
		
		if(student.equals(student2))
			System.out.println("same");
		
	}

}
