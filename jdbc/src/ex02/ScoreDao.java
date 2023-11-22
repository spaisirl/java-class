package ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ScoreDao {
	
	private static ScoreDao instance = new ScoreDao();
	
	private ScoreDao() {
		
	}
	
	public static ScoreDao getInstance() {
		return instance;
	}
	
	public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String ID = "USER01";
	public static final String PW = "1234";
	
	
	public boolean addScore(String username, int score) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, ID, PW);
			StringBuffer sb = new StringBuffer();
			//sb.append("INSERT INTO TBL_SCORE(USERNAME, SCORE)");
			//sb.append("VALUES ('" + username + "'," + score + ")");
			sb.append("INSERT INTO TBL_SCORE(USERNAME, SCORE)");
			sb.append("VALUES (?,?)");
			pstmt = conn.prepareStatement(sb.toString());
			// 데이터 바인딩
			pstmt.setString(1, username); // 작은 따음표는 자동으로 붙임
			pstmt.setInt(2, score);
			//pstmt = conn.prepareStatement(sb.toString());
			// 입력, 수정, 삭제 작업
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			if(pstmt != null) try {pstmt.close();} catch(Exception e) {}
			if(conn != null) try {conn.close();} catch(Exception e) {}
		}
		return false;
	}
}
