package com.webshin.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConn {
	public static Connection getConnection() throws NamingException, SQLException {
		Connection con = null;
		// context.xml, web.xml�� �ִ� JNDI ��������
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env"); //context.xml�� ã�Ƽ� ��üȭ
		
		DataSource ds = (DataSource)envContext.lookup("jdbc/goot6");	
		con = ds.getConnection();
		return con;
	}
}
