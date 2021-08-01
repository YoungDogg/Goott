package poly3;

public class Pemanent extends Employees {

	private int annualSalary; // 연봉

	public Pemanent(String empName, String empNo, int annualSalary) {
		super(empName, empNo);
		this.annualSalary = annualSalary;
	}

	@Override
	public int payMonth() {
		// TODO Auto-generated method stub
		int payMonth = (int) Math.floor(this.annualSalary / 12d);
		return payMonth;
	}

	public int getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(int annualSalary) {
		this.annualSalary = annualSalary;
	}

	@Override
	public String toString() {
		return "Pemanent [name= " + getEmpName() + "] [annualSalary=" + annualSalary + "]" + "monthly pay[" + payMonth()
				+ "]";
	}

}
