package ex03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class ScoreDao {
	private static ScoreDao instance = new ScoreDao();
	private ScoreDao() { }
	public static ScoreDao getInstance() {
		return instance;
	}
	
	public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String ID = "USER01";
	public static final String PW = "1234";
	
	private Connection getConnection() {
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, ID, PW);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) try { rs.close(); } catch (Exception e) { }
		if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
		if (conn != null) try { conn.close(); } catch (Exception e) { }
	}
	
	public boolean addScore(ScoreVo scoreVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			StringBuffer sb = new StringBuffer();
//			sb.append("INSERT INTO TBL_SCORE (USERNAME, SCORE)");
//			sb.append("VALUES ('" + username + "', " + score + ")");
			sb.append("INSERT INTO TBL_SCORE (USERNAME, SCORE)");
			sb.append("VALUES (?, ?)");
			pstmt = conn.prepareStatement(sb.toString());
			// 데이터 바인딩
			pstmt.setString(1, scoreVo.getUsername()); // 작은따옴표를 자동으로 붙임
			pstmt.setInt(2, scoreVo.getScore());
			// 입력, 수정, 삭제 작업
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return false;
	}
	
	// 읽기
	public Vector<ScoreVo> getAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT USERNAME, SCORE FROM TBL_SCORE");
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			Vector<ScoreVo> vec = new Vector<>();
			while (rs.next()) {
				String username = rs.getString("USERNAME");
				int score = rs.getInt("SCORE");
				ScoreVo scoreVo = new ScoreVo();
				scoreVo.setUsername(username);
				scoreVo.setScore(score);
				vec.add(scoreVo);
			}
			return vec;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return null;
	}
} // class
