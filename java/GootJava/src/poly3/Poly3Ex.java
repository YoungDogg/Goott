package poly3;

import java.util.ArrayList;

public class Poly3Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Department hq = new Department("총무부", "10", "종로구 을지로");
		
		hq.addEmployees(new Pemanent("몰리", "201000", 2400));
		hq.addEmployees(new Pemanent("둘리", "201001", 2401));
		hq.addEmployees(new PartTimer("훌리", "201002", 8, 1));
//		
//		hq.getEmpList();
//		System.out.println();
//		System.out.println("===============");
//		System.out.println(hq.toString());
//		
//		if(hq.findEmpNo("10") != null)
//			System.out.println();
//		
//		System.out.println();
//		System.out.println("===============");
		//이름 넘겨주면 정보 출력
//		ArrayList<Employees> findList = hq.findEmpNo("둘리"));
//		Employees findName = hq.findByName("둘리");
//		System.out.println(findName.toString());
		
//		System.out.println();
//		System.out.println("===============");
//		
//		hq.deleteByEmpName("둘리2");
//		
		System.out.println();
		System.out.println("===============");
		hq.sortByEmpNoAsc();		
		
	}

}
