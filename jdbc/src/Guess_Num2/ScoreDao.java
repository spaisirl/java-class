package Guess_Num2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

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
	private static final int MIN_SCORE = 30000;
	
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
		if (rs != null) try {rs.close();} catch (Exception e) {}
		if (pstmt != null) try {pstmt.close();} catch (Exception e) {}
		if (conn != null) try {conn.close();} catch (Exception e) {}
		
	}
	public boolean addScore(ScoreVo scoreVo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			StringBuffer sb = new StringBuffer();
			//sb.append("INSERT INTO TBL_SCORE(USERNAME, SCORE)");
			//sb.append("VALUES ('" + username + "'," + score + ")");
			sb.append("INSERT INTO TBL_SCORE "	+ "	(SCORE_ID, USER_ID, SCORE)");
			sb.append(" VALUES " + "	(SEQ_SCORE_ID.NEXTVAL, ?, ?)");
			//sb.append("VALUES (SEQ_SCORE_ID_NEXTVAL'" + userVo.getUserId() + "'," + scoreVo.getScore() + ", SYSDATE)");
			pstmt = conn.prepareStatement(sb.toString());
			// 데이터 바인딩
			pstmt.setString(1, scoreVo.getUserId()); // 작은 따음표는 자동으로 붙임
			pstmt.setInt(2, scoreVo.getScore());
			//pstmt = conn.prepareStatement(sb.toString());
			// 입력, 수정, 삭제 작업
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return false;
	}
	
	
	public int getMinScore() {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = getConnection();
	        String sql = "SELECT MIN(SCORE) AS MIN_SCORE FROM TBL_SCORE";
	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            int minScore = rs.getInt("MIN_SCORE");
	            return minScore;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        closeAll(rs, pstmt, conn);
	    }
	    return MIN_SCORE;
	}
	
	
	
	//읽기
	
	public Vector<ScoreUserVo> getAll(RowNumDto rowNumDto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
//			String sql = "SELECT U.USER_ID, U.USER_NAME, S.SCORE, S.REGDATE, G.GRADE"
//			+ "   FROM TBL_USER U, TBL_SCORE S, TBL_SCORE_GRADE G"
//			+ "   WHERE U.USER_ID = S.USER_ID"
//			+ "   AND S.SCORE BETWEEN G.LO_SCORE AND G.HI_SCORE"
//			+ "   ORDER BY S.SCORE ASC, U.USER_ID ASC";

			String sql = "SELECT * FROM (SELECT ROWNUM RN, A. * FROM (SELECT U.USER_ID, U.USER_NAME, "
					+ "		S.SCORE, S.REGDATE, G.GRADE_SCORE"
					+ "  	FROM TBL_USER U, TBL_SCORE S, TBL_SCORE_GRADE G"
					+ " 	WHERE U.USER_ID = S.USER_ID"
					+ " 	AND S.SCORE BETWEEN G.LO_SCORE AND G.HI_SCORE"
					+ " 	ORDER BY S.SCORE ASC, U.USER_ID ASC) A)"
					+ " WHERE RN BETWEEN ? AND ?";
				
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rowNumDto.getStartRow()); 
			pstmt.setInt(2, rowNumDto.getEndRow());
			rs = pstmt.executeQuery();
			Vector<ScoreUserVo> vec = new Vector<>();
			while (rs.next()) {
				String userId = rs.getString("USER_ID");
				String userName = rs.getString("USER_NAME");
				int score = rs.getInt("SCORE");
				Date regdate = rs.getDate("REGDATE");
				String grade = rs.getString("GRADE_SCORE");
				ScoreUserVo scoreUserVo = new ScoreUserVo(userId, userName, score, regdate, grade);
				vec.add(scoreUserVo);
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
