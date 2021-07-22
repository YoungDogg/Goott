package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import DBConnectKit.DBConnectKit;

public class Insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//-----------------------------------------
		DBConnectKit connectKit = new DBConnectKit();
		if (connectKit.getConnection() != null) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("부서명 입력 >>> ");
			String deptName = scanner.next();

			System.out.print("부서위치 입력 >>> ");
			int locNo = scanner.nextInt();

			int deptNo = getNextDeptNo();
			String sqlString = "insert into departments(" 
			+ "department_id, department_name, location_id) " 
					+ "values ("
					+ deptNo + ",'" + deptName + "', " + locNo + ")";
			
			//----------------------------------------
			connectKit.nonSelect(sqlString);
			
			
			scanner.close();
		}
	}

	public static int getNextDeptNo() {
		//----------------------------------------
		DBConnectKit connectKit = new DBConnectKit();
		int result = 0;
		if (connectKit.getConnection() != null) {
			String sqlString = "select max(department_id) + 10 as nextId from departments";

			Statement statement = null;
			ResultSet resultSet = null; // 단방향 읽기만 가능
						
			try {
				statement = connectKit.getConnection().createStatement();
				resultSet = statement.executeQuery(sqlString);

				while (resultSet.next()) {
					result = resultSet.getInt("nextId");
				}

				resultSet.close();
				statement.close();
				connectKit.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

}
