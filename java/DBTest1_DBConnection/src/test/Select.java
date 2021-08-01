package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import DBConnectKit.DBConnectKit;

public class Select {

	public static void main(String[] args) {

		DBConnectKit connectKit = new DBConnectKit();
		if(connectKit.getConnection() != null) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("조회할 사원 번호 >>> ");
			int empNo = scanner.nextInt();
			String sqlString = "select * from employees where employee_id = "
					+ empNo;
//			String sqlString = "select * from employees";
			// Statement : sqlString -> DB server
			Statement statement = null;
			ResultSet resultSet = null; //단방향 읽기만 가능  
			try {
				statement = connectKit.getConnection().createStatement();
				resultSet = statement.executeQuery(sqlString);

				while (resultSet.next()) {
//					 System.out.println(resultSet.getInt(1));
					System.out.println(resultSet.getInt("employee_id") 
							+ " " + resultSet.getString("first_name"));
				}
				resultSet.close();
				statement.close();
				connectKit.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
