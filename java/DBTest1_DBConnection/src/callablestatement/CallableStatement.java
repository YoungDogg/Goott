package callablestatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DBConnectKit.DBConnectKit;

public class CallableStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnectKit connectKit = new DBConnectKit();
		if (connectKit.getConnection() != null) {
			// Callable 사용 안했을 때
//			String insertQuery = "insert into sales(salesNo, prodNo, qty) "
//					+ "values(?, ?, ?)";
//			
//			PreparedStatement pstmt = null;
//			int salesNo = 2;
//			int prodNo = 10;
//			int qty = 5;
//			try {
//				pstmt = connectKit.getConnection().prepareStatement(insertQuery);
//				pstmt.setInt(1,  salesNo);
//				pstmt.setInt(2,  prodNo);
//				pstmt.setInt(3,  qty);
//				
//				int result =pstmt.executeUpdate();
//				boolean r = updateProduct(prodNo, qty); 
//				if(result == 1 && r == true) {
//					System.out.println("판매 완료");
//					
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
// -----------------------------------------------------
			// CallableStatement 사용
			// CallableStatement : DataBase 서버에 있는 저장 프로시져를 호출
			java.sql.CallableStatement cstmt = null;
			try {
				cstmt = connectKit.getConnection().prepareCall("{call SALESPROC(?,?,?,?)}");

				// in 매개변수에 대한 설정
				cstmt.setInt(1, 4);
				cstmt.setInt(2, 30);
				cstmt.setInt(3, 3);
				
				// out 매개변수에 대한 설정
				cstmt.registerOutParameter(4, java.sql.Types.VARCHAR);
				
				// 저장 프로시저 호출
				cstmt.executeUpdate();

				// 저장 프로시저에서 out 매개변수값 얻어오기
				String result = cstmt.getString(4);

				if (result.equals("TRUE")) {
					System.out.println("판매 완료");
				} else if (result.equals("FALSE")) {
					System.out.println("판매 실패");
				}

				cstmt.close();
				connectKit.getConnection().close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static boolean updateProduct(int prodNo, int qty) {
		boolean result = false;
		// TODO Auto-generated method stub
		DBConnectKit connectKit = new DBConnectKit();
		if (connectKit.getConnection() != null) {
			String q = "update products set prodqty = prodqty -2 where prodno = 20";
			PreparedStatement pstmt = null;
			try {
				pstmt = connectKit.getConnection().prepareStatement(q);
				pstmt.setInt(1, qty);
				pstmt.setInt(2, prodNo);

				int i = pstmt.executeUpdate();
				if (i == 1) {

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}
