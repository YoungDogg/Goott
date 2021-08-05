package com.webshin.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.webshin.vo.Imgs;

public interface DBProcess {
	// imgs ���׺� �����ϴ� �޼���
	boolean insertImgs(Imgs imgs) throws NamingException, SQLException;
	
	// imgs ���̺��� ��� �����͸� ��ȯ�ϴ� �޼���
	List<Imgs> selectAllImgs() throws NamingException, SQLException;
	
}
