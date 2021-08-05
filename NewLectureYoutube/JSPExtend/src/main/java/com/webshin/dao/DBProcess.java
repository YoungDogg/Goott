package com.webshin.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.webshin.vo.Imgs;

public interface DBProcess {
	// imgs 테잉블에 저장하는 메서드
	boolean insertImgs(Imgs imgs) throws NamingException, SQLException;
	
	// imgs 테이블의 모든 데이터를 반환하는 메서드
	List<Imgs> selectAllImgs() throws NamingException, SQLException;
	
}
