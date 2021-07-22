package poly3;

public class PartTimer extends Employees{

	private int  workTime;
	private int payPerTime;

	@Override
	public int payMonth() {
		// TODO Auto-generated method stub
		int payMonth = this.payPerTime * this.workTime * 20;
		return payMonth;
	}
	public PartTimer(String empName, String empNo, int workTime, int payPerTime) {
		super(empName, empNo);
		this.workTime = workTime;
		this.payPerTime = payPerTime;
	}
	public int getWorkTime() {
		return workTime;
	}
	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}
	public int getPayPerTime() {
		return payPerTime;
	}
	public void setPayPerTime(int payPerTime) {
		this.payPerTime = payPerTime;
	}
	@Override
	public String toString() {
		return "PartTimer [name= " + getEmpName() + "] [workTime=" + workTime + ", payPerTime=" + payPerTime + "]"
				+ "monthly pay["
				+ payMonth() + "]";
	}
	
 
}
