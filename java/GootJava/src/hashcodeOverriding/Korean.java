package hashcodeOverriding;

public class Korean {
	private String regNo;
	private String name;

	public Korean(String regNo, String name) {
		super();
		this.regNo = regNo;
		this.name = name;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Korean [ hashcode= "+ this.hashCode() +", regNo=" + regNo + ", name=" + name + "]";
	}

}
