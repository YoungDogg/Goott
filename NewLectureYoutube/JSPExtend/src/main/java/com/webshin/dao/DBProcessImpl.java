package com.webshin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.webshin.vo.*;

public class DBProcessImpl implements DBProcess {

	private static DBProcess dao = new DBProcessImpl();

	public static DBProcess getDao() {
		if (dao == null) {
			dao = new DBProcessImpl();
		}
		return dao;
	}

	@Override
	public boolean insertImgs(Imgs imgs) throws NamingException, SQLException {
		// TODO Auto-generated method stub
		boolean result = false;
		// DB ¿¬°á
		Connection con = DBConn.getConnection();
		PreparedStatement pstmt = null;
		if (con != null) {
			String query = "insert into imgs(imgName, userId, nickName) values(?, ?, ?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, imgs.getImgName());
			pstmt.setString(2, imgs.getUserId());
			pstmt.setString(3, imgs.getNickName());

			int i = pstmt.executeUpdate();
			if (i == 1) {
				result = true;
			}
//			DBConn.close(pstmt, con);
			pstmt.close();
			con.close();
		}
		return result;
	}

	@Override
	public List<Imgs> selectAllImgs() throws NamingException, SQLException {
		// TODO Auto-generated method stub
		List<Imgs> lst = new ArrayList<Imgs>();

		Connection con = DBConn.getConnection();
		PreparedStatement pstmt = null;
		if (con != null) {
			String query = "SELECT * FROM imgs ORDER BY no DESC;";

			pstmt = con.prepareCall(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				lst.add(new Imgs(rs.getInt("no"), rs.getString("imgName"), rs.getString("userId"),
						rs.getString("nickName")));
			}
			pstmt.close();
			con.close();
		}
		
		return lst;
	}

}
