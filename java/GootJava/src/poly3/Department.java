package poly3;

import java.util.ArrayList;
import java.util.Comparator;

public class Department {

	private String depName;
	private String depNo;
	private String depAddr;
	private ArrayList<Employees> empList;

	public Department(String depName, String depNo, String depAddr) {
		super();
		this.depName = depName;
		this.depNo = depNo;
		this.depAddr = depAddr;
		this.empList = new ArrayList<Employees>();
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getDepAddr() {
		return depAddr;
	}

	public void setDepAddr(String depAddr) {
		this.depAddr = depAddr;
	}

	public String getDepNo() {
		return depNo;
	}

	public void getEmpList() {
		for (Employees employees : empList) {
			System.out.print(employees + " ");
		}
	}

	public void setEmpList(ArrayList<Employees> empList) {
		this.empList = empList;
	}

	@Override
	public String toString() {
		String empStr = "";

		for (Employees employees : empList) {
			empStr += (employees + " ");
		}
		return "Department [depName=" + depName + ", depNo=" + depNo + ", depAddr=" + depAddr + ", empList=" + empStr
				+ "]";
	}

	public void addEmployees(Pemanent pemanent) {
		empList.add(pemanent);

	}

	public void addEmployees(PartTimer partTimer) {
		// TODO Auto-generated method stub
		empList.add(partTimer);
	}

	public Employees findEmpNo(String empNo) {
//		return ""+empList.indexOf(empNo);
		Employees temp = null;
		if (empList.indexOf(empNo) != -1)
			temp = empList.get(empList.indexOf(empNo));
		return temp;
	}

	public boolean deleteByEmpNo(String empNo) {
		boolean isDelete = false;
		for (Employees employees : empList) {
			if (employees.getEmpNo().equals(empNo)) { // same employee
				this.empList.remove(employees);
				isDelete = true;
				break;
			}
		}
		return isDelete;
	}

	public void deleteByEmpName(String empName) {
//		boolean isDelete = false;
		for (Employees employees : empList) {
			if (employees.getEmpName().equals(empName)) { // same employee
				this.empList.remove(employees);
//				isDelete = true;
				System.out.println(empName + " 삭제 성공");
				break;
			}
		}
//		return isDelete;
		for (Employees employees : empList) {
			System.out.print(employees + "  ");
		}
	}

	public Employees findByName(String name) {
		// TODO Auto-generated method stub
		for (Employees employees : empList) {
			if (employees.getEmpName().equals(name))
				return employees;
		}
		return null;
	}

	public void sortByEmpNoAsc() {
		Comparator<Employees> c = new Comparator<Employees>() {
			@Override
			public int compare(Employees e1, Employees e2) {

				int result = 0;

				if (Integer.parseInt(e1.getEmpNo()) > Integer.parseInt(e2.getEmpNo())) {
					result = 1;
				} else if (Integer.parseInt(e1.getEmpNo()) < Integer.parseInt(e2.getEmpNo())) {
					result = -1;
				}
				return result;
			}
		};
		this.empList.sort(c);
		display();
	}
	
	public void display() {
		for (Employees employees : empList) {
			System.out.print(employees + " ");
		}
	}
}
