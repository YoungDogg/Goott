package hashcodeOverriding;

public class Student extends Korean {
	private String stdName;
	private String stdNo;


	public Student(String regNo, String name, String stdName, String stdNo) {
		super(regNo, name);
		this.stdName = stdName;
		this.stdNo = stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getStdNo() {
		return stdNo;
	}

	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}

	@Override
	public String toString() {
		return "Student [stdName=" + stdName + ", stdNo=" + stdNo + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		boolean result = false;
		
		if(this.stdNo.equals(((Student)obj).stdNo)){
			result = true;
		}
		
		return result;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	
	
}
