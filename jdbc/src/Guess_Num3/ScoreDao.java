package Guess_Num3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class ScoreDao extends BasicAbstractDao {
	private static ScoreDao instance = new ScoreDao();
	private ScoreDao() { }
	public static ScoreDao getInstance() {
		return instance;
	}
	
	public boolean addScore(ScoreVo scoreVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("INSERT INTO TBL_SCORE "
					+ "	(SCORE_ID, USER_ID, SCORE)");
			sb.append(" VALUES "
					+ "	(SEQ_SCORE_ID.NEXTVAL, ?, ?)");
			pstmt = conn.prepareStatement(sb.toString());
			// 데이터 바인딩
			pstmt.setString(1, scoreVo.getUserId()); // 작은따옴표를 자동으로 붙임
			pstmt.setInt(2, scoreVo.getScore());
			// 입력, 수정, 삭제 작업
			int count = pstmt.executeUpdate();
			if (count > 0) {
				System.out.println("데이터입력완료");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
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
	
	// 읽기
	
	public Vector<ScoreUserVo> getAll(RowNumDto rowNumDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
//			String sql = "SELECT U.USER_ID, U.USER_NAME, S.SCORE, S.REGDATE, G.GRADE"
//					+ "   FROM TBL_USER U, TBL_SCORE S, TBL_SCORE_GRADE G"
//					+ "   WHERE U.USER_ID = S.USER_ID"
//					+ "   AND S.SCORE BETWEEN G.LO_SCORE AND G.HI_SCORE"
//					+ "   ORDER BY S.SCORE ASC, U.USER_ID ASC";
			
			String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT U.USER_ID, U.USER_NAME, S.SCORE, S.REGDATE, G.GRADE"
					+ "                            FROM TBL_USER U, TBL_SCORE S, TBL_SCORE_GRADE G"
					+ "                            WHERE U.USER_ID = S.USER_ID"
					+ "                            AND S.SCORE BETWEEN G.LO_SCORE AND G.HI_SCORE"
					+ "                            ORDER BY S.SCORE ASC, U.USER_ID ASC) A)"
					+ "   WHERE RN BETWEEN ? AND ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rowNumDto.getStartRow());
			pstmt.setInt(2, rowNumDto.getEndRow());
			rs = pstmt.executeQuery();
			Vector<ScoreUserVo> vec = new Vector<>();
			while (rs.next()) {
				int rn = rs.getInt("RN");
				String userId = rs.getString("USER_ID");
				String userName = rs.getString("USER_NAME");
				int score = rs.getInt("SCORE");
				Date regdate = rs.getDate("REGDATE");
				String grade = rs.getString("GRADE");
				ScoreUserVo scoreUserVo = new ScoreUserVo(rn, userId, userName, score, regdate, grade);		
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
	
	// 전체 데이터 갯수
	public int getCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "SELECT COUNT(*) CNT FROM TBL_SCORE";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt("CNT");
				return count;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return 0;
	}
	
} // class
