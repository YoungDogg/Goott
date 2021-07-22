package assignment;

class Student{
	String stdNum;
	String stdName;
	int korScore;
	int engScore;
	int mathScore;
	int sum;
	double avg;
	
	static int sumOfAll;		
	
	public Student(String num, String name, int kor, int eng, int math) {
		this.stdNum = num;
		this.stdName = name;
		this.korScore = kor;
		this.engScore = eng;
		this.mathScore = math;
		
		//ORM 기반, DB기반에선 최대한 메서드 줄이는 게 중점
		sum = this.korScore + this.engScore + this.mathScore;				
		avg = Math.round((sum * 100 / 3f) ) / 100; 
		
	}
//	int sum() {
//		return this.korScore + this.engScore + this.mathScore;
//	};
//	double avg() {
//		return Math.round((this.sum() / 3f) * 100) / 100; 
//	};
		
}

public class TableOfStudent {

	public static void main(String[] args) {

		Student[] s = {
		               new Student("1", "Sam", 100, 100, 100),
		               new Student("2", "John", 90, 90, 90),
		               new Student("3", "Will", 60, 70, 80),
		               new Student("4", "Kristine", 40, 20, 10),
		               new Student("5", "Olivia", 80, 81, 100)
		};
		//각 학생의 총점, 평균 구하기 
		for (Student student : s) {			
			System.out.println(
					"sum of " + student.stdName + " : " + student.sum
					+ " avg : " + student.avg);
		}
		//전체 학생의 평균
//		int sumOfAllStd = 0;
//		for (Student student : s) {
//			sumOfAllStd += student.sum();
//		}
//		int avgOfAllStd = sumOfAllStd / (3 * s.length); // 3과목 * 전체학생수 
//		System.out.println("sum of all student : " + sumOfAllStd
//							+ " avg of all student : " + avgOfAllStd
//				);
		// using static var of Student
		for (Student student : s) {
			Student.sumOfAll += student.sum;
		}
		// 3과목 * 전체학생수 
		double avgOfAllStd = Student.sumOfAll  / (3f * s.length); 
		System.out.println("sum of all student : " + Student.sumOfAll
							+ " avg of all student : " + avgOfAllStd
				);

	}

}
