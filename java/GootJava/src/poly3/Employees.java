package poly3;

import java.util.Comparator;

public abstract class Employees {
	private String empName;
	private String empNo;

	public Employees(String empName, String empNo) {
		super();
		this.empName = empName;
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	@Override
	public String toString() {
		return "Employees [empName=" + empName + ", empNo=" + empNo + "]";
	}
	
	public abstract int payMonth();
	
	
}
