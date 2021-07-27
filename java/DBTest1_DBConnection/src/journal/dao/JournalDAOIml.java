package journal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import friendDB.vo.FriendVo;
import journal.vo.JournalVo;

public class JournalDAOIml implements JournalDAO {
	private static final String id = "hr";
	private static final String pwd = "oracle";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String oracleDriver = "oracle.jdbc.driver.OracleDriver";

	@Override
	public boolean insertJournal(JournalVo jvo) throws ClassNotFoundException, SQLException, ParseException {
		boolean result = true;
		Connection connection = null;
		Class.forName(oracleDriver);
		connection = DriverManager.getConnection(url, id, pwd);
		PreparedStatement psmt = null;

//		Date date = new Date();
//		SimpleDateFormat formatter =  new SimpleDateFormat("yyyy년 MM월 dd일 E요일");				
//		date = formatter.parse(jvo.getJournalDate());
//		formatter = new SimpleDateFormat("yyyy-MM-dd");
//		jvo.setJournalDate(formatter.format(date));
		
		System.out.println(jvo.getJournalDate());
		if (connection != null) {
			String query = "insert into journal VALUES (?, ?, ?)";

			psmt = connection.prepareCall(query);
			psmt.setInt(1, jvo.getJournalNo());
			psmt.setDate(0, null);
			psmt.setString(3, jvo.getJournalContent());

			int i = psmt.executeUpdate();
			if (i == 1) {
				result = true;
			}
			close(psmt, connection);
		}
		return result;
	}

	@Override
	public boolean updateJournal(JournalVo jvo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteJournal(JournalVo jvo) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		boolean result = false;
		final String id = "hr";
		final String pwd = "oracle";
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection connection = null;		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection(url, id, pwd);
		PreparedStatement psmt = null;
	
		if(connection != null) {
			String query = "DELETE FROM journal WHERE journalNO = ?";
			psmt = connection.prepareCall(query);
			psmt.setInt(1, jvo.getJournalNo());
			
			int i = psmt.executeUpdate();
			if(i == 1) {
				result = true;
			}
			close(psmt, connection);
		}		
		return result;
	}

	@Override
	public List<JournalVo> selectAllJournal() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		List<JournalVo> lst = new ArrayList<JournalVo>();
		
		final String id = "hr";
		final String pwd = "oracle";
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection connection = null;		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection(url, id, pwd);
		
		if(connection != null) {
			String query = "select * from journal order by journalno asc";
			// 매개변수 없다 -> statmeet, 있다 -> preparedstatement 
			Statement stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				lst.add(
					new JournalVo(rs.getInt("journalno"), rs.getDate("journaldate"),
					rs.getString("journalcontent")));
			}
			
			close(rs, stmt, connection);
		}
		return lst;
	}

	@Override
	public int nextJournalNo() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int nextFriendNo = 0;

		Connection con = null;
		Statement stmt = null;
		Class.forName(oracleDriver);
		con = DriverManager.getConnection(url, id, pwd);

		if (con != null) {
			String query = "select max(journalno) as nextNo from journal";

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				System.out.println(rs.getInt("nextNo"));
				nextFriendNo = rs.getInt("nextNo") + 1;
			}
			close(rs, stmt, con);
		}
		return nextFriendNo;
	}

	@Override
	public String nextJournalDate() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String nextJournalDate = "";

		Connection con = null;
		Statement stmt = null;
		Class.forName(oracleDriver);
		con = DriverManager.getConnection(url, id, pwd);

		if (con != null) {
			String query = "select max(journaldate + 1) as nextDate from journal";

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {				
				nextJournalDate = rs.getString("nextDate");
			}

			close(rs, stmt, con);
		}

		return nextJournalDate;
	}

	@Override
	public void close(ResultSet rs, Statement stmt, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		rs.close();
		stmt.close();
		con.close();
	}

	@Override
	public void close(Statement stmt, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		stmt.close();
		con.close();
	}

}
