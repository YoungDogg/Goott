package DBConnectKit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//-----------------------------
// Singleton으로 만들기
//-----------------------------
public class DBConnectKit {
	// 디비 서버에 접속하기 위해 플요한 정보(아이디, 패스워드,디비주소)
	private final String id = "hr";
	private final String pwd = "oracle";
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private	Connection connection = null;

	public DBConnectKit() {
		
		// TODO Auto-generated constructor stub

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
	}

	public void nonSelect(String sqlString) {
		// Statement : sqlString -> DB server
		Statement statement = null;
		try {
			statement = connection.createStatement();
			// insert, update, delete 쓸 때 이거 쓴다
			int result = statement.executeUpdate(sqlString);
			if (result == 1) {
				System.out.println("저장 성공");
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}

	public String getUrl() {
		return url;
	}
	
	
}
