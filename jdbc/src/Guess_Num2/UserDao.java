package Guess_Num2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

	private static UserDao instance = new UserDao();
	
	private UserDao() {
		
	}
	
	public static UserDao getInstance() {
		return instance;
	}
	
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String ID = "USER01";
	private static final String PW = "1234";
	
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
	
	public boolean addUser(UserVo userVo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "INSERT INTO TBL_USER" 
			+ "  (USER_ID, USER_PW, USER_NAME, USER_EMAIL)"
			+ "  VALUES (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			// 데이터 바인딩
			pstmt.setString(1, userVo.getUserId());
			pstmt.setString(2, userVo.getUserPw());
			pstmt.setString(3, userVo.getUserName());
			pstmt.setString(4, userVo.getUserEmail());
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
	
	public UserVo login(LoginDto loginDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "SELECT * FROM TBL_USER"
					+ " WHERE USER_ID = ?"
					+ " AND USER_PW = ?";
			String userId = loginDto.getId();
			String userPw = loginDto.getPw();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String userName = rs.getString("USER_NAME");
				String userEmail = rs.getString("USER_EMAIL");
				UserVo userVo = new UserVo(userId, userPw, userName, userEmail);
				return userVo;
			}
		} catch (Exception e) {
			
		e.printStackTrace();
		
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return null;
	}
}

