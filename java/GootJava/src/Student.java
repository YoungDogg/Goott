
enum Gender {
	male, female
}
public class Student {

	int stdNum;
	String name;	
	String phone;
	Gender sex;

//	enum Gender {male, female};
	public Student() {

	}
	
	public Student(int stdNum, String name, Gender sex, String phone) {
		this.stdNum = stdNum;
		this.name =name;
		this.sex = sex;
		this.phone = phone;
	}

	void introduceStudent(){
		System.out.println(
				this.stdNum + " " +  this.name + "  "
				+ this.sex + " " + this.phone
				);
	}
	
}
