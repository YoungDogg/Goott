package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Insert {

	
	public static void main(String[] args) {

		outputLocations();
		
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
			System.out.print("부서명 입력 >>> ");
			String deptName = scanner.next();
			
			System.out.print("부서위치 입력 >>> ");
			int locNo = scanner.nextInt();
			
			int deptNo = getNextDeptNo();
			String sqlString = "insert into departments("
					+ "department_id, department_name, location_id) "
					+ "values ("+deptNo+",'"+deptName+"', "+locNo+")";
			
			

			// Statement : sqlString -> DB server
			Statement statement = null;  
			try {
				statement = connection.createStatement();
				//insert, update, delete 쓸 때 이거 쓴다 
				int result = statement.executeUpdate(sqlString);
				if(result == 1) {
					System.out.println("저장 성공");
				}
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void outputLocations() {
		int result = 0;
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
			String query = "select location_id, city from locations";
			Statement statement = null;
			ResultSet resultSet = null;
			try {
				statement = connection.createStatement();
				resultSet =  statement.executeQuery(query);
				
				while (resultSet.next()) {
//					 System.out.println(resultSet.getInt(1));
					System.out.println(resultSet.getInt("location_id") 
							+ " " + resultSet.getString("city"));
				}
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	private static int getNextDeptNo() {
		// 디비 서버에 접속하기 위해 플요한 정보(아이디, 패스워드,디비주소)
				int result = 0;
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
					String sqlString = "select max(department_id) + 10 as nextId from departments";
					
					Statement statement = null;
					ResultSet resultSet = null; //단방향 읽기만 가능  
					try {
						statement = connection.createStatement();
						resultSet = statement.executeQuery(sqlString);
						
						while (resultSet.next()) {
							result = resultSet.getInt("nextId");
						}
					
						resultSet.close();
						statement.close();
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		return result;
	}

}
