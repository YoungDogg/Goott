package friendDB.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import friendDB.vo.FriendVo;

// DAO(Data Object Access) 데이터 베이스에 대해 수행될 모든 작업들을 모아둔 클래스 
public interface FriendDAO {
	// db를 사용 후 close 하는 메서드
	public void close(ResultSet rs, Statement stmt, Connection con) throws SQLException;

	void close(Statement stmt, Connection con) throws SQLException;

	// 친구 저장을 위해 다음 친구번호를 가져오는 메서드
	public abstract int nextFriendNo() throws ClassNotFoundException, SQLException;

	// 친구를 저장하는 메서드
	public boolean insertFriend(FriendVo fvo) throws ClassNotFoundException, SQLException;

	// 전체 친구 출력
	public List<FriendVo> selectEntireFriends() throws ClassNotFoundException, SQLException;

	// 번호로 친구 검색 (like 검색)
	public List<FriendVo> searchFriendByMobile(String mobile) throws ClassNotFoundException, SQLException;

	// 번호로 친구 검색 (equal 검색)
	public List<FriendVo> searchFriendByFUllMobile(String mobile) throws ClassNotFoundException, SQLException;

	// 이름으로 검색  
	public List<FriendVo> searchFriendByName(String name) throws ClassNotFoundException, SQLException;

	// 친구 정보 수정
	public boolean updateFriend(FriendVo fvo)throws ClassNotFoundException, SQLException;

	public boolean deleteFriend(FriendVo fvo)throws ClassNotFoundException, SQLException;


}
