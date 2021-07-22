package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Select {

	public static void main(String[] args) {

		// 디비 서버에 접속하기 위해 플요한 정보(아이디, 패스워드,디비주소)
		String id = "hr";
		String pwd = "oracle";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		Connection connection = null;
		try {
			// oracle.jdbc.driver.OracleDriver라는 드라이버 클래스를 보냄
			Class.forName("oracle.jdbc.driver.OracleDriver");

			connection = DriverManager.getConnection(url, id, pwd);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
			System.exit(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("디비 연결 실패");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("뭔가 모르는 오류");
			// TODO: handle exception
		}
		if (connection != null) {
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
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sqlString);

				while (resultSet.next()) {
//					 System.out.println(resultSet.getInt(1));
					System.out.println(resultSet.getInt("employee_id") 
							+ " " + resultSet.getString("first_name"));
				}
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}}
