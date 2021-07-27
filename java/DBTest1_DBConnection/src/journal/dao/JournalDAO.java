package journal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;

import journal.vo.JournalVo;

// DAO(Data Object Access) 데이터관련 작업들 모아둔 곳
public interface JournalDAO {
	//일기 입력
	public boolean insertJournal(JournalVo jvo) throws ClassNotFoundException, SQLException, ParseException;
	//일기 수정
	public boolean updateJournal(JournalVo jvo);
	//일기 삭제
	public boolean deleteJournal(JournalVo jvo) throws SQLException, ClassNotFoundException;
	//일기 전체 출력
	public List<JournalVo> selectAllJournal() throws SQLException, ClassNotFoundException;
	
	//일기를 저장하기 위해 다음 일기 번호를 가져오는 메서드
	public abstract int nextJournalNo() throws ClassNotFoundException, SQLException;
	//일기를 저장하기 위해 다음 일기 날짜를 가져오는 메서드
	public abstract String nextJournalDate() throws ClassNotFoundException, SQLException;
	
	// db를 사용 후 close 하는 메서드
	public void close(ResultSet rs, Statement stmt, Connection con) throws SQLException;

	void close(Statement stmt, Connection con) throws SQLException;
	

}
