package friendDB.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DBConnectKit.DBConnectKit;
import friendDB.vo.FriendVo;

public class FriendDAOIml implements FriendDAO{

	private static final String id= "hr";
	private static final String pwd = "oracle";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	@Override
	public int nextFriendNo() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int nextFriendNo = 0;
		
		Connection con = null;
		Statement stmt = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(url, id, pwd);
		
		if(con != null) {
			String query =  "select max(friendNo) as maxFriendNo from Friends";
			
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				System.out.println(rs.getInt("maxFriendNo"));
				nextFriendNo = rs.getInt("maxfriendNo") +1;
			}
			
			 close(rs, stmt, con);
		}
		
		return nextFriendNo;
	}
	
	@Override
	public void close(Statement stmt, Connection con) throws SQLException {
		// TODO Auto-generated method stub		
		stmt.close();
		con.close();
		
	}
	@Override
	public void close(ResultSet rs, Statement stmt, Connection con) 
			throws SQLException {
		// TODO Auto-generated method stub
		rs.close();
		stmt.close();
		con.close();
	}
	@Override
	public boolean insertFriend(FriendVo fvo)
			throws ClassNotFoundException, SQLException {
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
			String query = "insert into friends VALUES (?, ?, ?, ?)";
			
			psmt = connection.prepareCall(query);
			psmt.setInt(1, fvo.getFriendNo());
			psmt.setString(2, fvo.getFriendName());
			psmt.setString(3, fvo.getFriendMobile());
			psmt.setString(4, fvo.getFriendAddress());
			
			int i = psmt.executeUpdate();
			if(i == 1) {
				result = true;
			}
			close(psmt, connection);
		}		
		return result;
	}
	@Override
	public boolean updateFriend(FriendVo fvo) 
			throws ClassNotFoundException, SQLException {
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
			String query = "update friends "
					+ " set FRIENDNAME= ?, FRIENDMOBILE = ?, FRIENDADDRESS = ?"
					+ " where FRIENDNO = ?";
			
			psmt = connection.prepareCall(query);
			psmt.setString(1, fvo.getFriendName());
			psmt.setString(2, fvo.getFriendMobile());
			psmt.setString(3, fvo.getFriendAddress());
			psmt.setInt(4, fvo.getFriendNo());
			
			int i = psmt.executeUpdate();
			if(i == 1) {
				result = true;
			}
			close(psmt, connection);
		}
		
		return result;
	}
	@Override
	public boolean deleteFriend(FriendVo fvo) throws ClassNotFoundException, SQLException {
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
			String query = "DELETE FROM friends WHERE FRIENDNO = ?";
			psmt = connection.prepareCall(query);
			psmt.setInt(1, fvo.getFriendNo());
			
			int i = psmt.executeUpdate();
			if(i == 1) {
				result = true;
			}
			close(psmt, connection);
		}		
		return result;
	}

	@Override
	public List<FriendVo> selectEntireFriends() 
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<FriendVo> lst = new ArrayList<FriendVo>();
		
		final String id = "hr";
		final String pwd = "oracle";
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection connection = null;		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection(url, id, pwd);
		
		if(connection != null) {
			String query = "select * from friends order by friendname asc";
			// 매개변수 없다 -> statmeet, 있다 -> preparedstatement 
			Statement stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				lst.add(
					new FriendVo(rs.getInt("FRIENDNO"), rs.getString("FRIENDNAME"),
					rs.getString("FRIENDMOBILE"), rs.getString("FRIENDADDRESS")));
			}
			
			close(rs, stmt, connection);
		}
		return lst;
	}

	@Override
	public List<FriendVo> searchFriendByMobile(String mobile)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<FriendVo> lst = new ArrayList<FriendVo>();
		Connection connection = null;		
		PreparedStatement pstmt = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection(url, id, pwd);
		if(connection != null) {
			String query = "select * from friends where "
					+ "FRIENDMOBILE like '%' || ? ||'%'";
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, mobile);
					
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				lst.add(new FriendVo(rs.getInt("FRIENDNO"),
						rs.getString("FRIENDNAME"),rs.getString("FRIENDMOBILE"),
						rs.getString("FRIENDADDRESS")));
			}			
			close(rs, pstmt, connection);
		}
		return lst;
	}

	@Override
	public List<FriendVo> searchFriendByFUllMobile(String mobile) 
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<FriendVo> searchFriendByName(String name) 
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<FriendVo> lst = new ArrayList<FriendVo>();
		Connection connection = null;		
		PreparedStatement pstmt = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection(url, id, pwd);
		if(connection != null) {
			String query = "select * from friends where FRIENDNAME "
					+ "like '%'|| ? ||'%'";
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, name);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				lst.add(new FriendVo(rs.getInt("FRIENDNO"),
						rs.getString("FRIENDNAME"),rs.getString("FRIENDMOBILE"),
						rs.getString("FRIENDADDRESS")));
			}
			close(rs, pstmt, connection);
		}
		return lst;
	}





}
