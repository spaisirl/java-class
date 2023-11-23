package sql_exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class SqlExamDao {
	// 싱글톤
	private static SqlExamDao instance = new SqlExamDao();
	private SqlExamDao() { }
	public static SqlExamDao getInstance() {
		return instance;
	}
	

	
	// 접속 정보
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String ID = "SQL_EXAM";
	private static final String PW = "EXAM5678";
	
	// 접속 메서드
	public Connection getConnection() {
		try {
			// 1. SQL Command Line 띄우기
			Class.forName(DRIVER_NAME);
			// 2. 접속(conn USER01/1234)
			Connection conn = DriverManager.getConnection(URL, ID, PW);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// 닫기 메서드
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) try { rs.close(); } catch (Exception e) { }
		if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
		if (conn != null) try { conn.close(); } catch (Exception e) { }
	}
	
	// 입력 기능 - INSERT
	public boolean addInfo(SqlExamVo info) {
		System.out.println("info:" + info);
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = this.getConnection();
			// 3. 쿼리문 작성
			String sql = "INSERT INTO TBL_STUDENT "
					+ "		(SNO, SNAME, SYEAR, GENDER, "
					+ "		 MAJOR, SCORE)"
					+ "   VALUES (?, ?, ?, ? ,?, ?)";
			// 4. 쿼리문 실행
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, info.getSno());
			pstmt.setString(2, info.getSname());
			pstmt.setInt(3, info.getSyear());
			pstmt.setString(4, info.getGender());
			pstmt.setString(5, info.getMajor());
			pstmt.setInt(6, info.getScore());
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
	
	// 수정 기능
	public SqlExamVo getInfo(String sno) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    SqlExamVo info = null;

	    try {
	        conn = this.getConnection();
	        String sql = "SELECT SNO, SNAME, SYEAR, GENDER, "
	                   + "CASE MAJOR "
	                   + "    WHEN 1 THEN '경영' "
	                   + "    WHEN 2 THEN '화학' "
	                   + "    WHEN 3 THEN '컴퓨터공학' "
	                   + "    WHEN 4 THEN '피아노' "
	                   + "    ELSE 'Unknown' END AS MAJOR, "
	                   + "SCORE FROM TBL_STUDENT WHERE SNO=?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, sno);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            String sname = rs.getString("SNAME");
	            Integer score = rs.getInt("SCORE");
	            Integer syear = rs.getInt("SYEAR");
	            String major = rs.getString("MAJOR");
	            String gender = rs.getString("GENDER");
	            info = new SqlExamVo(sno, sname, syear, gender, major, score);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        closeAll(rs, pstmt, conn);
	    }

	    return info;
	}

	// 삭제 기능
	public boolean delete(String name) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;

	    try {
	        conn = this.getConnection();
	        String sql = "DELETE FROM TBL_STUDENT WHERE SNAME = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, name);

	        int count = pstmt.executeUpdate();
	        return count > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        closeAll(null, pstmt, conn);
	    }

	    return false;
	}

	// 전체 조회 기능
	public Vector<SqlExamVo> getAll() {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
	        conn = this.getConnection();
	        String sql = "SELECT SNO, SNAME, SYEAR, GENDER, "
	                   + "CASE MAJOR "
	                   + "    WHEN 1 THEN '경영' "
	                   + "    WHEN 2 THEN '화학' "
	                   + "    WHEN 3 THEN '컴퓨터공학' "
	                   + "    WHEN 4 THEN '피아노' "
	                   + "    ELSE 'Unknown' END AS MAJOR, "
	                   + "SCORE FROM TBL_STUDENT";
	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        Vector<SqlExamVo> vec = new Vector<>();

	        while (rs.next()) {
	            String sno = rs.getString("SNO");
	            String sname = rs.getString("SNAME");
	            Integer score = rs.getInt("SCORE");
	            Integer syear = rs.getInt("SYEAR");
	            String major = rs.getString("MAJOR");
	            String gender = rs.getString("GENDER");
	            SqlExamVo info = new SqlExamVo(sno, sname, syear, gender, major, score);
	            vec.add(info);
	        }
	        return vec;
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        closeAll(rs, pstmt, conn);
	    }
	    return null;
	}
	
	/*
	// 검색 기능
	public Vector<SqlExamVo> search(SearchDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			String sql = "SELECT * FROM TBL_STUDENT"
					+ " WHERE " + dto.getSearchOption() 
					+ " LIKE '%' || ? || '%'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getKeyword());
			rs = pstmt.executeQuery();
			Vector<SqlExamVo> vec = new Vector<>();
			while (rs.next()) {
				String sno = rs.getString("SNO");
				String sname = rs.getString("SNAME");
				Integer score = rs.getInt("SCORE");
				Integer syear = rs.getInt("SYEAR");
				String major = rs.getString("MAJOR");
				String gender = rs.getString("GENDER");
				SqlExamVo info = new SqlExamVo(sno, sname, syear, gender, major, score);
				vec.add(info);
			}
			return vec;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return null;
	}
	*/

	/*
	 * 아래 코드와 비교하기
	public boolean getInfo(String sno) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	    	conn = this.getConnection();
	        String sql = "SELECT * FROM TBL_STUDENT WHERE SNO=?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, sno);

	        int count = pstmt.executeUpdate();
	        return count > 0;
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        closeAll(rs, pstmt, conn);
	    }

	    return false;
	}
	*/
	
	public boolean isStudentExists(String sno) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = this.getConnection();
	        String sql = "SELECT COUNT(*) FROM TBL_STUDENT WHERE SNO=?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, sno);

	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            int count = rs.getInt(1);
	            return count > 0;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        closeAll(rs, pstmt, conn);
	    }

	    return false;
	}

	
}
