package com.webshin.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.cj.xdevapi.Statement;

public class DBConn {
	public static Connection getConnection() throws NamingException, SQLException {
		Connection con = null;
		// context.xml, web.xml에 있는 JNDI 가져오기
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env"); //context.xml을 찾아서 객체화
		
		DataSource ds = (DataSource)envContext.lookup("jdbc/goot6");	
		con = ds.getConnection();
		return con;
	}
	
//	public static void close(Prepa stmt, Connection con) {
//		stmt.close();
//		con.close();
//	}
}
